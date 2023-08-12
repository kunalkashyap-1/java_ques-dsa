package ctci.linkedList;

import java.util.HashSet;

public class kth_last_el {
    public static void main(String[] args) {
        int[] arr = {2,1,4,3,6,5,8,9,12};
        ListNode list = arrToList(arr);
        printList(list);
        System.out.println(kth_el(list,2));
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

    static int kth_el(ListNode head, int n){
       ListNode p1 = head;
       ListNode p2 = head;
       for(int i =0; i<n; i++){
           if(p1 == null){
               return -1;
           }
           p1=p1.next;
       }
       while(p1 != null){
           p1 = p1.next;
           p2 = p2.next;
       }
       return p2.val;
    }

    static ListNode arrToList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        for(int i =1; i<arr.length ; i++){
            insert(head,arr[i]);
        }
        return head;
    }
}
