package ctci.linkedList;

public class Sum_list {
    public static void main(String[] args) {
        int[] l1 = {9,9,9,9,9,9,9};
        int[] l2 = {9,9,9,9};
        ListNode list1 = arrToList(l1);
        ListNode list2 = arrToList(l2);
        printList(list1);
        printList(list2);
        ListNode res = sum(list1, list2);
        printList(res);
    }

    static ListNode sum(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(); // Create a dummy node to simplify insertion
        ListNode curr = dummy; // Current node for building the result list
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int sum = carry;

            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            carry = sum / 10; // Calculate carry for next iteration
            sum %= 10; // Calculate current digit value

            curr.next = new ListNode(sum); // Add the sum to the result list
            curr = curr.next;
        }

        return dummy.next; // Return the actual result list (skip the dummy node)
    }


    static void insert(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
        }else{
            ListNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    static void printList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }


    static ListNode arrToList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        for(int i =1; i<arr.length ; i++){
            insert(head,arr[i]);
        }
        return head;
    }
}
