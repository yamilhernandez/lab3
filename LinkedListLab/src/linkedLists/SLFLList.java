package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import linkedLists.LinkedList;

public class SLFLList<E> implements LinkedList<E>
{

	private SNode<E> first, last; 
	int length = 0; 

	public SLFLList() { 
		first = last = null; 
	}


	public void addFirstNode(Node<E> nuevo) {
		SNode<E> sNuevo= (SNode<E>) nuevo;

		if(length==0) {
			first= last= sNuevo;

		}else {
			SNode<E> temp = first;
			first=sNuevo;
			first.setNext(temp);

		}
		length++;

	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo)  {

		SNode<E> sTarget= (SNode<E>) target;
		SNode<E> sNuevo= (SNode<E>) nuevo;

		if(sTarget.equals(last)) {
			sTarget.setNext(sNuevo);
			last=sNuevo;
		}
		else {
			sNuevo.setNext(sTarget.getNext());
			sTarget.setNext(sNuevo);
		}
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		SNode<E> sTarget= (SNode<E>) target;
		SNode<E> sNuevo= (SNode<E>) nuevo;
		if(sTarget==first) {
			sNuevo.setNext(sTarget);
			first= sNuevo;
		}
		else {
			SNode<E> bTarget= (SNode<E>) this.getNodeBefore(sTarget);
			bTarget.setNext(sNuevo);
			sNuevo.setNext(sTarget);
		}
		length++;

	}

	public Node<E> getFirstNode() throws NodeOutOfBoundsException {
		if(first==null) throw new NodeOutOfBoundsException("");
		return first;
	}

	public Node<E> getLastNode() throws NodeOutOfBoundsException {
		if(last==null) throw new NodeOutOfBoundsException("");
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NodeOutOfBoundsException {
		SNode<E> starget= (SNode<E>) target;

		if(target== last) throw new NodeOutOfBoundsException("getPrevNode(...) : target is the last node.");
		else {
			SNode<E> temp=first;
			while(temp != starget) {
				temp = temp.getNext();
			}
			return temp.getNext();
		}
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NodeOutOfBoundsException {
		SNode<E> starget= (SNode<E>) target;

		if(target== first) throw new NodeOutOfBoundsException("getPrevNode(...) : target is the first node.");
		else {
			SNode<E> temp=first;
			while(temp.getNext()!= starget) {
				temp = temp.getNext();
			}
			return temp;
		}
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		SNode<E> sTarget= (SNode<E>) target;
		if(sTarget==first) {
			first= first.getNext();
		}
		else if(sTarget==last) {
			last= (SNode<E>) this.getNodeBefore(last);
		}
		else {
			SNode<E> bTarget= (SNode<E>) this.getNodeBefore(sTarget);
			bTarget.setNext(sTarget.getNext());
			
		}
		length--;

	}

	public Node<E> createNewNode() {
		return new SNode<E>();
	}


	///////////////////////////////////////////////////
	// private and static inner class that defines the 
	// type of node that this list implementation uses
	private static class SNode<T> implements Node<T> {
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
	}

}
