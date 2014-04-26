public class Pile implements ListInterface  
{

    private Node head; 
    private int numItems;

    public Pile() 
    {
         numItems = 0;
         head = null;
    }

   public boolean isEmpty() 
   {
  
    return numItems == 0;
    
   }
   
   public int size() 
   {

      return numItems;

   }

   public void add(int index, Object item) throws ListIndexOutOfBoundsException 
   {
       if (index >= 1 && index <= numItems+1) 
       {
         if (index == 1) 
         {
           Node newNode = new Node(item, head);
           head = newNode;
         } 
         else 
         {
           Node prev = find(index-1);

           Node newNode = new Node(item, prev.getNext());
           prev.setNext(newNode);
           
         } 
         numItems++;
       } 
       else 
       {
         throw new ListIndexOutOfBoundsException("List index out of bounds on add");
       } 
   }

   public Object get(int index) throws ListIndexOutOfBoundsException 
   {
       if (index >= 1 && index <= numItems)
       {
         // get reference to node, then data in node
         Node curr = find(index);
         Object dataItem = curr.getItem();
         return dataItem;
       } 
       else 
       {
         throw new ListIndexOutOfBoundsException("List index out of bounds on get");
       }
   }
   
   public void remove(int index) throws ListIndexOutOfBoundsException 
   {
    if (index >= 1 && index <= numItems) {
      if (index == 1) 
      {
        
        head = head.getNext();
      } 
      else 
      {
        Node prev = find(index-1);
        
        Node curr = prev.getNext(); 
        prev.setNext(curr.getNext());
      }
      
      numItems--;
    } 
    
    else 
    {
      throw new ListIndexOutOfBoundsException("List index out of bounds on remove");
    } 
  }   

  public void removeAll() 
  {
    head = null;
    numItems = 0;
  }
  
   private Node find(int index) 
   {

       Node curr = head;
       for (int skip = 1; skip < index; skip++) 
       {
         curr = curr.getNext();
       } 
       return curr;
   } 

} 