package leetcode;

public class MaximumWealth {
	/**
	 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
		客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
	 */
	public static void main(String[] args) {
		maximumWealth(new int[][] {{1,2,3},{3,2,1}});
		
		System.err.println("b(sv".charAt(1));
	}
	public static int maximumWealth(int[][] accounts) {
		//双重循环
		int count = 0;
		int res = 0;
		for(int i = 0; i < accounts.length; i++) {
			for(int j = 0; j < accounts[i].length; j++) {
				count += accounts[i][j];
			}
			res = Math.max(res, count);
			count = 0;
		}
		return res;
    }
}
