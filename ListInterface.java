//By Jackie Horton used by Michelle Marin
// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface {
  public boolean isEmpty();
  public int size();
  public void add(int index, Object item) 
                  throws ListIndexOutOfBoundsException;

  public Object get(int index) 
                  throws ListIndexOutOfBoundsException;
  public void remove(int index) 
                  throws ListIndexOutOfBoundsException;
  public void removeAll();
}  // end ListInterface
