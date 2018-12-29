package 二进制表示;

import org.junit.Test;

public class Mian {
    public static void main(String[] args){
        String binary = Integer.toBinaryString(-1);
        System.out.println(binary.length());
    }

    /**
     * 转16进制
     */
    @Test
    public void str2HexStr() {

        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        String origin = "1F601";
        byte[] bs = origin.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        System.out.println(sb.toString());
    }
}
