package ctci.linkedList;

public class MergeSortList {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(2);
        list.next.next.next.next.next = new ListNode(1);

        ListNode sorted = Sort(list);
        while(sorted != null){
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }

    static ListNode Sort(ListNode list){
        if(list == null || list.next == null){
            return list;
        }

        ListNode left = list;
        ListNode right = getMiddle(list);
        ListNode temp = right.next;
        right.next = null;
        right = temp;

        left = Sort(left);
        right = Sort(right);

        return merge(left,right);
    }

    static ListNode getMiddle(ListNode list){
        ListNode slow = list, fast = list.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if(left != null){
            tail.next = left;
        }
        if(right != null){
            tail.next = right;
        }
        return dummy.next;
    }
}
