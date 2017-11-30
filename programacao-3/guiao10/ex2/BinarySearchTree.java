package aula10.ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>> implements Iterable<T> {
	// o elemento do tipo T deve ser comparável para efectuar pesquisas
	// mas como pode herdar a implementação de compareTo() é mais correcto
	// usar <? super T>
	
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
		
		//Used for deleting a node
		//Searches for the minimum key value
		//always searches the left child, because
		//the minimum key value wont have a left child!
		public BSTNode<T> subTreeMin(){
			return subTreeMin(this);
		}
		
		private BSTNode<T> subTreeMin(BSTNode<T> n){
			if(n.left == null)
				return n;
			
			return subTreeMax(n.left);
			
		}
		
		//If we search only the right childs of the
		//nodes we will come across one that won't
		//have a right child. That node is the MAXIMUM
		//of that subtree
		public BSTNode<T> subTreeMax(){
			return subTreeMax(this);
		}
		
		private BSTNode<T> subTreeMax(BSTNode<T> n){
			
			if(n.right == null)
				return n;
			
			return subTreeMax(n.right);
		
		}
	}
	
	private BSTNode<T> root;
	private int numNodes;
	
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	
	public int size() {
		return numNodes;
	}
	
	public void insert(T value) {
		//No duplicate values
		if(contains(value)) return;
		root = insert(value, root);
	}
	
	private BSTNode<T> insert(T value, BSTNode<T> n){
		
		if(n == null){ //If the key doesn't exist, creates a new one
			numNodes++;
			return new BSTNode<T>(value);
		}
		int i = value.compareTo(n.element);
		if(i < 0){ //Searches the left tree
			n.left = insert(value, n.left);
			return n;
		}	
		else { //Searches the right tree
			n.right = insert(value, n.right);
			return n;
		}
	}
	
	public void remove(T value) {
		//The bst must have the given element before removing it
		if(root == null) throw new NullPointerException();
		if(!contains(value)) throw new NoSuchElementException();
		numNodes--;
		root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> n){
		
		int i = value.compareTo(n.element);
		if(i < 0){ //Searches for the node 'key' on the left subtree
			n.left = remove(value, n.left);
		}
		else if(i > 0){ //Searches for the node 'key' on the right subtree
			n.right = remove(value, n.right);
		}
		//Found it. Now we must analyse what type of node it is
		//If it only has 1 child
		else if(n.left == null){
			n = n.right;
		}
		else if(n.right == null){
			n = n.left;
		}
		//If it has 2 children
		else{
			n = n.subTreeMin();
			remove(n.element);
			
			
		}
		return n;
		
	}
	
	public boolean contains(T value) {
		Iterator<T> it = iterator();
		boolean exists = false;
		while(it.hasNext()) {
			if(((T)it.next()).equals(value)) {
				return true;
			}
		}
		return exists;
		
	}
	
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<E> implements Iterator<E> {
		Stack<BSTNode<E>> stack;
	 
		public BSTIterator(BSTNode<E> root) {
			stack = new Stack<BSTNode<E>>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
	 
		public boolean hasNext() {
			return !stack.isEmpty();
		}
	 
		public E next() {
			BSTNode<E> node = stack.pop();
			E top = node.element;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return top;
		}
	}
}