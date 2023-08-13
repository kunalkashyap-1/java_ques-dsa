package ctci.linkedList;

public class reverse_list {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,5,5,5,6,7,7,7,8};
        ListNode list = arrToList(arr);
        printList(list);
        ListNode res = recc_reverseLinkedList(list);
        printList(res);
    }


    static ListNode recc_reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recc_reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
