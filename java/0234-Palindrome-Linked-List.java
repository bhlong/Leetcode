/*

Problem Statement:

Given a singly linked list, determine if it is a palindrome.

Example:

Input: 1->2
Output: false

Input: 1->2->2->1
Output: true

*/

/*

Thought Process:

We reverse the first half of the linked list and compare it with the second half.

*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        ListNode rev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode slowcopy = new ListNode(slow.val);
            slowcopy.next = rev;
            rev = slowcopy;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        
        while(slow != null && rev != null){
            if(slow.val != rev.val) return false;
            slow = slow.next;
            rev = rev.next;
        }
        return true;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/