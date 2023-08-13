package ctci.linkedList;

public class delete_middle {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;  // List is empty or has only one node
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = null;
        while (p2 != null && p2.next != null){
            prev = p1;
            p1=p1.next;
            p2=p2.next.next;
        }
        if(prev != null){
            prev.next = p1.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
