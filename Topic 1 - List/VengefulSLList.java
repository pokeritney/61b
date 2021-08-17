public class VengefulSLList<Item> extends SLList<Item> {
    private SLList<Item> deletedItems;

    public VengefulSLList() {
        super();
        deletedItems = new SLList<Item>();
    }

    /** One item constructor */
    public VengefulSLList(Item x){
        super(x);
        deletedItems = new SLList<Item>();
    }
    /** remove the last item and add to deletedItems list */
    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    /** print deleted items. */
    public void printLostItems() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vsl = new VengefulSLList<Integer>();
        vsl.addLast(1);
        vsl.addLast(5);
        vsl.addLast(10);
        vsl.addLast(13);

        vsl.removeLast();
        vsl.removeLast();

        System.out.print("The fallen are: ");
        vsl.printLostItems();
    }

}
