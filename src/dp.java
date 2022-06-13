/*
 * @Descripttion: 
 * @version: 
 * @Author: yht
 * @Date: 2022-05-22 18:24:32
 * @LastEditors: yht
 * @LastEditTime: 2022-05-23 11:10:24
 */
package src;

public class dp {
    /**
     * @name:cutRot 
     * @test: test font
     * @msg: 剪绳子（自顶向下递归），缺点：很多子问题路径重复
     * @param undefined
     * @param undefined
     * @return {*}
     */
    public static int cutRot(int[] p, int n) {
        if(n == 0) return 0;
        int q = 1 << 31;
        for(int i = 0; i < n; i++)
            q = Math.max(q, p[i] + cutRot(p, n-i-1));
        return q;
    }    
    /**
     * @name:memoizedCutRot 
     * @test: test font
     * @msg: 自顶向下递归带剪枝（备忘录）
     * @param undefined
     * @param undefined
     * @return {*}
     */
    public static int memoizedCutRod(int[] p, int n) {
        int[] r = new int[n+1];
        for(int i = 0; i < n+1; i++)
            r[i] = 1 << 31;
        return memoizedCutRodAux(p, n, r);
    }
    private static int memoizedCutRodAux(int[] p, int n, int[] r) {
        int q = 0;
        if(r[n] >= 0) return r[n];
        if(n == 0) q = 0;
        else{
            q = 1 << 31;
            for (int i = 0; i < n; i++) 
                q = Math.max(q, p[i] + memoizedCutRodAux(p, n - i - 1, r));
        } 
        r[n] = q;
        return q;
    }    
    /**
     * @name:bottomUpCutRod 
     * @test: test font
     * @msg: 自底向上动态规划数组
     * @param undefined
     * @param undefined
     * @return {*}
     */
    public static int bottomUpCutRod(int[] p, int n) {
        int[] r = new int[n+1];
        r[0] = 0;
        int q;
        for (int i = 1; i <= n; i++) {
            q = 1 << 31;
            for(int j = 0; j < i; j++)
                q = Math.max(q, p[j] + r[i - j - 1]);
            r[i] = q;
        }
        return r[n];
    }
    /**
     * @name:matrixMutiply 
     * @test: test font
     * @msg: 矩阵相乘
     * @return {*}
     */
    public static int[][] matrixMutiply(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        if(A[0].length != B.length)
            System.err.println("incompatible dimensions");
        else{
            for(int i = 0; i < A.length; i++){
                for(int j = 0; j < B[0].length; j++){
                    for(int k = 0; k < A[0].length; k++){
                        C[i][j] = C[i][j] + A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}