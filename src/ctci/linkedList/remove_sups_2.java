package ctci.linkedList;

public class remove_sups_2 {
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,4,5,5,5,6,7,7,7,8};
        ListNode list = arrToList(arr);
        printList(list);
        ListNode res = delete_dubs_2(list);
        printList(res);
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
        while(curr.next != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    static ListNode delete_dubs_2(ListNode head){
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        while(head != null){
            if(head.next != null && head.val == head.next.val){
                //skip nodes that are equal
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }else{
                prev = prev.next;
            }
            head=head.next;
        }
        return dummy.next;
    }

    static ListNode arrToList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        for(int i =1; i<arr.length ; i++){
            insert(head,arr[i]);
        }
        return head;
    }
}
