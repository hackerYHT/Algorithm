/*
 * @Descripttion: 
 * @version: 
 * @Author: yht
 * @Date: 2022-05-22 18:24:32
 * @LastEditors: yht
 * @LastEditTime: 2022-05-22 18:47:06
 */
package src;

public class dp {
    /**
     * @name: 
     * @test: test font
     * @msg: 
     * @param undefined
     * @param undefined
     * @return {*}
     */
    public static int cutRot(int[] p, int n) {
        if(n == 0) return 0;
        int q = 1 << 32;
        for(int i = 1; i < n; i++)
            q = Math.max(q, p[i] + cutRot(p, n-i));
        return q;
    }    
}
