/*
 * @Descripttion: 排序算法 
 * @version: 
 * @Author: yht
 * @Date: 2022-04-17 20:57:57
 * @LastEditors: yht
 * @LastEditTime: 2022-04-21 05:15:56
 */
package src;

public class Sort {
    /**
     * @name: 插入排序 
     * @test: test font
     * @msg: 算法时间复杂度O(n²) 
     * @param {int[]} arr
     * @return {*}
     */
    public static void insertSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j > 0 && key < arr[j])
                arr[j+1] = arr[j--];
            arr[j+1] = key;
        }
    }

    /**
     * @name: 归并排序 
     * @test: test font
     * @msg: 算法时间复杂度O(nlog2n)
     * @param {int[]} arr
     * @return {*}
     */
    public static void mergeSort(int[] arr){
        Sort.ms(arr, 0, arr.length-1);
    }
    private static void ms(int[] arr, int p, int r){
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
