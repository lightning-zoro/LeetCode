package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        //第一次吧两个集合的俩数之和当key存入map value 出现的次数 
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
    			int sum = A[i] + B[j];
    			if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
    			else map.put(sum, 1);
    		}
		}
        int res = 0;
        //第二次计算另外俩集合之和的负数 如果map中存在 则去除value值加入res
        for (int i = 0; i < D.length; i++) {
        	for (int j = 0; j < C.length; j++) {
    			int sum = -(C[i] + D[j]);
    			if(map.containsKey(sum)) res += map.get(sum);
    		}
		}
        return res;
    }
}
