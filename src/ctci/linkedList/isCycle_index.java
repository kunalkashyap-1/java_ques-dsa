package ctci.linkedList;

public class isCycle_index {
    public static void main(String[] args) {
        ListNode list = arrToList(new int[]{3, 2, 0, -4});
        ListNode curr = list;
        while (curr.next != null) {
            curr = curr.next;
        }
        printList(list);
        curr.next = list.next;
        System.out.println(detectCycle(list).val);
    }

    static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;  // No cycle
        }

        slow = head;
        while (slow != fast) {
//            System.out.println(slow.val +" "+ fast.val);
            slow = slow.next;
            fast = fast.next;
        }

        return slow;  // Starting node of the cycle
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


    static ListNode arrToList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(head, arr[i]);
        }
        return head;
    }
}
