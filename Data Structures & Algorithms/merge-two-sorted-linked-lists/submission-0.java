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

        ListNode curr1 = list1, curr2 = list2;
        ListNode result = new ListNode();
        ListNode temp = result;


        while (curr1 != null && curr2 != null) {

            if (curr1.val <= curr2.val) {
                result.next = curr1;
                curr1 = curr1.next;

            } else {

                result.next = curr2;
                curr2 = curr2.next;

            }
            result = result.next;
        }

        while (curr1 != null) {

            result.next = curr1;
            curr1 = curr1.next;
            result = result.next;

        }       
        while (curr2 != null) {

            result.next = curr2;
            curr2 = curr2.next;
            result = result.next;


        }
    
    return temp.next;
        
    }
}