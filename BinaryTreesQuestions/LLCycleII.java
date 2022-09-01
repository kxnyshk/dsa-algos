public class LLCycleII {
    
    // https://leetcode.com/problems/linked-list-cycle-ii/
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

        public ListNode detectCycle(ListNode head) {
           if((head == null) || (head.next == null)){
               return null;
            } ListNode detect = Cycle(head.next, head.next.next);
            return (detect == null) ? detect : getHead(head, detect);
        }
        
        private static ListNode getHead(ListNode Node1, ListNode Node2){
            if(Node1 == Node2){
                return Node1;
            } return getHead(Node1.next, Node2.next);
        }
        
        private static ListNode Cycle(ListNode slow, ListNode fast){
            if(fast == null){
                return null;
            } if(fast == slow){
                return fast;
            } return (fast.next != null) ? Cycle(slow.next, fast.next.next) : null;       
        }
    }
}