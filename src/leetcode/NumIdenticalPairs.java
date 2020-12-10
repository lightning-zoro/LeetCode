package leetcode;

public class NumIdenticalPairs {
	
	/**
	 * 给你一个整数数组 nums 。

	如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
	
	返回好数对的数目。
	 */
	public static void main(String[] args) {
		numIdenticalPairs(new int[] {1,2,3,1,1,2,3});
	}
	public static int numIdenticalPairs(int[] nums) {
		//双重for 最外边一层为结束为长度减一 最后一个不能加入计算  内层开始为外层加一结束为长度最大值
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1;j < nums.length; j++) {
				if(nums[i] == nums[j]) count ++;
			}
		}
		return count;
    }
}
