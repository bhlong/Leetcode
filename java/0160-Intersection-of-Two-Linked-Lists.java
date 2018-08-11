/*

Problem Statement:

Write a program to find the node at which the intersection of two singly linked lists begins.


Example:

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

*/

/*

Thought Process:

We get length of A and B, then move the longer one up by the difference, then compare each node.

*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode curr = headA;
        while(curr != null){
            aLength++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            bLength++;
            curr = curr.next;
        }

        ListNode longer = null;
        ListNode shorter = null;
        if(aLength > bLength){
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
        }

        int difference = Math.abs(aLength - bLength);
        while(difference > 0){
            longer = longer.next;
            difference--;
        }
        while(longer!=shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/