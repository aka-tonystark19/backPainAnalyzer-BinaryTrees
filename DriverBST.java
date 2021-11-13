//*********************************************************************************************************************************************************
//DriverBST.java
//
//Aditya Phalod T00678151
//COMP2231 Assignment4 Question2
//This driver class implements the LinkedBinarySearchTree class to implement a binary search tree and perform its methods.
//********************************************************************************************************************************************************
import java.util.Random;
public class DriverBST
{
    public static void main(String[] args) 
    {
        LinkedBinarySearchTree<Integer> BST = new LinkedBinarySearchTree<>();
        BST.addElement(0);
        BST.addElement(-56);
        BST.addElement(12);
        BST.addElement(14);
        BST.addElement(165);
        BST.addElement(2);
        //System.out.println("Current elements: "+BST.toString());
        BST.balanceTree();
        System.out.println("Current elements (balanced): "+BST.toString());
        System.out.println();
        BST.removeElement(165);
        BST.balanceTree();
        System.out.println("Current elements: (balanced, after removing 165)"+BST.toString());
        System.out.println();
        BST.addElement(56);
        BST.addElement(98);
        BST.addElement(56);
        System.out.println("Current elements: "+BST.toString());
        System.out.println();
        BST.removeAllOccurrences(56);
        System.out.println("Current elements: (after removing all occurrances of 56) "+BST.toString());
        System.out.println();
        System.out.println("Removing minimum value: " +BST.removeMin());
        System.out.println("Removing maximum value: " +BST.removeMax());
        System.out.println();
        System.out.println("Maximum value: "+BST.findMax());
        System.out.println("Minimum value: "+BST.findMin());
        BST.balanceTree();
        System.out.println();
        System.out.println("Left subtree: "+BST.getLeft());
        System.out.println("Right subtree: "+BST.getRight());
    }
}