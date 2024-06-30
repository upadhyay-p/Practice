/*
 * Given a linekd list 1->2->3->4->5 convert it into 2->1->4->3->5
 * Identify the pattern and implement it
 * MS hiring manager round question
 */
public class ModifyLinkedList {
    private int val;
    private ModifyLinkedList nextNode;
    public ModifyLinkedList(int n) {
           this.val = n;     
            this.nextNode = null;
    }

    public static ModifyLinkedList modifyLinkedList(ModifyLinkedList linkedListHead) {
        if(linkedListHead == null) return linkedListHead;
        if(linkedListHead!=null && linkedListHead.nextNode == null) 
            return linkedListHead;
        ModifyLinkedList prev, curr, next;
        prev = null;
        curr = linkedListHead;
        next = linkedListHead.nextNode;

        while(curr != null && next != null ) {
            curr.nextNode = next.nextNode;
            next.nextNode = curr;
            if(prev == null) {
                linkedListHead = next;
            } else {
                prev.nextNode = next;
            }
            prev = curr;
            curr = curr.nextNode;
            next = curr == null? null: curr.nextNode;
        }
        return linkedListHead;
    }

    public static void printLL(ModifyLinkedList linkedListHead) {
        // int count = 4;
        while(linkedListHead != null) {
            System.out.println(linkedListHead.val);
            linkedListHead = linkedListHead.nextNode;

        }
    }

    public static void main(String [] args) {
        int []linkedListArr = {1,2,3,4,5,6};
        ModifyLinkedList linkedList = new ModifyLinkedList(0);
        ModifyLinkedList prevPtr = linkedList;
        for(int elem: linkedListArr) {
                prevPtr.nextNode = new ModifyLinkedList(elem);
                prevPtr = prevPtr.nextNode;

        }
        printLL(linkedList.nextNode);
        ModifyLinkedList linkedListHead = modifyLinkedList(linkedList.nextNode);
        System.out.println("Result");

        printLL(linkedListHead);
    }
}
