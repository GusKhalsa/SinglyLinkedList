import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.Collection;

/**
 * Singly linked list data structure.
 * @author Gursimran Khalsa
 * @version 27/11/17
 */
public class SinglyLinkedList<E> extends AbstractSequentialList<E> {
    
    // First node of the list.
    private Node<E> head;
    // Last node of the list.
    private Node<E> tail;
    //Size of the list - Amount of elements in the list.
    public int size;

    //Constructor for an empty list.
    public SinglyLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }
    
    /**
     * @param c - The collection to pass into the linked list data structure.
     * Loops through the collection and inserts each element into the data structure using the add() methid
     */
    public SinglyLinkedList(Collection<E> c){
        size = 0;
        for(E element: c)
            this.add(element);
    }

    /**
     * @param The position in the list that the iterator will go to.
     * @return The singly list iterator. 
     * The iterator to use on the singly linked list.
     */
    public ListIterator<E> listIterator(int pos){
        if(pos > size) throw new IndexOutOfBoundsException();
        return new SinglyListIterator<E>(pos, head, this);
    }
    
    /**
     * @return Size of the list.
     * The amount of elements in the list.
     */
    public int size(){
        return size;
    }
    
    // Increments the size of the list when an iterator adds a node.
    public void incrementSize(){
        size++;
    }
    
    /**
     * @param The element of the node to add.
     * @return Always returns true.
     * Adds an element to the end of the list.
     */
    public boolean add(E elem){
        Node<E> addNode = new Node<E>(elem, null);
        if(head == null && tail == null){
            head = addNode;
        }else if(head != null && tail == null){
            head.setRight(addNode);
            tail = addNode;
        }else{
            tail.setRight(addNode);
            tail = addNode;
        }
        size++;
        return true;
    }
    
    /**
     * @param tail - The new tail of the list if it is set in the iterator class.
     * Sets the tail if there is a new tail. 
     */
    public void setTail(Node<E> tail){
        this.tail = tail;
    }
    
     /**
     * @param head - The new head of the list if it is set in the iterator class.
     * Sets the head if there is a new head. 
     */
    public void setHead(Node<E> head){
        this.head = head;
    }
}
