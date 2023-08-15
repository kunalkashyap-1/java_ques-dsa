package ctci.linkedList;
import java.lang.*;

public class interection {
    public static void main(String[] args) {
        int[] listA = {1,9,1,2,4}, listB = {3,2,4};
        ListNode list1 = arrToList(listA);
        ListNode list2 = arrToList(listB);
        printList(list1);
        printList(list2);
        ListNode res = check(list1, list2);
        System.out.println(res.val);
    }
    static ListNode check (ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lenA = 0;
        int lenB = 0;

        while (p1 != null) {
            lenA++;
            p1 = p1.next;
        }

        while (p2 != null) {
            lenB++;
            p2 = p2.next;
        }

        // Reset pointers to the beginning of the lists
        p1 = headA;
        p2 = headB;

        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                p2 = p2.next;
            }
        }
        while(p1 != null && p2 != null){
            if(p1 == p2){
                return p1;
            }
            p1= p1.next;
            p2 = p2.next;
        }
        return null;
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
