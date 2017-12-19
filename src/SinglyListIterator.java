import java.util.ListIterator;
import java.util.NoSuchElementException;

/** 
 * Iterator for the singly linked list data structure.
 * @author Gursimran Khalsa
 * @version 29/11/17
 */
public class SinglyListIterator<E> implements ListIterator<E> {
    // The cursor position.
    private int index;
    
    // Previous node of the cursor.
    private Node<E> previous;
    
    // Next node of the cursor(As shown in the API for list iterator).
    private Node<E> next;
    
    // First node of the singly linked list.
    private Node<E> head;
    
    //The instance of the list that the iterator is used on.
    private SinglyLinkedList<E> list;
    
    
    public SinglyListIterator(int pos, Node<E> head, SinglyLinkedList<E> list){
        index = pos;
        this.head = head;
        this.list = list;
        // Sets the next and previous variables according to the cursor position.
        for(int i = 0; i <= pos; i++){
            if(i == 0){
                next = head;
                previous = null;
            }else{
                previous = next;
                next = next.getRight();
            }
        }
    }

    // -------------------------------------- NEXT ----------------------------------------------------

    /**
     *  @return True if there is a next node, false if not.
     */
    public boolean hasNext(){
        return (next != null);
    }

    /**
     * @return the element of the next node.
     * Checks if there is a next node. 
     * Sets whatever is currently at next as previous and sets the next node to whatever is next of the next node. 
     * Index cursor shifts ahead by one. 
     * If there is no next element then an exception is thrown.
     */
    public E next(){
        if(hasNext()){
            previous = next;
            next = next.getRight();
            index++;
            return previous.getLeft();
        }else{
            throw new NoSuchElementException(); 
        }
    }

    /**
     * @return the next index. 
     * Checks if there is an element next and if there is then it will return the next index.
     * If not then it must be at the end of the list so it returns the size (As stated in the list iterator API).
     */
    public int nextIndex(){
        int nIndex = index;
        if(hasNext()){
            return nIndex+=1;
        }
        return list.size();
    }

    // -------------------------------------- PREVIOUS ------------------------------------------------------

    /**
     * @return true if there is a previous element and false if not.
     */
    public boolean hasPrevious(){
        return (previous != null);
    }
    
    /** 
     * @return The element of the previous node.
     *          A  B  C  D  E 
     *        ^  ^  ^  ^  ^  ^
     * Index  0  1  2  3  4  5
     * If i wanted to call previous when the cursor is at index 3 (So the previous node of D) then the index would 
     * be decremented to 2. Loops through the list until it reaches the index 2 and it keeps track of the previous
     * of the element obtained by this previous call to set it to the field previous and next is set to the node 
     * obtained by this method call.
     * Throws an exception if no element is found.
     */
    public E previous(){
        if(hasPrevious()){
            Node<E> temp = head;
            Node<E> tempPrev = null;
            index--;
            for(int i = 0; i <= index; i++){
                if(i == index && temp == previous){
                    next = temp;
                    previous = tempPrev;
                    return next.getLeft();
                }else{
                    tempPrev = temp;
                    temp = temp.getRight();
                }
            }
        }else{
            throw new NoSuchElementException();
        }
        return null;
    }
    
    //@return The previous index.
    public int previousIndex(){
        int pIndex = index;
        return pIndex-=1;
    }
    
    /**
     * @param The element of any type of a node to add to a list.
     * Adds a node to the list at the position the cursor is currently at.
     * Once added, it can be accessed via a previous() call. (As stated in the API)
     * Shifts the cursor forward to the next index when adding a new node so that a 
     * previous() call would allow the new node to be accessed. 
     */
    public void add(E elem){
        Node<E> newNode = new Node<E>(elem, null);     
        if(previous == null){
            next = newNode;
            next.setRight(head);
            head = next;
            list.setHead(next);
            previous = newNode;
            next = previous.getRight();
        }else if(next == null){
            next = newNode;
            previous.setRight(next);
            previous = next;
            list.setTail(previous);
            next = null;
        }else if(hasNext()){
            previous.setRight(newNode);
            newNode.setRight(next);
            previous = newNode;
        }else if(head == null){
            list.add(elem);
        }
        index++;
        list.incrementSize();
    }
   
    public void remove() {throw new UnsupportedOperationException();}
    public void set(E e) {throw new UnsupportedOperationException();}
}