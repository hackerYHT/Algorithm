package src;

public class Main{
    public static void main(String[] args) {
        int[] res = new int[]{0, 1, 2, 4, 5, 3, 6, 9, 2, 4, 7, 8};
        Sort.mergeSort(res);
        System.out.println(5);
    }
    public static int getUnsignedByte (byte data){
        return data&0x0FF;
    }
}