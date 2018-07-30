package textgen;

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
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		this.head = new LLNode<>(null);
		this.tail = new LLNode<>(null);
		this.head.next = tail;
		this.head.prev = null;
		this.tail.next = null;
		this.tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) throws NullPointerException
	{
		if (element==null){
			throw  new NullPointerException("NullPointerException");
		}else{
            LLNode addition = new LLNode<>(element);
            addition.next = this.tail;
            addition.prev = this.tail.prev;
            this.tail.prev.next = addition;
            this.tail.prev = addition;
            this.size++;
            return true;
        }

	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if (index<0 || (index > this.size-1)){
			throw new IndexOutOfBoundsException("Error");
		}else{
			LLNode<E> current = this.head;
			for (int i = 0; i<=index; i++){
				current = current.next;
			}
			return current.data;
		}

	}

	/**
	 * Add an element to the list at the specified index
	 * @param  index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> newNode = new LLNode<>(element);
		LLNode<E> currentNode = this.head;
		if (index<0 || index>size-1){
			throw new IndexOutOfBoundsException();
		}
		if (newNode.data==null){
			throw new NullPointerException();
		}
		if (this.size==0){
		    this.add(element);
        }
        else {
            for (int i = 0 ; i<=index; i++){
                currentNode = currentNode.next;
            }
            newNode.prev = currentNode.prev;
            newNode.next = currentNode;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode;
        }
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
	public E remove(int index) throws IndexOutOfBoundsException
	{
	    if (index<0 || index>this.size-1){
	        throw new IndexOutOfBoundsException();
        }else {
            LLNode<E> toRemoved = this.head;
            for (int i = 0; i<=index; i++){
                toRemoved = toRemoved.next;
            }
            toRemoved.prev.next = toRemoved.next;
            toRemoved.next.prev = toRemoved.prev;
            this.size = this.size-1;
            return toRemoved.data;
        }

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
	    LLNode<E> toSet = this.head;
	    for (int i = 0; i<=index; i++){
	        toSet = toSet.next;
        }
        toSet.data = element;
		return null;
	}   
}

class LLNode<E> 
{
	LLNode prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
