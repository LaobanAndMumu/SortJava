/* 
 * QuickSort.java 
 */

/**
 * This program implements Sort interface
 * and implements the methods for quick sorting.
 *
 * @author  Yu-ching Sun 
 * @author  Wei-yao Ku    
 */
 
public class QuickSort implements Sort {
    
	private String name = "Quick Sort"; 
	private long totalTime; 
	private int swap; 
	
	/**
	 * Return the name of sorting.
	 * 
	 * @return name: the sorting name.
	 */
	
	public String getNameOfSort() {
		return name;
	}
    
	/**
	 * Return the sorted array by calling quickSort method. 
	 * 
	 * @param arr: the unsorted array
	 * @return sorted: the sorted array
	 */
	
	public int[] sort( int[] arr ) {
		swap = 0; 
		
		// begin time
		long begin = System.currentTimeMillis();	    
		int[] sorted = quickSort( arr, 0, arr.length-1 );
		  
		// the finished time
		long end = System.currentTimeMillis();
			
		// the time taken to sort
		totalTime = end - begin; 
		return sorted;	    	   
	}
	
	/**
	 * Return the sorted array by comparing elements
	 * around a pivot element and by recursively 
	 * sorting the elements to the left and right of 
	 * the pivot.  
	 * 
	 * @param arr: the unsorted array
	 * @param begin: the begin index
	 * @param end: the end index
	 * @return arr: the sorted array
	 */
	
	public int[] quickSort( int[]arr, int begin, int end ){
		
		// if end index is greater than index, return the array
	    if ( end <= begin ){
	    	return arr;
	    }
	    else{
	      int swapPivot = begin; 
	      int pivot = arr[end];
	      
	      for( int i = begin; i <= end; i++){
	    	
	    	// if it is the last element, swap with the swapPivot  
	    	if ( i == end ){
				   int temp = arr[i];
				   arr[i] = arr[swapPivot];
				   arr[swapPivot] = temp;	
				   swap++;
			}	  
	    	// if it is smaller than pivot, swap with the swapPivot
	    	if ( arr[i] < pivot ){
				   int temp = arr[i];
				   arr[i] = arr[swapPivot];
				   arr[swapPivot] = temp;  
				   swapPivot ++; 
				   swap++;
			}	    	
	      }
	      
	      // recursively call the function till it has one element
	      quickSort( arr, begin, swapPivot-1 );
	      quickSort( arr, swapPivot+1, end ); 
	      return arr;
	    }
	}
	
	/**
	 * Return the running time.
	 * 
	 * @return totalTime: the time taken to sort.
	 */
	
	public long getTotalTime(){
		return totalTime; 
	}
	
	/**
	 * Return the times of swapping
	 * 
	 * @return operations: times of swapping
	 */
	
	public int getOperationsTimes(){
		return swap; 
	}
	
	/**
	 * Return a description of the test
	 * 
	 * @return description: the description of the test
	 */
	   
	public String getDescription(){
		return "Quick sort recursively compares and swaps elements  "
				+ "\n" + "  in an array until it is sorted " ;
	}
	
	/**
	 * Main method
	 * 
	 * @param args: command line argument is not used(ignored).
	 */
	
	public static void main( String[]args ){
		
		// test the algorithm with a pre-sorted array
		int[] intArr = {1, 2, 3, 4, 5};
		
		QuickSort quick = new QuickSort();
		
		System.out.println("*Name of sorting: " + quick.getNameOfSort());	
		System.out.println("Test description: " + quick.getDescription());
		
		System.out.print( "Original array: " );
		for ( int i = 0; i< intArr.length; i++ ) {
			System.out.print(  intArr[i] + " ");
		}
		
		quick.sort( intArr );
		System.out.print( "\n" + "Sorted array: " );
		for ( int i = 0; i< intArr.length; i++ ) {
			System.out.print(  intArr[i] + " ");
		}
		System.out.format( "\n" + "Total run time : %08d",quick.getTotalTime() );	
		System.out.println();
		System.out.println( "Operation times: " + quick.getOperationsTimes() );
		
		// test the algorithm with a reversed-sorted array
        int[] intArr1 = {5, 4, 3, 2, 1};
		
		QuickSort quick1 = new QuickSort();
		
		System.out.println("*Name of sorting: " + quick1.getNameOfSort());	
		
		System.out.print( "Original array: " );
		for ( int i = 0; i < intArr1.length; i++ ) {
			System.out.print(  intArr1[i] + " ");
		}
		
		quick1.sort( intArr1 );
		
		System.out.print( "\n" + "Sorted array: " );
		for ( int i = 0; i < intArr1.length; i++ ) {
			System.out.print(  intArr1[i] + " " );
		}
		
		System.out.format( "\n" + "Total run time : %08d", quick1.getTotalTime() );	
		System.out.println();
		System.out.print( "Operation times: " + quick1.getOperationsTimes() );
	}
}
