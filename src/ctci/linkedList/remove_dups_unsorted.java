package ctci.linkedList;

import java.util.List;
import java.util.*;

public class remove_dups_unsorted {
    public static void main(String[] args){
        int[] arr = {2,4,3,1,1,2,2,6,8,9};
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
        ListNode dummy = new ListNode();
        dummy.next = head;
        HashSet<Integer> set = new HashSet<>();
        ListNode prev = dummy;
        while(head != null){
            if(set.contains(head.val)){
                prev.next = head.next;
            }else{
                set.add(head.val);
                prev=head;
            }
            head = head.next;
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
