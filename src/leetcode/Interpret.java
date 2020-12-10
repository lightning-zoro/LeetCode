package leetcode;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Interpret {

	/**
	 *请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 
	 *按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
	 */
	public static void main(String[] args) {
		interpret("G()(al)");
	}
	public static String interpret(String command) {
		//解题思路 记录（出现的下标和）出现时根据差判断替换为那个字符串
		StringBuffer sb = new StringBuffer();
		int start = 0;
		for (int i = 0; i < command.length(); i++) {
			String str = String.valueOf(command.charAt(i));
			if("G".equals(str)) {
				sb.append(command.charAt(i));
			}
			if("(".equals(str)) {
				start = i;
			}
			if(")".equals(str)) {
				if(i - start == 1) {
					sb.append("o");
				}else {
					sb.append("al");
				}
				start = 0;
			}
		}
		return sb.toString();
    }
}
