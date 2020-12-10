package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		isPossibles(new int[] {1,2,3,3,4,4,5,7});
	}
	public static boolean isPossible(int[] nums) {
        //哈希表 记录值坐标  最小堆记录连续的个数实现
		Map<Integer,PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
		for(int i : nums) {
			//如果map中不存在则直接添加
			//不判断map中存在当前key
			if(!map.containsKey(i)) {
				map.put(i, new PriorityQueue<Integer>());
			}
			//如果map中存在key 为当前减一
			if(map.containsKey(i - 1)) {
				//取出最小堆的值(取出的为最小堆的最小数即最小连续的个数)
				Integer poll = map.get(i - 1).poll();
				//如果当前最小堆没有值则删除
				if(map.get(i - 1).isEmpty()) {
					map.remove(i - 1);
				}
				//加1 并添加到当前坐标下
				map.get(i).offer(poll + 1);
			}else {
				//不存在则往最小堆塞入最小值1
				map.get(i).offer(1);
			}
		}
		for(PriorityQueue<Integer> p : map.values()) {
			if(p.peek() < 3) {
				return false;
			}
		}
		return true;
    }
	
	public static boolean isPossibles(int[] nums) {
        int n = nums.length;
        int dp1 = 0;    // 长度为1的子序列数目
        int dp2 = 0;    // 长度为2的子序列数目
        int dp3 = 0;    // 长度>=3的子序列数目
        int idx = 0;
        int start = 0;  // 起始位置

        while(idx < n){
            start = idx;                        // 重新将起始位置赋值
            int x = nums[idx];
            while(idx < n && nums[idx] == x){   
                idx++;
            }
            int cnt = idx - start;              

            if(start > 0 && x != nums[start - 1] + 1){  // 对于nums[idx] != nums[idx - 1] + 1，说明当前整数无法加入到以nums[idx-1] 为结尾的序列中
                if(dp1 + dp2 > 0){                      // 如果 dp1+dp2>0，说明有些长度≤2的序列无法被满足，因此不存在相应的分割方案。
                    return false;
                }else{                                  // 否则，此前的序列全部作废
                    dp1 = cnt;
                    dp2 = dp3 = 0;
                }
            }else{                                      // 对于nums[idx] == nums[idx - 1] + 1，说明当前整数可以加入到所有以nums[idx-1]为结尾的序列中。假设数组中x的数目为cnt：
                if(dp1 + dp2 > cnt){                    // 首先，根据贪心的策略，我们要尽可能地先把 x 添加到长度≤2 的子序列中，从而尽可能地保证子序列的长度都≥3。如果x的数量不够，说明不存在相应的分割方案。
                    return false;
                }
                int left = cnt - dp1 - dp2;             // 此时 还剩下left = cnt -dp1 -dp2个 nums[idx-1](x)
                int keep = Math.min(dp3,left);          // 尽量将余下的left个整数添加到长度≥3的子序列中
                // 最后，更新 dp1,dp2,dp3的取值
                dp3 = keep + dp2;
                dp2 = dp1;
                dp1 = left - keep;                      // 如果还有剩余，才将开启对应数量的新序列。新序列的数目等于left−keep。
            }
        }

        return dp1 == 0 && dp2 == 0;
    }
}
