/*
 * @Descripttion: 
 * @version: 
 * @Author: yht
 * @Date: 2022-04-21 04:13:12
 * @LastEditors: yht
 * @LastEditTime: 2022-04-27 09:45:35
 */
package src;

public class Main{
    public static void main(String[] args) {
        int[] res = new int[]{0, 1, 2, 4, 5, 3, 6, 9, 2, 4, 7, 8};
        Sort.quickSort(res);
        System.out.println(5);
    }
    public static int getUnsignedByte (byte data){
        return data&0x0FF;
    }
}