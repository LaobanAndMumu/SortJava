/* 
 * Sort.java 
 */

/**
 * This sort interface provides the methods which 
 * require subclasses to implement.
 *
 * @author  Yu-ching Sun 
 * @author  Wei-yao Ku    
 */

public interface Sort {
   
   /**
    * Return the name of sorting
    * 
    * @return name: the name
    */
	
   public String getNameOfSort();
   
   /**
    * Return the sorted array.
    * 
    * @param arr: the unsorted array
    * @return sorted array
    */
   
   public int[] sort(int[] arr);
   
   /**
    * Get the run time.
    * 
    * @return time taken of sorting
    */
   
   public long getTotalTime();
   
   /**
	 * Return the times of swapping and comparing.
	 * 
	 * @return operations: times of swapping
	 */
   
   public int getOperationsTimes();
   
   /**
    * Return a description of the test
    * 
    * @return description: the description of the test
    */
   
   public String getDescription();
}
