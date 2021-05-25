public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    //the first item is at sentinel.next
    private IntNode sentinel;
    private int size;

    //single linked list null constructor
    public SLList() {
        sentinel = new IntNode(63, null); //we do not care about the number
        size = 0;
    }
    //with one item constructor
    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    //add item x to first of the SLList
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    //get the first item of SLList
    public int getFirst() {
        return sentinel.next.item;
    }

    //add last item to SLList
    public void addLast(int x) {
        //create a pointer and iterative till the end
        size += 1;
        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    //delete the first item in SLList
    public void deleteFirst() {
        //the first item or the second item can be null
        if (size == 0) {
            System.out.println("SLList does not have a first item to delete!");
            return;
        }
        //create a pointer to the second item
        IntNode p = sentinel.next.next;
        sentinel.next = p;
        size -= 1;
    }

    //return the size of SLList
    public int size() {
        return size;
    }

    //how to use
    public void main(String[] args) {
        SLList L = new SLList(15);
        //L.addFirst(10);
        //L.addFirst(5);
        int x = L.getFirst();
        L.deleteFirst();
        System.out.println(L.size());
    }
}