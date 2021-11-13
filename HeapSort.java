//*********************************************************************************************************************************************************
//HeapSort.java
//
//Aditya Phalod T00678151
//COMP2231 Assignment5 Question1
//An effecient method to implement the heap sort.
//********************************************************************************************************************************************************
//import jsjf.heap.*;
/**
 * HeapSort sorts a given array of Comparable objects using a heap.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class HeapSort<T>
{
    /**
     * Sorts the specified array using a Heap
     *
     * @param data the data to be added to the heapsort
     */
    public static final int root = 0;
    public T[] heapSort(T[] data)
    {
        int size = data.length;
        int heap = -1; 
        // turn array into heap
        for(int i = 0;i < size;i++)
        {
            upHeap(data, i);
            heap++;
        }
        // turn heap into ascending array
        while(heap >= 0)
        {
            T temp = data[heap];
            //Store root (max value) into the array.
            data[heap] = data[root];
            data[root] = temp;
            //change the array to reflect the edge of the heap
            heap--;
            downHeap(data,root,heap);
        }
        return data;
    }

    private void downHeap(T[] data, int index, int heap)
    {
        //while the index is not a leaf node
        while(index < heap)
        {
            int childIndex = getIndexOfLargerChild(data,index,heap);
            if(validHeapIndex(childIndex,heap) && ((Comparable) data[index]).compareTo(data[childIndex]) < 0)
            {
                //store current node's value in a temp variable
                T temp = data[index];
                data[index] = data[childIndex];
                data[childIndex] = temp;
                index = childIndex;
            }else{
                //terminate the execution because the node is smaller than both its children
                index = heap + 1;
            }
        }
    }

    private int getIndexOfLargerChild(T[] data, int index, int heap)
    {
        int childIndex = -1;
        int leftChild = 2*index + 1;
        int rightChild = 2*index + 2;
        //check if the node has zero, one or two children
        if(validHeapIndex(leftChild, heap) && validHeapIndex(rightChild,heap)){
            if(((Comparable) data[leftChild]).compareTo(data[rightChild]) < 0){
                childIndex = rightChild;
            }else{
                childIndex = leftChild;
            }
            //if the node only has a left child
        }else if(validHeapIndex(leftChild, heap) && !validHeapIndex(rightChild,heap)){
            childIndex = leftChild;
            //if the node only has a right child
        }else if(!validHeapIndex(leftChild, heap) && validHeapIndex(rightChild,heap)){
            childIndex = rightChild;
        }
        // -1 is only returned if the node has no children.
        return childIndex;
    }

    private boolean validHeapIndex(int index, int heap)
    {
        return (index <= heap && index > -1);
    }

    private void upHeap(T[] data, int index)
    {
        while(index > 0)
        {
            int parentIndex = (index - 1)/2;
            //If the parent is smaller than the child, switch the parent with its child
            if(((Comparable) data[parentIndex]).compareTo(data[index]) < 0)
            {
                //switch parent with child
                T temp = data[parentIndex];
                data[parentIndex] = data[index];
                data[index] = temp;
            }//end if
            // repeat the upHeap process with the parent of the node that was just upHeaped
            index = parentIndex;
        } //end while
    }

    public String toString(T[] data)
    {
        String s ="[ ";
        for (int i =0;i<data.length;i++)
            s += data[i] +" ";
        s+= "]";
        return s;
    }
}