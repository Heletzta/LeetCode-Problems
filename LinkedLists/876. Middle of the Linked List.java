// 876. Middle of the Linked List

// https://leetcode.com/problems/middle-of-the-linked-list/

/*

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

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
    public ListNode middleNode(ListNode head) {
        // find the length of the list
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }

        // get the middle
        int middle = len / 2;
        int i = 0;
        ptr = head;
        while (i < middle) {
            i++;
            ptr = ptr.next;
        }
        return ptr;
    }
}