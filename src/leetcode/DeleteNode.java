package leetcode;

public class DeleteNode {

	/**
	 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
    }
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
}
