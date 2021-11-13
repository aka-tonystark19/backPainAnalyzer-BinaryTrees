//*************************************************************************************
//  DriverBalanceTree.java
//
//  Aditya Phalod (T00678151)
//  COMP2231 Assignment 4 Question2
//  This is the driver class to test functionality of a brute force method for balancing a binary search tree.
//  The process is displayed to the user.  Adding elements, seeing outputs, balancing then rechecking.
//*************************************************************************************

public class DriverBalanceTree
{
    public static void main(String[] args)
    {
        //Instantiate the LinkedBinarySearch Tree
        LinkedBinarySearchTree<Integer> BST = new LinkedBinarySearchTree<>();

        //Add elements to the binary Search Tree and display them as they are added
        BST.addElement(10);
        //System.out.println(BST.toString());
        BST.addElement(20);
        //System.out.println(BST.toString());
        BST.addElement(30);
        //System.out.println(BST.toString());
        BST.addElement(40);
        //System.out.println(BST.toString());
        BST.addElement(50);
        System.out.println(BST.toString());

        //Display the root element and the height of the tree to the user
        System.out.println("\nRoot node is: " + BST.getRootElement());
        System.out.println("Height Before Balance: " + BST.getHeight());

        //Balance the tree then display new root and new height
        BST.balanceTree();
        System.out.println("\nRoot is: " + BST.getRootElement());
        System.out.println("Height After Balance: " + BST.getHeight());

        //Add more elements to the linkedbinarysearchtree
        System.out.println(BST.toString());
        BST.addElement(60);
        System.out.println(BST.toString());
        BST.addElement(70);
        System.out.println(BST.toString());
        BST.addElement(80);
        System.out.println(BST.toString());

        //Do the same as above, display root and height, balance, then display again
        System.out.println("\nRoot node is: " + BST.getRootElement());
        System.out.println("Height Before Balance: " + BST.getHeight());
        BST.balanceTree();
        System.out.println("\nRoot is: " + BST.getRootElement());
        System.out.println("Height After Balance: " + BST.getHeight());
    }
}