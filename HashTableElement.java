/**
 * @author Aditya Phalod
 * T00678151
 * Describes the name and the ISBN of the books used for the hash table.
 */
public class HashTableElement
{
  private String name; //name of the book
  private int ISBN; //ISBN of the book
  private boolean deleted; //to determine of an element was deleted

  public HashTableElement(String name, int ISBN){
    this.name = name;
    this.ISBN = ISBN;
    this.deleted = false;
  }

  /**
   * Public method to get the Name
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Public method to change the value of name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Public method to get the ISBN
   * @return ISBN
   */
  public int getISBN() {
    return ISBN;
  }

  /**
   * Public method to check whether an element has been deleted
   * @return deleted
   */
  public boolean isDeleted() {
    return deleted;
  }

  /**
   * Public method to change the value of deleted
   */
  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  public String toString(){
    return "Name: " + name + " ISBN: " + ISBN;
  }
}