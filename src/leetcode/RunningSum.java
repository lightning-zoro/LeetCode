package leetcode;

public class RunningSum {
	/**
	 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。

		请返回 nums 的动态和。
	 */
	public int[] runningSum(int[] nums) {
		//直接修改当前下标的值为当前加上前一个的值
		for (int i = 0; i < nums.length; i++) {
			if(i == 0) continue;
			nums[i] = nums[i] + nums[i - 1];
		}
		return nums;
    }
}
