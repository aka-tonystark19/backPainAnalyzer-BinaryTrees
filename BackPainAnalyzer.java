//*********************************************************************************************************************************************************
//BackPainAnalyzer.java
//
//Aditya Phalod T00678151
//COMP2231 Assignment4 Question1
//This driver class implements the DecisionTree class to diagnose back pain.
//This is also a dirver to determine the exercise to be done by an individual. Use necessary comments to implement it!
//********************************************************************************************************************************************************
import java.io.*;
/**
 * BackPainAnaylyzer demonstrates the use of a binary decision tree to
 * diagnose back pain.
 */
public class BackPainAnalyzer
{
    /**
     * Asks questions of the user to diagnose a medical problem.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("So, you're having back pain."); // default BackPainAnalyzer prompt
        //System.out.println("Road to Fitness"); // demonstration of another just as
        // complex decision tree
       DecisionTree expert = new DecisionTree("C:\\Users\\Aditya\\Desktop\\input" +".txt"); // BackPainAnalyzer uses input.txt
       //DecisionTree expert = new DecisionTree("C:\\Users\\Aditya\\Desktop\\inputNew" +".txt"); // FrenchFryChooser uses inputNew.txt
        expert.evaluate();
    }
}