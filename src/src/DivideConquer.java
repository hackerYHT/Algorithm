/*
 * @Descripttion: 算法导论-第4章-分治策略
 * @version: 
 * @Author: yht
 * @Date: 2022-04-21 05:07:48
 * @LastEditors: yht
 * @LastEditTime: 2022-04-21 05:16:49
 */
package src;

public class DivideConquer {
    /**
     * @name: 最大子数组问题 
     * @test: test font
     * @msg: 
     * @param {int[]} arr
     * @return {最大子数组之和}
     */
    public static int fms(int[] arr) {
        return findMaximumSubarray(arr, 0, arr.length)[2];
    }
    private static int[] findMaximumSubarray(int[] arr, int low, int high){
        int mid = (low + high) >> 1;
        int[] left_subarr = findMaximumSubarray(arr, low, mid);
        int[] right_subarr = findMaximumSubarray(arr, mid+1, high);
        int[] cross_subarr = findMaxCrossingSubarray(arr, low, mid, high);
        if(left_subarr[2] == Math.max(cross_subarr[2], Math.max(left_subarr[2], right_subarr[2])))
            return left_subarr;
        else if(right_subarr[2] == Math.max(cross_subarr[2], Math.max(left_subarr[2], right_subarr[2])))
            return right_subarr;
        else
            return cross_subarr;
    }
    private static int[] findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int left_sum = 1 << 31, right_sum = 1 << 31,//取int最小值
            sum = 0, left_index = 0, right_index = 0;
        for (int i = mid; i > low; i--) {
            sum += arr[i];
            if(sum > left_sum){
                left_sum = sum;
                left_index = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if(sum > right_sum){
                right_sum = sum;
                right_index = i;
            }
        }
        return new int[]{left_index, right_index, left_sum + right_sum};
    }
}
