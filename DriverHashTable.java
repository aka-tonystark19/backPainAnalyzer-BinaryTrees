//*********************************************************************************************************************************************************
//DriverHashTable.java
//
//Aditya Phalod T00678151
//COMP2231 Assignment5 Question3
//This driver class implements the Hash Table to demonstrate its various methods.
//***********************************************************************************************************************************************
public class DriverHashTable
{
  public static void main(String[] args)
  {
    //Test - create an empty hashTable
    HashTable hashTable = new HashTable();
    System.out.println("\nCreated an empty hash table");

    emptyHashTableTests(hashTable);
    notEmptyHashtableTests(hashTable);
    resizeHashTabletest();
  }

  public static void emptyHashTableTests(HashTable hashTable)
  {
    //Test - check if its empty
    System.out.println("\nCheck if the hash table is empty");
    System.out.println(hashTable.isEmpty());

    //Test - delete an element using ISBN on an empty hash table
    System.out.println("\nDelete on an empty hash table by ISBN 1888951201");
    try{
      hashTable.deleteElement(1888951201);
    }catch(Exception e){
      System.out.println(e);
    }

    //Test - delete an element by passing in a HashTableElement on an empty hash table
    System.out.println("\nDelete on an empty hash table by element");
    HashTableElement temp = new HashTableElement("Laws of Human Nature", 1888951201);
    System.out.println("Created a HashTableElement with the name: 'Laws of Human Nature' and ISBN: '1888951201'");
    try{
      hashTable.deleteElement(temp);
    }catch(Exception e){
      System.out.println(e);
    }

    //Test - use method contains() on an empty hash table by ISBN
    System.out.println("\nContain on an empty hash table by ISBN 1888951201");
    System.out.println(hashTable.contains(1888951201));

    //Test - use method contains() on an empty hash table by element
    System.out.println("\nContain on an empty hash table by element");
    System.out.println(hashTable.contains(temp));

    //Test - size of an empty hash table
    System.out.println("\nSize of an empty hash table");
    System.out.println(hashTable.size());
  }

  public static void notEmptyHashtableTests(HashTable hashTable)
  {
    //Test - add an element using an incorrect ISBN
    System.out.println("\nAdd an element using an incorrect ISBN (654)");
    try{
      hashTable.addElement("Rich Dad Poor Dad", 654);
    }catch (Exception e){
      System.out.println(e);
    }

    //Test - add an element using a correct ISBN
    System.out.println("\nAdd an element using an incorrect ISBN (ISBN = 1888951201)");
    try{
      hashTable.addElement("The Monk who sold his Ferrari", 1888951201);
    }catch (Exception e){
      System.out.println(e);
    }
    System.out.println("Successfully added element to hashTable");

    //Test - size of hash table with one element
    System.out.println("\nSize of hash table with one element.");
    System.out.println(hashTable.size());

    //Test - isEmpty function on non empty hash table
    System.out.println("\nisEmpty method on non empty hash table");
    System.out.println(hashTable.isEmpty());

    //Test - add an element using a HashTableElement
    System.out.println("\nAdd an element using a HashTableElement)");
    HashTableElement temp = new HashTableElement("Think and Grow Rich", 1560755541);
    System.out.println("Created a HashTableElement with the name: 'Laws of Human Nature' and ISBN: '1888951201'");
    try{
      hashTable.addElement("Think and Grow Rich", 1560755541);
    }catch (Exception e){
      System.out.println(e);
    }
    System.out.println("Successfully added element to hashTable");

    //Test - size of hash table with two elements
    System.out.println("\nSize of hash table with two elements.");
    System.out.println(hashTable.size());

    //Test - contain method using ISBN
    System.out.println("\ncontain method using ISBN: 1888951201");
    System.out.println(hashTable.contains(1888951201));

    //Test - contain method using HashTableElement
    System.out.println("\ncontain method using HashTableElement temp (name='Think and Grow Rich', ISBN='1560755541')");
    System.out.println(hashTable.contains(temp));

    //Test - delete element not in hash table by ISBN
    System.out.println("\nDelete an element by ISBN not in the hash table");
    hashTable.deleteElement(354);

    //Test - delete element not in hash table by element
    System.out.println("\nDelete an element by passing in HashTableElement that is not in the hash table");
    HashTableElement notInTable = new HashTableElement("The Secret",1197364163);
    System.out.println("Create an element with name='The Secret', ISBN='1197364163'");
    hashTable.deleteElement(notInTable);

    //Test - delete an element in the hash table by ISBN
    System.out.println("\nDelete an element in the hash table by ISBN = 1888951201");
    hashTable.deleteElement(1888951201);
    System.out.println("Successfully deleted");

    //Test - delete an element in the hash table by passing in a HashTableElement
    System.out.println("\nDelete method using HashTableElement temp (name='Think and Grow Rich', ISBN='1560755541')");
    hashTable.deleteElement(temp);
    System.out.println("Successfully deleted.");

  }

  public static void resizeHashTabletest()
  {
    System.out.println("For a hash table capable of holding 11 elements with a load factor of 0.7, 7 elements for dynamic resizing to take palce.");
    System.out.println("This test will add 7 elements");
    HashTable hashTable = new HashTable();
    try{
      hashTable.addElement("The Secrets of Droon",1997364163);
      hashTable.addElement("Sapiens",1173951108);
      hashTable.addElement("The Power of Habit",1194901387);
      hashTable.addElement("Marvel Comics",1593792381);   
      hashTable.addElement("DC Comics",1857613138);
      hashTable.addElement("The Power of Influence",1857613138);
    }catch(Exception e){
      System.out.println(e);
    }

    System.out.println("Added 6 elements.");
    System.out.println(hashTable.size());
    System.out.println("The hash table currently: \n"+hashTable.toString());

    try{
      hashTable.addElement("Resize",1123456789);
    }catch (Exception e){
      System.out.println(e);
    }
    
    System.out.println("Added one more element (Name = 'Resize' ISBN = 123456789) so total comes to 7. This will trigger resizing");
    System.out.println(hashTable.size());
    System.out.println("The hash table after resizing \n"+hashTable.toString());
  }
}