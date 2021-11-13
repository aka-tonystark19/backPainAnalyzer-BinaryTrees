import java.util.regex.Pattern;
/**
 * @author Aditya Phalod
 * T00678151
 * This program implements a Hash Table.
*/
public class HashTable 
{
  private static final int INITIAL_SIZE = 11;
  private static final double LOAD_FACTOR = 0.70;

  private HashTableElement[] hashTable;
  private int threshold;
  private int numElements; //number of elements

  public HashTable()
  {
    hashTable = new HashTableElement[INITIAL_SIZE];
    threshold = (int) (LOAD_FACTOR * INITIAL_SIZE);
    numElements = 0;
  }

  /**
   *This method resizes the hash table as needed.
   *This method calls getNewSize which returns an appropriate size for the new hash table
   */
  private void resize()
  {
    numElements = 0; 
    HashTableElement[] oldHashTable = hashTable; 
    hashTable = new HashTableElement[getNewSize()]; //class variable hashTable is now an empty hash table
    for(int i = 0;i < oldHashTable.length; i++){
      if(oldHashTable[i] != null && !oldHashTable[i].isDeleted()){
        try{
          addElement(oldHashTable[i].getName(),oldHashTable[i].getISBN());
        }catch(Exception e){
          System.out.println(e);
        }
      }
    }//end for
    threshold = (int) LOAD_FACTOR * hashTable.length; //set the new threshold
  }

  /**
   * Returns the size of the next hashTable. The returned value is always a prime number, this is done
   * by calling ta private method isPrime.
   * @return the size for a new hash table.
   */
  private int getNewSize(){
    int newSize = hashTable.length*2;
    for(int i =newSize;true;i++){
      if(isPrime(i)){
        newSize = i;
        break;
      }
    }
    return newSize;
  }

  /**
   * Checks if a number is prime
   * @param num
   * @return true if the number is prime and false otherwise
   */
  private boolean isPrime(int num){
    if(num%2==0)
      return false;
    for(int i =3;i*i <= num;i+=2){
      if(num%i==0)
        return false;
    }
    return true;
  }

  /**
   * Deletes an element from the hash table if it exists. Makes use of a different deleteElement function
   * @param element
   */
  public void deleteElement(HashTableElement element){
    deleteElement(element.getISBN());
  }

  /**
   * Deletes an element from the hash table if it exists. Makes use of findElement to find the index
   * @param ISBN
   * @throws EmptyCollectionException
   */
  public void deleteElement (int ISBN) throws EmptyCollectionException {
    if(isEmpty())
      throw new EmptyCollectionException("Hash Table");

    int index = -1;
    try{
      index = findElement(ISBN);
    }catch (Exception e){
      System.out.println(e);
    }
    if(index != -1){
      hashTable[index].setDeleted(true);
      numElements--;
    }
  }

  /**
   * Finds an element in the hash table if it exists.
   * @param ISBN
   * @return
   * @throws ElementNotFoundException
   */
  private int findElement(int ISBN) throws ElementNotFoundException {

    boolean found = false;
    //First index to check
    int index = hashFunction(ISBN);

    int i = 1;
    while(!found){
      //if the element is null, element was not found in the hashtable
      if(hashTable[index] == null) {
        throw new ElementNotFoundException("Hash Table");
      //otherwise, if the element has the incorrect key or is deleted, find the next index to search
      }else if(!(ISBN == hashTable[index].getISBN()) || hashTable[index].isDeleted()){
        index = (index*i) + secondHashFunction(ISBN) % hashTable.length;
        i++;
      //otherwise the key must have been found and there is no need to keep searching
      }else if(ISBN == hashTable[index].getISBN()){
        found = true;
      }
    }
    return index;
  }

  /**
   * Adds an element to the hash table given the ISBN provided is correct
   * @param element
   */
  public void addElement(HashTableElement element){
    try{
      addElement(element.getName(),element.getISBN());
    }catch(Exception e){
      System.out.println();
    }
  }
  /**
   * Adds an element to the hash table given the ISBN provided is correct
   * @param name
   * @param ISBN
   * @throws IllegalAccessException
   */
  public void addElement(String name, int ISBN) throws IllegalAccessException{

    //Check if the ISBN is in valid format
    if(!isValidISBN(ISBN)){
      throw new IllegalAccessException("Please enter an ISBN number which is ten digits.");
    }

    //Check if the the hash map needs to be expanded
    if(numElements+1 >= threshold){
      resize(); 
    }

    HashTableElement temp = new HashTableElement(name,ISBN);
    int index = nextIndex(temp.getISBN());
    hashTable[index] = temp;
    numElements++;
  }

  /**
   * Provides an available index for an element to be stored by uISBNg double hashing if necessary.
   * @param ISBN
   * @return
   */
  private int nextIndex(int ISBN){
    int index = hashFunction(ISBN);

    //while index is occupied, find another index
    int i = 1;
    //condition checks if an index is available (i.e. the index returns null) or in the case an element is returned
    //whether that returned element is deleted
    while(hashTable[index] != null && !hashTable[index].isDeleted()){
      index = ((index + i) * (i+secondHashFunction(ISBN))) % hashTable.length;
      i++;
    }
    return index;
  }

  /**
   * Produces an index to store an element at given the ISBN.
   * @param ISBN
   * @return
   */
  private int hashFunction(int ISBN){
    int key = Integer.parseInt(String.valueOf(ISBN).substring(6, 9));
    int index = key % hashTable.length;
    return index;
  }

  /**
   * Second hashing function to resolve collisions
   * @param ISBN
   * @return
   */
  private int secondHashFunction(int ISBN){
    int key = Integer.parseInt(String.valueOf(ISBN).substring(0, 2));
    int index = key*key;
    index = Integer.parseInt(String.valueOf(index).substring(1, 3)) % hashTable.length;
    return index;
  }

  /**
   * Test whether the ISBN number is in valid format
   * @param ISBN
   * @return true if the ISBN is in correct format
   */
  private boolean isValidISBN(int ISBN){
    return Pattern.matches("[\\d]{10}",String.valueOf(ISBN));
  }

  /**
   * Checks is the hash table is empty
   * @return
   */
  public boolean isEmpty(){
    return (numElements==0);
  }

  /**
   * Returns the size of the hash table
   * @return
   */
  public int size(){
    return numElements;
  }

  /**
   * Returns true if the hash table contains an element given a certain ISBN
   * @param ISBN
   * @return
   */
  public boolean contains(int ISBN){
    boolean found = true;
    try{
      int index = findElement(ISBN);
      if(hashTable[index].isDeleted()){
        found = false;
      }
    }catch(Exception e){
      found = false;
    }
    return found;
  }

  /**
   * Returns true if the hash table contains an element given a certain ISBN
   * @param element
   * @return
   */
  public boolean contains (HashTableElement element){
    return contains(element.getISBN());
  }

  /**
   * Prints out the hashtable
   * @return
   */
  public String toString(){
    String s="";
    for(int i = 0;i < hashTable.length;i++){
      if(hashTable[i] == null){
        s+= ("index: " + i + ", element -  null\n");
      }else{
        s+= ("index: " + i + ", element - "+ hashTable[i].toString() +"\n");
      }

    }
    return s;
  }
}