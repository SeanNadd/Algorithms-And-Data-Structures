package linkedlist;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /** Create a new empty LinkedList */
    public MyLinkedList(){
        this.head = new LLNode<E>(null);
        this.tail = new LLNode<E>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    /**
     * Appends an element to the end of the list
     * @param element The element to add
     */
    public boolean add(E element )
    {
        if(element == null) throw new NullPointerException("Cannot add null elements to the list");
        LLNode ellNode = new LLNode<E>(element);
        this.tail.prev.next = ellNode;
        ellNode.next = this.tail;
        ellNode.prev = this.tail.prev;
        this.tail.prev = ellNode;
        this.size++;
        return true;
    }

    /** Get the element at position index
     * @throws IndexOutOfBoundsException if the index is out of bounds. */
    public E get(int index)
    {
        int i = 0;
        if(this.head.next.equals(this.tail) || index < 0) throw new IndexOutOfBoundsException(Integer.toString(index));
        LLNode element = head.next;
        while(i < index){
            element = element.next;
            if(element.equals(this.tail)) throw new IndexOutOfBoundsException(Integer.toString(index));
            i++;
        }

        return (E) element.data;
    }

    private LLNode getNodeByIndex(int index){
        {
            int i = 0;
            if(this.head.next.equals(this.tail) || index < 0) throw new IndexOutOfBoundsException(Integer.toString(index));
            LLNode element = head.next;
            while(i < index){
                element = element.next;
                if(element.equals(this.tail)) throw new IndexOutOfBoundsException(Integer.toString(index));
                i++;
            }

            return element;
        }
    }

    /**
     * Add an element to the list at the specified index
     * @param index The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element )
    {
        LLNode toAdd = new LLNode<E>(element);
        if(element == null) throw new NullPointerException("Cannot add null elements to the list");
        if(this.size == 0 && index == 0){
            add(element);
            return;
        }
        LLNode nextElement = getNodeByIndex(index);
        nextElement.prev.next = toAdd;
        toAdd.prev = nextElement.prev;
        nextElement.prev = toAdd;
        toAdd.next = nextElement;
        this.size++;
    }


    /** Return the size of the list */
    public int size()
    {
        return this.size;
    }

    /** Remove a node at the specified index and return its data element.
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     *
     */
    public E remove(int index)
    {
        LLNode toRemove = getNodeByIndex(index);

        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        this.size--;
        return (E) toRemove.data;
    }

    /**
     * Set an index position in the list to a new element
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element)
    {
        if(element == null) throw new NullPointerException("Elements cannot be null");
        LLNode node = getNodeByIndex(index);
        E oldData = (E) node.data;
        node.data = element;
        return oldData;
    }

}

class LLNode<E>
{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E e)
    {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

}
