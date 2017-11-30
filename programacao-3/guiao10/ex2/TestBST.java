package aula10.ex2;

public class TestBST {
	
	public static void main(String[] args) {
		
		//Test elements
		Quadrado q1 = new Quadrado(4.0);
		Quadrado q2 = new Quadrado(90.0);
		Quadrado q3 = new Quadrado(1,2,25.0);
		Quadrado q4 = new Quadrado(8,9,15.4);
		Quadrado q5 = new Quadrado(19.2);
		Quadrado q6 = new Quadrado(6,2,12.4);
		Quadrado q7 = new Quadrado(9,4,52.2);
		Quadrado q8 = new Quadrado(14.4);
		
		//The BST
		BinarySearchTree<Quadrado> bst = new BinarySearchTree<>();
		
		//Inserts elements
		bst.insert(q1);
		bst.insert(q3);
		bst.insert(q7);
		bst.insert(q6);
		bst.insert(q4);
		
		System.out.println("The tree " + (bst.contains(q1) ? "contains" : "doesn't contain") + " the element"); //TRUE
		System.out.println("The tree " + (bst.contains(q7) ? "contains" : "doesn't contain") + " the element"); //TRUE
		System.out.println("The tree " + (bst.contains(q3) ? "contains" : "doesn't contain") + " the element"); //TRUE
		System.out.println("The tree " + (bst.contains(q8) ? "contains" : "doesn't contain") + " the element"); //FALSE
		System.out.println("The tree " + (bst.contains(q2) ? "contains" : "doesn't contain") + " the element"); //FALSE
		System.out.println();
		
		for(Quadrado q : bst) {
			System.out.println(q);
		}
		
		System.out.println();
		
		Quadrado dummy = q1;
		
		bst.remove(dummy);
		System.out.println("After removing, the tree " +
					(bst.contains(dummy) ? "contains" : "doesn't contain") + " the element");
		dummy = q7;
		
		bst.remove(dummy);
		System.out.println("After removing, the tree " +
					(bst.contains(dummy) ? "contains" : "doesn't contain") + " the element");
		
		
		System.out.println("\nThe BinarySearchTree contains " + bst.size() + " elements.\n");
		
		for(Quadrado q : bst) {
			System.out.println(q);
		}
		
	}
	
}
