package ctci.linkedList;

public class AddOne {
    public static void main(String[] args) {
        ListNode list = new ListNode(9);
        insert(list, 9);
        insert(list, 9);
        printList(sum(list));
    }

    static ListNode sum(ListNode head) {
        ListNode rev = reverse(head);
        ListNode curr = rev;
        ListNode prev = rev;
        //initial calc
        int sum = curr.val + 1;
        curr.val = sum%10;
        int carry = sum/10;
        curr = curr.next;

        while(curr != null){
            sum = carry + curr.val;
            curr.val = sum%10;
            carry = sum/10;
            prev = curr;
            curr = curr.next;
        }
        if(carry != 0){
            prev.next = new ListNode(carry);
        }
        head = reverse(rev);
        return head;
    }

    static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
