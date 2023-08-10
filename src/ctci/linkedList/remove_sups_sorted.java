package ctci.linkedList;

import java.util.List;

class ListNode{
    int val;
    ListNode next = null;

    ListNode(){}
    ListNode(int val){
        this.val =val;
    }
    ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}

public class remove_sups_sorted {
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,4,5,5,5,6,7,7,7,8};
        ListNode list = arrToList(arr);
        printList(list);
         ListNode res = delete_dubs(list);
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

    static ListNode delete_dubs(ListNode head){
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }

    static ListNode arrToList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        for(int i =1; i<arr.length ; i++){
                insert(head,arr[i]);
        }
        return head;
    }
}
