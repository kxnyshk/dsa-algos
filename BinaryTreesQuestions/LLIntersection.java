public class LLIntersection {

    // https://leetcode.com/problems/intersection-of-two-linked-lists/
    // https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
    // LeetCode solution -> class Solution {..}
    
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            return Inter(headA, headB);
        }
        
        private static ListNode Inter(ListNode A, ListNode B){
            ListNode L1 = A; ListNode L2 = B;
            while(L1 != L2){
                if(L1 != null){
                    L1 = L1.next;
                } else{
                    L1 = B;
                }
                
                if(L2 != null){
                    L2 = L2.next;
                } else{
                    L2 = A;
                }
            } return L1;
        }
    }
}