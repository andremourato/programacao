// Altere esta classe para implementar um tipo de dados abstrato que funciona
// como um array, com métodos de put e get.
// A implementação fornecida cria um único array, mas queremos substituí-lo
// por uma lista de blocos (arrays de tamanho blocksize), que poderá crescer
// juntando progressivamente mais blocos à lista.
import p2utils.*;
public class BlockArrayInt
{
	
  /*This LinkedList will keep track of all the blocks that are required*/
  static private LinkedList<BlockArrayInt> blocks = new LinkedList<BlockArrayInt>();
  static private int numberOfBlocks = 0; //Counts the number of blocks required
  
    public BlockArrayInt(int blockSize,int numBlocks)
  {
    assert blockSize > 0;
    assert numBlocks > 0;
    
    //Adds the first element to the List, in the constructor
    //The following elements will be added in the
    //method incrementNumberOfBlocks()
    if(numberOfBlocks == 0) blocks.addLast(this);
    numberOfBlocks++;
    size = blockSize;
    
     //Adds this object to the static linked list
    a = new int[blockSize*numBlocks];
  }

  public int get(int index)
  {
    assert validIndex(index);
    int blockIndex = index/blockSize();
	BlockArrayInt block = blocks.get(blockIndex);
	//Nota: Cheguei a esta equação através da
	//análise teórica do problema
    return block.a()[(blockIndex+1)*blockSize()-index-1];
  }

  public void put(int elem,int index)
  {
    assert validIndex(index);
    int blockIndex = index/blockSize();
	BlockArrayInt block = blocks.get(blockIndex);
    block.a()[(blockIndex+1)*blockSize()-index-1] = elem;
  }

  public void incrementNumberOfBlocks()
  {
	//Adds another BlockArray to the LinkedList
    blocks.addLast(new BlockArrayInt(blockSize(), 1));
    //Extends the size of the 
    size += blockSize();
  }
	
  //Returns the number of elements
  public int size()
  {
    return size;
  }
	
  //Returns the numbers of blocks used
  public int numberOfBlocks()
  {
    return numberOfBlocks;
  }

  //Returns the number of elements
  //that each block can take
  public int blockSize()
  {
    return a.length;
  }

  public boolean validIndex(int index)
  {
    return index >= 0 && index < size();
  }
  
  public int[] a(){
	return a;
  }
  
  private int size;
  private int[] a;
}

