import java.util.ArrayList;

// ****************************************************
// Array list-based implementation of ADT list.
// ****************************************************
public class ListArrayListBased implements ListInterface 
{
  // reference to linked list of items
   private ArrayList<Object> list;

   public ListArrayListBased() 
   {
      list = new ArrayList<Object>();
   }   
   
   public boolean isEmpty() 
   {
      return list.size() == 0;
   }

   public int size() 
   {
      return list.size();
   }

   public Object get(int index) 
                throws ListIndexOutOfBoundsException 
   {
      try 
      {
          Object dataItem = list.get(index-1);
          return dataItem;
      }
      catch (IndexOutOfBoundsException e)
      {
         throw new ListIndexOutOfBoundsException(
                "List index out of bounds on get");
      } // end if
   } // end get

   public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {

      try
      {
         list.add(index-1,item);
      }
      catch(IndexOutOfBoundsException e)
      {   
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on add");
      } 
   }  // end add

   public void remove(int index) 
                     throws ListIndexOutOfBoundsException 
   {
       try
      {
         list.remove(index-1);
      }
      catch(IndexOutOfBoundsException e)
      {   
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds on remove");
      } 
   }   // end remove

   public void removeAll() 
   {
       // setting head to null causes list to be
       // unreachable and thus marked for garbage 
       // collection
      list = new ArrayList<Object>();
   } // end removeAll

} // end ListReferenceBased