package ctci.linkedList;

public class palindrome_list {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,4,4,2,1};
        ListNode list = arrToList(arr);
        printList(list);
        System.out.println(isPalindrome(list));
    }
    static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) {
            return true; // An empty list or a list with a single node is a palindrome
        }
        ListNode start = head;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1 != null && p1.next != null){
            p1= p1.next.next;
            p2=p2.next;
        }
        p1 = reverse(p2);
        while(p1 != null){
            if(start.val != p1.val){
                return false;
            }
            start = start.next;
            p1= p1.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
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
