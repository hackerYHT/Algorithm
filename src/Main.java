/*
 * @Descripttion: 
 * @version: 
 * @Author: yht
 * @Date: 2022-04-21 04:13:12
 * @LastEditors: yht
 * @LastEditTime: 2022-06-04 20:53:54
 */
package src;
import java.lang.reflect.*;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] B = {{1, 1, 1}, {0, 1, 0}, {0, 1, 0}};
        int[][] k = dp.matrixMutiply(A, B);
        int o = 0;
        ArrayList<Integer> h = new ArrayList<>();
    }
}