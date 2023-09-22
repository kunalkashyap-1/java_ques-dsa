package ctci.sorting_searches;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class quickSortList {
    // Function to perform quicksort on a linked list
    static ListNode quickSort(ListNode head) {
        // Base case: if the list is empty or has only one element, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Choose a pivot element (e.g., the middle element)
        ListNode mid = findMiddle(head);
        ListNode pivot = mid;
        ListNode prev = null;

        // Partition the list around the pivot
        while (mid != null) {
            ListNode next = mid.next;
            if (next != null && next.val < pivot.val) {
                mid.next = next.next;
                next.next = head;
                head = next;
            } else {
                mid = mid.next;
            }
        }

        // Recursively sort the two partitions
        if (prev != null) {
            prev.next = null;
        }
        ListNode left = quickSort(head);
        ListNode right = quickSort(pivot.next);

        // Merge the sorted partitions
        if (left == null) {
            return pivot;
        }
        ListNode tail = left;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = pivot;

        return left;
    }

    // Function to find the middle node of a linked list
    static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Function to print the elements of a linked list
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head);

        // Sort the linked list using quicksort
        head = quickSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
