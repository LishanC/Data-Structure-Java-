// Lishan Chan
// CS 111C: Lab C
// DoubleNode.java: Data type used in EntryWayList

public class DoubleNode<T> {
    public T data; // entry in bag
    public DoubleNode<T> next; // link to next node
    public DoubleNode<T> previous; // link to the previous node

    public DoubleNode(T dataPortion) {
        this(dataPortion, null, null);
    }

    public DoubleNode(T dataPortion, DoubleNode<T> nextNode, DoubleNode<T> previousNode) {
        data = dataPortion;
        next = nextNode;
        previous = previousNode;
    }
}
