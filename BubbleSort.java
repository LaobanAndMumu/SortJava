/* 
 * BubbleSort.java 
 */

/**
 * This program implements Sort interface
 * and implements its own methods for bubble sorting.
 *
 * @author  Yu-ching Sun 
 * @author  Wei-yao Ku    
 */

public class BubbleSort implements Sort{
		
	private long totalTime = 0; 
	private String name = "Bubble Sort";
	private int swap = 0;
	
	/**
	 * Return the name of sorting
	 * 
	 * @return name: the name of the sorting 
	 */
	
	public String getNameOfSort() {
		return name;
	}

	/**
	 * Return the sorting array.
	 * 
	 * @param arr: the unsorted array 
	 * @return arr: the sorted array
	 */
	
	public int[] sort(int[] arr) {
		
		long begin = System.currentTimeMillis(); 
		swap = 0;
		boolean bSwap = false;
		
		do{ 
			// set swap as false
			bSwap = false;
			for( int i=0; i < arr.length-1; i++ ){
			  
			  /*
			   *  if the next element is smaller than 
			   *  the previous element, swap the two elements	
			   */
			  if( arr[i] > arr[i+1] ){  
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				swap++;
				
				// set bSwap as true
				bSwap = true;
			  }
			}
	    }while(bSwap);
		
		// the finished time
		long end = System.currentTimeMillis(); 
		
		// time taken to sort
		totalTime += end - begin;
		
		return arr;
	}
	
	/**
	 * Return the total time taken
	 * 
	 * @return totalTime: the total time taken
	 */
	public long getTotalTime(){
		return totalTime; 
	}
	
	/**
	 * Return the number of operations
	 * occurred
	 * 
	 * @return operations: times of swapping, combining
	 *                     splitting
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
		return "Bubble sort continuously loops through an array "
				+ "\n" + "  and compares two elements at a time, swapping "
				+ "\n" + "  them until the entire array is sorted";
	}
	
	/**
	 * Main method
	 * 
	 * @param args: command line argument is not sued(ignored).
	 */
	
	public static void main( String[]args ){	
		
		// test the algorithm with a pre-sorted array
		int[] intArr = {1, 2, 3, 4, 5};	
		BubbleSort bubble = new BubbleSort();
		System.out.println("*Name of sorting: " + bubble.getNameOfSort());		
		System.out.println( "Test description: " + bubble.getDescription() );
		System.out.print( "Original array: " );
		for ( int i = 0; i< intArr.length; i++ ) {
			System.out.print(  intArr[i] + " ");
		}
		bubble.sort(intArr);
		System.out.println(  );
		System.out.print( "Sorted array: " );
		for ( int i = 0; i< intArr.length; i++ ) {
			System.out.print(  intArr[i] + " ");
		}
		
		System.out.println(  );
		System.out.println( " Run time: " + bubble.getTotalTime() );
		System.out.println( " Total operation times: " + bubble.getOperationsTimes() );
		
		// test the algorithm with a reversed-sorted array
		int[] intArr2 = {5, 4, 3, 2, 1};
		BubbleSort bubble1 = new BubbleSort();
		System.out.println("*Name of sorting: " + bubble1.getNameOfSort());
		System.out.println( "Test description: " + bubble1.getDescription() );
		System.out.print( "Original array: " );
		for ( int i = 0; i< intArr2.length; i++ ) {
			System.out.print(  intArr2[i] + " ");
		}
		bubble1.sort(intArr2);
		System.out.println(  );
		System.out.print( "Sorted array: " );
		for ( int i = 0; i< intArr2.length; i++ ) {
			System.out.print(  intArr2[i] + " ");
		}
		System.out.println(  );
		System.out.println( " Run time: " + bubble1.getTotalTime() );		
		System.out.println( " Total operation times: " + bubble1.getOperationsTimes() );
	}
}
