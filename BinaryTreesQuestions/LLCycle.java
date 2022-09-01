public class LLCycle {
    
    // https://leetcode.com/problems/linked-list-cycle/
    // https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
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

        public boolean hasCycle(ListNode head) {
            if((head == null) || (head.next == null)){
                return false;
            } return Cycle(head.next, head.next.next);
        }
        
        private static boolean Cycle(ListNode slow, ListNode fast){
            if(fast == null){
                return false;
            } if(fast == slow){
                return true;
            } return (fast.next != null) ? Cycle(slow.next, fast.next.next) : false;       
        }
    }
}