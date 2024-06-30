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
    // 1->2
    // 0->1->2->3
    // 

    // 1->2->3->4
    // prev - null, curr = 1, next. = 2
    // 1->2 --- 1->3, 2->1, 2->1->3->4, curr = 3, prev =1, next = 4
    // 3->4 -- 3->null, 1->4, 4->3, prev = 3 next = null
    // 2-1->4->3->null;

    public static void printLL(ModifyLinkedList linkedListHead) {
        // int count = 4;
        while(linkedListHead != null) {
            System.out.println(linkedListHead.val);
            linkedListHead = linkedListHead.nextNode;

        }
    }

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
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
