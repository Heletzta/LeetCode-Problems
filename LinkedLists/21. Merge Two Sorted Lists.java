// 21. Merge Two Sorted Lists

// https://leetcode.com/problems/merge-two-sorted-lists/

/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

 */

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode ptr = merged;
        while (list1 != null) {
            ptr.next = new ListNode();
            ptr = ptr.next;
            if (list2 == null) {
                ptr.val = list1.val;
                ptr.next = list1.next;
                System.out.println("Done: " + ptr.val);
                return merged.next;
            }
            if (list1.val < list2.val) {
                ptr.val = list1.val;
                list1 = list1.next;
                System.out.println("1: " + ptr.val);
            } else {
                ptr.val = list2.val;
                list2 = list2.next;
                System.out.println("2: " + ptr.val);
            }
            
        }
        if (list2 != null) {
            ptr.next = new ListNode();
            ptr = ptr.next;
            ptr.val = list2.val;
            ptr.next = list2.next;
        }
        return merged.next;
    }
}