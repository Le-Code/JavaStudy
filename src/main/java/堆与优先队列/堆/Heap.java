package 堆与优先队列.堆;

import org.junit.Test;

public class Heap {

    /**
     * 建立大堆
     */
    @Test
    public void buildMapHeap(){
        int[] a = new int[]{1,2,3,4,5,6};
        int heapSize = a.length;
        for(int i = heapSize/2;i >= 0;i--) {
            maxHeapfy(a,i,heapSize);
        }
        for (int i = 0;i<heapSize;i++)
            System.out.print(a[i]+" ");
    }

    private int parent(int i) {
        return i/2;
    }
    private int left(int i) {
        return 2*i;
    }
    private int right(int i) {
        return 2*i+1;
    }

    private void maxHeapfy(int []a,int i,int heapSize) {   //数组a，第i个结点，heapSize是数组种实际要排序的元素的长度
        int left = left(i);     //有的时候能够递归到叶子结点，叶子结点无后继，下面两个if都注意到了这一点
        int right = right(i);
        int largest = i;
        if(left < heapSize && a[left] > a[largest]) {   //
            largest = left;
        }
        if(right < heapSize && a[right] > a[largest])
        {
            largest = right;
        }
        if(largest != i) {      //把最大值给父结点
            a[largest] = a[largest] ^ a[i];
            a[i] = a[largest] ^ a[i];
            a[largest] = a[largest] ^ a[i];
            maxHeapfy(a,largest,heapSize);    //发生交换之后还要保证大根堆性质
        }
    }

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

}
