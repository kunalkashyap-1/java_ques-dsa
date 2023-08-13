package ctci.linkedList;

public class partition_num {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,7,12,4,9,8};
        ListNode list = arrToList(arr);
        printList(list);
        ListNode res = partition(list,4);
        printList(list);
    }
    static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode list1 = less;
        ListNode greater = new ListNode();
        ListNode list2 = greater;

        ListNode dummy = head;
        while(dummy != null){
            if(dummy.val >= x){
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
