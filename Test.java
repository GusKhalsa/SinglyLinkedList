import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;
/**
 * Tests to see if the singly linked list data structure works properly.
 * 
 * @author Gursimran Khalsa
 * @version 31/11/17
 */
public class Test
{
    private SinglyLinkedList<Integer> sll;
    private ListIterator<Integer> it;
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        
    }
    
    //Tests if an element can be added to an empty list and at the end of a list via the iterator. 
    public void testAddingToEmptyList(){
        //Checks if it adds an element via the iterator if it's an empty list
        sll = new SinglyLinkedList<Integer>();
        it = sll.listIterator(0);
        it.add(100);
        System.out.println(it.previous());
        //Checks if it adds to end of the list in iterator.
        it.add(50);
        it.add(25);
    }
    
    //Tests if all elements in a collection is added into the singly linked list data structure.
    public void testCollectionConstructor(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = 0; i <= 20; i++){
            al.add(i);
        }
        sll = new SinglyLinkedList<Integer>(al);
        it = sll.listIterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
    //Tests the size method, including when an element is added via the iterator.
    public void testSizeMethod(){
        sll = new SinglyLinkedList<Integer>();
        //Checks if add works in linked list so it should add to the end
        for(int i = 0; i <= 10; i+=2){
            sll.add(i);
        }
        //Tests if listIterator works at given position
        it = sll.listIterator(2);
        //Checks if size method works
        System.out.println("Size when using sll add method: " + sll.size());
        it.add(11);
        it.add(12);
        //Checks if size is updated if an element is added in the list via an iterator.
        System.out.println("Size after an element is added via the iterator: " + sll.size());
    }
    
    //Tests the next methods
    public void testNext(){
        sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        it = sll.listIterator(0);
        while(it.hasNext()){
            System.out.println("Next: " + it.next());
        }
        ListIterator<Integer> it2 = sll.listIterator(1);
        //Should return the next index which is 2.
        System.out.println("Next index: " + it2.nextIndex());
        it2.next();
        //Should return the size as it is at the end of the list.
        System.out.println("End of list index: " + it2.nextIndex());
        
    }
    
    //Tests the previous methods.
    public void testPrevious(){
        sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        //Sets the iterator position to the end of the list.
        it = sll.listIterator(sll.size());
        while(it.hasPrevious()){
            System.out.println("Previous: " + it.previous());
        }
        ListIterator<Integer> it2 = sll.listIterator(1);
        //Shouldn't decrement each time previous is called.
        System.out.println(it2.previousIndex());
        System.out.println(it2.previousIndex());
        
    }
    
    //Tests a larger list
    public void testSize20K(){
        sll = new SinglyLinkedList<Integer>();
        for(int i = 0; i <=20000; i++){
            sll.add(i);
        }
        it = sll.listIterator(sll.size());
        System.out.println(it.previous());
        it.add(20001);
        System.out.println(it.previous());      
    }
    
    //Tests if it doesn't accept a wrong position.
    public void testWrongPosition(){
        sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        it = sll.listIterator(3);
        
    }
    
    //General adding test.
    public void test(){
        sll = new SinglyLinkedList<Integer>();
        sll.add(1);
        sll.add(2);
        it = sll.listIterator(sll.size());
        it.add(10);
        while(it.hasPrevious()){
            it.previous();
        }
        it.add(7);
    }
}
