/* 
 * MergeSort.java 
 */

/**
 * This program implements Sort interface
 * and implements its own methods.
 *
 * @author  Yu-ching Sun 
 * @author  Wei-yao Ku    
 */

public class MergeSort implements Sort{
	
    private String name = "Merge Sort";
    private long totalTime;
    private int swap = 0; 
   	
    /**
     * Return the name of sorting
     * 
     * @name: the name of sorting
     */
    
	public String getNameOfSort() {
		return name;
	}
    
	/**
	 * Split the array, compare them and 
	 * merge them together.
	 * 
	 * @param arr: the integer array
	 */
	
	public int[] sort( int[]arr ){
				
		long begin = System.currentTimeMillis();
		int[] result = realSort(arr);
		long end = System.currentTimeMillis();
		totalTime = end - begin;
		return result;
	}
	
	private int[] realSort(int[] arr) {
		swap = 0; 
		
		// if the array has only one element, return arr
		if( arr.length <= 1 ){
			return arr; 
		}
		
		else{
			
		  // set the middle point	
		  int middlePoint = arr.length / 2;
		  int middle = middlePoint; 
		 
		  int [] left = new int[middlePoint];
		  int[] right = new int[arr.length-middlePoint];
		  
		  // copy to the left array
		  for( int i=0; i < middlePoint; i++ ){
			 left[i]= arr[i];
			 swap++;
		  }
		  
		  // copy to the right array
		  for( int m=0; m < arr.length-middlePoint; m++ ){
			 right[m]= arr[middle];
			 middle++;
			 swap++;
		 }
		 
		 // split the left and right array recursively till it only has one element 
		 int [] x = sort( left );
		 int [] y = sort( right );
		 		 
		 // the finished time
		 
		 
		 // return merge array 
		 return merge( x, y ); 	
		 }	
	}
	
	/**
	 * Merge the elements of the array
	 * 
	 * @param left: left side of the split array
	 * @param right: right side of the split array
	 * @return combineArray: return the sorted array 
	 *                       of left and right sides
	 */
	
	public int[] merge( int[]left, int[]right ){
		
		int leftIndex =0; 
		int rightIndex =0; 
		int combineIndex = 0; 
		int [] combineArray = new int[left.length + right.length]; 
		
		// loop through every element of right and left arrays and compare them
		while( leftIndex < left.length && rightIndex < right.length ){
			
			/*
			 * if the left element is smaller than 
			 * the right element, put it to combineArray
			 */
			
			if ( left[leftIndex] <= right[rightIndex] ){
				combineArray[combineIndex] = left[leftIndex];
				leftIndex++;
				combineIndex++;
				swap++;
			}
			else{
				combineArray[combineIndex] = right[rightIndex];
				rightIndex++;
				combineIndex++;
				swap++;
			}			
		}		
		
		// put the rest elements of the left array to the combineArray
		while( leftIndex < left.length ){
			combineArray[combineIndex] = left[leftIndex];
			leftIndex++;
			combineIndex++;
			swap++;
		}
		
		// put the rest elements of the right array to the combineArray
		while( rightIndex < right.length ){
			combineArray[combineIndex] = right[rightIndex];
			rightIndex++;
			combineIndex++;
			swap++;
		}				
		return combineArray;
	}
	
	/**
	 * Return the total time taken to sort.
	 * 
	 * @return totalTime: the time taken to sort
	 */
	
	public long getTotalTime(){
		return totalTime; 
	}
	
	/**
	 * Return the times of operations
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
		return " Merge sort recursively divides an array into subarrays "
				+ "\n" + " of length one, then merges them back together "
				+ "\n" + " into a sorted array";
	}
	
	/**
	 * Main method
	 * 
	 * @param args: command line argument is not used(ignored).
	 */
	
	public static void main( String[]args ){
		
		// test the algorithm with a pre-sorted array
		int[] intArr = {1, 2, 3, 4, 5, 6, 7};
		
		MergeSort merge = new MergeSort(  );
		
		System.out.println( "*Name of sorting: " + merge.getNameOfSort());	
		System.out.println("Test descrption: " + merge.getDescription());
		
		System.out.print( "Original array: " );
		for ( int i = 0; i < intArr.length; i++ ) {
			System.out.print( intArr[i] + " " );
		}
		
		intArr = merge.sort( intArr );
		System.out.print( "\n" + "Sorted array: " );
		for ( int i = 0; i< intArr.length; i++ ) {
			System.out.print(  intArr[i] + " ");
		}	
		System.out.println( "\n" + "Total time: " + merge.getTotalTime() );
		System.out.println( "Total operations: " + merge.getOperationsTimes() );
		
		// test the algorithm with a reversed-sorted array
        int[] intArr1 = {7, 6, 5, 4, 3, 2, 1};
		
		MergeSort merge1 = new MergeSort();
		System.out.println();
		System.out.println( "*Name of sorting: " + merge1.getNameOfSort());	
		
		System.out.print( "Original array: " );
		for ( int i = 0; i< intArr1.length; i++ ) {
			System.out.print(  intArr1[i] + " ");
		}
		
		intArr1 = merge1.sort( intArr1 );
		System.out.print( "\n" + "Sorted array: " );
		for ( int i = 0; i< intArr1.length; i++ ) {
			System.out.print(  intArr1[i] + " ");
		}	
		System.out.println( "\n" + "Total time: " + merge1.getTotalTime() );
		System.out.println( "Total operations: " + merge1.getOperationsTimes() );
	}
}
