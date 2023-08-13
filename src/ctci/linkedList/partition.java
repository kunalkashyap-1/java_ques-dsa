package ctci.linkedList;

public class partition {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,2};
        int x = 3;
        ListNode list = arrToList(arr);
        printList(list);
        ListNode res = partitioner(list, x);
        printList(res);
    }
    static ListNode partitioner(ListNode head, int n){
        ListNode less = new ListNode();
        ListNode list1 = less;
        ListNode greater = new ListNode();
        ListNode list2 = greater;

        ListNode dummy = head;
        while(dummy != null){
            if(dummy.val >= n){
               greater.next = dummy;
               greater = greater.next;
            }else{
                less.next = dummy;
                less = less.next;
            }
            dummy = dummy.next;
        }
        less.next= list2.next;
        greater.next = null;
        return list1.next;
    }

    static ListNode insert(ListNode head, int data ){
        ListNode newNode = new ListNode(data);
        if(head == null){
            head = newNode;
            return head;
        }else{
            ListNode dummy = head;
            while(dummy.next != null){
                dummy = dummy.next;
            }
            dummy.next = newNode;
            return dummy.next;
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
