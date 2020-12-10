package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
	/**
	 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

		若可行，输出任意可行的结果。若不可行，返回空字符串。
	 */
	public static void main(String[] args) {
		System.err.println(reorganizeString("zhmyo"));
	}
	public static String reorganizeString(String s) {
		//先统计字母出现的次数
		int len = s.length();
		if(len < 2) {
			return s;
		}
		int[] sum = new int[26];
		int maxCount = 0;
		for (int i = 0; i < len; i++) {
			int index = s.charAt(i) - 'a';
			sum[index]++;
			maxCount = Math.max(maxCount, sum[index]);
		}
		//若某一个字母太多则返回空
		if(maxCount > (len + 1)/2) {
			return "";
		}
		//队列中添加出现过的字母 出现次数多的在前边
		PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return sum[letter2 - 'a'] - sum[letter1 - 'a'];
            }
        });
		for(char c = 'a'; c <= 'z'; c++) {
			if(sum[c - 'a'] > 0) {
				pq.offer(c);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		//大于一为了每次取出两个元素
		while(pq.size() > 1) {
			Character poll1 = pq.poll();
			Character poll2 = pq.poll();
			sb.append(poll1);
			sb.append(poll2);
			int index1 = poll1 - 'a',index2 = poll2 - 'a';
			//统计数减一
			sum[index1]--;
			sum[index2]--;
			if(sum[index1] > 0) {
				pq.offer(poll1);
			}
			if(sum[index2] > 0) {
				pq.offer(poll2);
			}
		}
		if(pq.size() > 0) {
			sb.append(pq.poll());
		}
		return sb.toString();
	}
}
