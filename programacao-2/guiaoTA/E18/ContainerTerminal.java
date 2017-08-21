//NMEC: 
//NOME: 
import static java.lang.System.*;

public class ContainerTerminal {
  ContainerStack[] sa;    // the stacks of containers
  int num;  // number of parallel stacks of containers
  int max;  // maximum height of each stack of containers
  int numcontainers;  // number of containers on the terminal
  
  public ContainerTerminal(int num, int max) {
    sa = new ContainerStack[num];
    for (int k = 0; k < num; k++) {
      sa[k] = new ContainerStack(max);
    }
    this.num = num;
    this.max = max;
    numcontainers = 0;
  }
  
  /**
   * Is the terminal full?
   * A full terminal must still have enough free space to enable
   * retrieving any given container.
   */
  public boolean isFull() {
    return numcontainers >= num*max - max;
  }
  
  /**
   * Checks if a container of a certain type exists
   */
  public boolean containerTypeExists(String type) {
    return findStackContaining(type) >= 0;
  }
  
	public void store(Container c){
		assert !isFull();
		for(int i = 0; i < num; i++){
			if(!sa[i].isFull()){
				sa[i].push(c);
				break;
			}
		}
		numcontainers++;
	}
	
	public Container retrieve(String type){
		Container c = null;
		int index = findStackContaining(type);
		ContainerStack stack = sa[index];
		if(index != -1){ //Found a stack containing 'type' container
			int numAbove = stack.search(type);
			//If it needs to move containers to other stacks
			if(numAbove > 0){
				//Moves each container to another stack
				for(int i = 1; i <= numAbove; i++){
					Container container = stack.top();
					stack.pop();
					//Looks for an available stack to move the container
					for(int j = index; i < num; i++){
						ContainerStack temp = sa[findOtherStack(j)];
						if(!temp.isFull()){
							temp.push(container);
							break;
						}
					}
					
				}
			}
			//Retrieves the container
			c = stack.top();
			stack.pop();
			logContainerInfo(c);
			numcontainers--;
		}		
		return c;
	}
  
  /**
   * Find first stack with free space, other than the stackToAvoid.
   * @return the index of the found stack
   */
  private int findOtherStack(int stackToAvoid) {
    assert !isFull();
    int k = 0;
    while (k==stackToAvoid || sa[k].isFull()) {
      k++;
    }
    return k;
  }
  
  /**
   * Find a stack that includes a container with a given type of cargo
   * @return the index of the found stack, or -1 if no such cargo exists.
   */
  private int findStackContaining(String type) {
    int k = 0;
    while (k < num) {
      if (sa[k].search(type) >= 0) return k;
      k++;
    }
    return -1;
  }
  
  public void print() {
    out.printf("Terminal numcontainers=%d isFull=%s\n",
                      numcontainers, isFull());
    for (int k = 0; k < num; k++) {
      out.printf("%2d: %s\n", k, sa[k].toString());
    }
  }

  // Log: historical log of retrieved containers: it's a linked list
  HistoryNode log;

  private void logContainerInfo(Container c) {
    HistoryNode n = new HistoryNode();
    n.type = c.type;
    HistoryNode.numberRetrieved++;
    n.numops = c.numops();
    n.next = log;
    log = n;
  }

	public double averageOpsPerContainer(){
		return (double)(averageOpsPerContainer(log))/(double)HistoryNode.numberRetrieved;
	}
	
	private double averageOpsPerContainer(HistoryNode n){
		if(n == null) return 0;
		return n.numops + averageOpsPerContainer(n.next);
	}

}

