package src;

public class Sort {
    //插入排序
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j > 0 && key < arr[j])
                arr[j+1] = arr[j--];
            arr[j+1] = key;
        }
    }

    //归并排序
    public static void mergeSort(int[] arr){
        Sort.ms(arr, 0, arr.length-1);
    }
    public static void ms(int[] arr, int p, int r){
        if(r > p) {
            int q = (p + r) / 2;
            ms(arr, p, q);
            ms(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }
    private static void merge(int[] arr, int p, int q, int r){
        int[] tmp = new int[r - p + 1];
        int left = p, right = q + 1, i = 0;
        while(left <= q && right <= r)
            tmp[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        while(left <= q) tmp[i++] = arr[left++];
        while(right <= r) tmp[i++] = arr[right++];
        i = 0;
        while(i < tmp.length) arr[p+i] = tmp[i++];
    }
}
