/* 
 * TestSort.java 
 */

import java.util.Arrays;
import java.util.Random;

/**
 * This program uses the strategy design pattern 
 * to allow users to choose different algorithm 
 * to sort the integer array. 
 *
 * @author  Yu-ching Sun 
 * @author  Wei-yao Ku    
 */

public class TestSort< T extends Sort > {
	
	private T algorithm; 
	
	/**
	 * Set the algorithm for sorting
	 * 
	 * @param algorithm: the algorithm for sorting
	 */
	
	public void setAlgorithm(T algorithm){
		this.algorithm = algorithm; 
	}
	
	/**
	 * Create the 5 elements array 100 times and calls its corresponding 
	 * methods and calculate the average running time and operation times.
	 * 
	 * @param numberOfElements: the size of the array
	 */
	
    public void test( int numberOfElements ){
    	System.out.println("Starting " + algorithm.getNameOfSort());
    	 
    	// test pre-sorted array
    	int[] preSorted = new int[numberOfElements];
    	for( int x = 1; x <= numberOfElements; x++ ){
    		preSorted[x-1] = x;
    	}
    	//System.out.print("PreSorted array original: " + Arrays.toString(preSorted));
    	
    	int[] resultPreSorted = algorithm.sort(preSorted);
    	//System.out.print("Sorted array : " + Arrays.toString(resultPreSorted));
    	//System.out.println();
    	
    	// test reversed sorted array
    	int[] reverseSorted = new int[numberOfElements];
    	for( int y = numberOfElements; y > 0; y-- ){
    		reverseSorted[numberOfElements-y] = y;
    	}
    	
    	//System.out.print("Reversed Sorted array original: " + Arrays.toString(reverseSorted));
    	int[] resultReversed = algorithm.sort(reverseSorted);
    	//System.out.print("Sorted array: " + Arrays.toString(resultReversed));
    	//System.out.println();
    	    	
    	// accumulated time taken of sorting
    	long accumulated = 0;   
    	
    	// the number of operations
    	int accumulatedSwapping = 0;
    	
    	int[] arr = new int[numberOfElements];
    	
    	int iterations = 100;
    	
    	// test the algorithm 100 times
    	for( int m = 0; m < iterations; m++ ){
    	  
    	  // create the random numbers of array
    	  for( int i = 0; i < numberOfElements; i++ ){
    		Random rand = new Random();
    		int randNumber = rand.nextInt(10)+1;
    		arr[i] = randNumber;
    	  }
    	   
    	  printArray( "**Original:", arr );
    	   
    	  int[] sorted = algorithm.sort( arr );
    	
    	  printArray( " Sorted:", sorted );   
    	   
    	  accumulated +=  algorithm.getTotalTime(); 
    	  accumulatedSwapping += algorithm.getOperationsTimes();
    	   
    	}
    	   	
    	System.out.println( "**Sorting method: " + algorithm.getNameOfSort() );
    	System.out.println( "Test description: " + algorithm.getDescription() );
    	System.out.println( "How many iterations: " + iterations );
    	System.out.format("Total Time: %06d",accumulated);
    	System.out.println();
    	
    	long average = accumulated / (long)iterations;
    	
    	System.out.format( "Average time of sorting: %06.6f%n",(float) average );
    	
    	int averageSwapping = accumulatedSwapping / iterations;
    	
    	System.out.println( "Average number of operations: " + averageSwapping );
    	System.out.println( "------------------------------------------------" );
    }
    
    /**
     * Loop through the array with string message.
     * 
     * @param msg: the message before the array
     * @param arr: the array
     */
    
    private void printArray( String msg, int[] arr ) {
    	System.out.println( msg );
    	for( int s: arr ){
    		System.out.print( s + " " );
    	}
    	System.out.println();
    }
    
    /**
     * Main method
     * 
     * @param args: command line argument is not used(ignored).
     */
    
    public static void main( String []args ){
    	
    	// test quick sort
    	TestSort<Sort> testAlgo1 = new TestSort<>();
    	testAlgo1.setAlgorithm( new QuickSort() );
    	testAlgo1.test( 10 );
   	    
    	// test bubble sort
    	TestSort<Sort> testAlgo2 = new TestSort<>();
    	testAlgo2.setAlgorithm( new BubbleSort() );
    	testAlgo2.test( 10000 );
    	
    	// test merge sort
//    	TestSort<Sort> testAlgo3 = new TestSort<>();
    	testAlgo1.setAlgorithm( new MergeSort() );
    	testAlgo1.test( 10 );
    }
}
