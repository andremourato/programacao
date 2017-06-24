package p2utils;

public class BSTNode<E> {
	
	final String key;
	E elem;
	BSTNode<E> left;
	BSTNode<E> right;
	
	BSTNode(String key, E elem){
		this.key = key;
		this.elem = elem;
	}
	
	public boolean contains(String key){
		int i = key.compareTo(this.key);
		if(i < 0) //Searches the left tree
			if(left != null)
				return left.contains(key);
			else //The key doesn't exist
				return false;
			
		else if(i > 0) //Searches the right tree
			if(right != null)
				return right.contains(key);
			else //The key doesn't exist
				return false;
		
		else //Found the key
			return true;
	}
	
	public String toString(){
		return "(" + key + " ," + elem + ")";
	}
	
	//Used for deleting a node
	//Searches for the minimum key value
	//always searches the left child, because
	//the minimum key value wont have a left child!
	public BSTNode<E> subTreeMin(){
		return subTreeMin(this);
	}
	
	private BSTNode<E> subTreeMin(BSTNode<E> n){
		if(n.left == null)
			return n;
		
		return subTreeMax(n.left);
		
	}
	
	//If we search only the right childs of the
	//nodes we will come across one that won't
	//have a right child. That node is the MAXIMUM
	//of that subtree
	public BSTNode<E> subTreeMax(){
		return subTreeMax(this);
	}
	
	private BSTNode<E> subTreeMax(BSTNode<E> n){
		
		if(n.right == null)
			return n;
		
		return subTreeMax(n.right);
	
	}
	
}

