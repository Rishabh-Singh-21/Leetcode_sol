/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode head;
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        while(k%size>0){
            ListNode curr = head;
            while(curr.next.next != null){
                curr = curr.next;
            }
            int val = curr.next.val;
            curr.next = null;
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            k--;
        }
        return head;
    }
}