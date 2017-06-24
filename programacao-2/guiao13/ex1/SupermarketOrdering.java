import p2utils.*;

public class SupermarketOrdering {
	
	SupermarketOrdering(){ }
	
	public void enterOrder(Order order){
		//Inserts an element in the queue
		orders.in(order);
		numOrders++;
		//Checks if there is a previous request of that product
		if(!products.contains(order.prodName))//If it doesn't it creates a new element
			products.set(order.prodName, order.quantity);
		else //If it does it adds the requested number of elements to the request
			products.set(order.prodName, products.get(order.prodName) + order.quantity);
	}
	
	public Order serveOrder(){
		//Stores the oldest order
		Order served = orders.peek();
		//Decreases the amount of products requested
		products.set(served.prodName, products.get(served.prodName) - served.quantity);
		
		//Removes it from the queue
		orders.out();
		numOrders--;
		return served;
	}
	
	public void displayOrderedProducts(){
		String[] keys = products.keys();
		System.out.print("Ordered products: ");
		for (int i = 0; i < keys.length; i++){
			int requested = products.get(keys[i]);
			if(requested > 0)
				System.out.print(keys[i]+":"+requested+" ");
		}
		System.out.println();
	}
	
	public int numOrders(){
		return numOrders;
	}
	
	private int query(String product){
		return products.get(product);	
	}
	
	private int numOrders = 0;
	private Queue<Order> orders = new Queue<>();
	private BinarySearchTree<Integer> products = new BinarySearchTree<>();
}
