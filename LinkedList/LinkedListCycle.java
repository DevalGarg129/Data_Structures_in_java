package LinkedList;
import java.util.*;

class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class LinkedListCycle {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode head = new ListNode(scn.nextInt(), null);
        nodes.add(head);

        ListNode curr = head;

        for(int i = 1; i < n; i++){
            curr.next = new ListNode(scn.nextInt(), null);
            curr = curr.next;
            nodes.add(curr);
        }

        int pos = scn.nextInt();
        if(pos != -1){
            curr.next = nodes.get(pos);
        }

        ListNode slow = head;
        ListNode fast = head;

        Boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }
        System.out.println(cycle);
    }
}
