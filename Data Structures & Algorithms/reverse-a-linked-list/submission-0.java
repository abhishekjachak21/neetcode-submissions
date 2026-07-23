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

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next; //hold next, nahi toh connection tut jayega

            curr.next = prev; //ab next ki jagah pichle ko ref daal

            prev = curr; 

            curr = next;
        }

        return prev; //bcz curr toh null ke upar jakr baitha h
    }
}
// 19july2026, started linkedlist after 4 yrs. during 2023 june, i used to solve these questions