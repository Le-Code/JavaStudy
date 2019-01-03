package 文件.目录;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileOperate {

    /**
     * @param path 找到该目录下所有后缀名为suffix的文件
     * @param suffix
     */
    public void findSuffixFile(String path,String suffix){
        File file = new File(path);
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(suffix))
                    return true;
                return false;
            }
        });
    }

    /**
     * 计算目录下的大小
     * @param directionFile
     * @return
     */
    public long sizeOfDirectory(File directionFile){
        long size = 0;
        if (directionFile.isFile())
            return directionFile.length();
        for (File file:directionFile.listFiles()){
            if (file.isFile())
                size+=file.length();
            else
                size+=sizeOfDirectory(file);
        }
        return size;
    }

    /**
     * 在一个目录下找到所有给定名称的文件
     * @param directory
     * @param fileName
     * @return
     */
    public Collection<File> findFile(File directory,String fileName){
        List<File> files = new ArrayList<>();
        for (File file:directory.listFiles()){
            if (file.isFile()&&file.getName().equals(fileName))
                files.add(file);
            else if (file.isDirectory()){
                files.addAll(findFile(file,fileName));
            }
        }
        return files;
    }

    /**
     * 删除目录首先需要清空目录
     * @param directory
     */
    public void deleteFile(File directory) throws IOException {
        if (directory.isFile()){
            if (!directory.delete()){
                throw new IOException("error");
            }
        }else if (directory.isDirectory()){
            for (File file:directory.listFiles()){
                deleteFile(file);
            }
            if (!directory.delete()){
                throw new IOException("error");
            }
        }
    }


}
