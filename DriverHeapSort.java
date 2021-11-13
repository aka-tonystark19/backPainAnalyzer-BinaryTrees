//*********************************************************************************************************************************************************
//DriverHeapSort.java
//
//Aditya Phalod T00678151
//COMP2231 Assignment5 Question1
//This driver class implements the HeapSort class to implement the modified heap sort alogrithm with various test cases.
//********************************************************************************************************************************************************
public class DriverHeapSort
{
    public static void main(String[] args)
    {
        HeapSort<Integer> heap = new HeapSort<>();

        //Test 1
        System.out.println("Test - The array before sorting");
        Integer[] unsortedTestOne = {4,7,18,1,6};
        System.out.println(heap.toString(unsortedTestOne));
        
        System.out.println("Result should be [ 1 4 6 7 18 ]");
        Integer[] sortedTestOne = heap.heapSort(unsortedTestOne);
        System.out.println(heap.toString(sortedTestOne));

        //Test 2
        System.out.println("\nTest - The array before sorting (includes a repeated value)");
        Integer[] unsortedTestTwo = {17, 22, 174, 312, 87,244,7289,22};
        System.out.println(heap.toString(unsortedTestTwo));
        
        System.out.println("Result should be [ 17 22 22  87 174 244 312 7289 ]");
        Integer[] sortedTestTwo = heap.heapSort(unsortedTestTwo);
        System.out.println(heap.toString(sortedTestTwo));

        //Test 3
        System.out.println("\nTest - The array before sorting (includes negative values)");
        Integer[] unsortedTestThree = {20, -4, 14, -22, 11, 0};
        System.out.println(heap.toString(unsortedTestThree));

        System.out.println("Result should be [ -22 -4 0 11 14 20 ]");
        Integer[] sortedTestThree = heap.heapSort(unsortedTestThree);
        System.out.println(heap.toString(sortedTestThree));
    }
}//class ends