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
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode head = null;
        ListNode prev = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode newNode = new ListNode(l1.val);
                if(prev == null){
                    head = newNode;
                }
                if(prev != null){
                    prev.next = newNode;
                }
                prev = newNode;
                l1 = l1.next;
            }
            else{
               ListNode newNode = new ListNode(l2.val);
               if(prev == null){
                    head = newNode;
                }
                if(prev != null){
                    prev.next = newNode;
                }
                prev = newNode; 
                l2 = l2.next;
            }
            
        }
        while(l1 != null){
            ListNode newNode = new ListNode(l1.val);
            if(prev == null){
                    head = newNode;
                }
            else
                prev.next = newNode;
            prev = newNode;
            l1 = l1.next;
        }
        while(l2 != null){
            System.out.println(l2.val);
            ListNode newNode = new ListNode(l2.val);
            if(prev == null){
                    head = newNode;
                }
            else    
                prev.next = newNode;
            prev = newNode;
            l2 = l2.next;
        }
        return head;
    }
}