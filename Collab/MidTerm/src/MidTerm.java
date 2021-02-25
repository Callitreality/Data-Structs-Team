
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;
// import java.util.Objects;
import java.util.Arrays;
import java.util.Scanner;

public class MidTerm {

	// Global Variables
	private static final int CUTOFF = 4; // Change CUTOFF when it is needed.

	public static void main(String[] args) {

		System.out.print("Enter Size of the Array: ");
		Scanner userIn = new Scanner(System.in);
		int arrayInput = userIn.nextInt();
		System.out.println();

		// User Array
		int[] userArr = new int[arrayInput];
		System.out.println("Enter array: ");
		for (int i = 0; i < arrayInput; i++) 
		{
			userArr[i] = userIn.nextInt();
		}

		// Testing algorithms
		// int[] testArr = {7, 12, 9, 2, 17, 3, 4, 18, 13, 1, 5, 6};
		// int[] userArr = testArr;
		// int arrayInput = testArr.length;


		/**
		 * Testing Purposes...
		 */
		// System.out.println("\n\nPrinted Array:");
		// for (int i = 0; i < arrayInput; i++) 
		// {
		// 	System.out.printf("%d ", userArr[i]);
		// }

		int[] insertionArr = new int[userArr.length]; // Specifically used for the Insertion Function
		int[] inversionArr = new int[userArr.length]; // Specifically used for the Inversion Function
		int[] shellArr = new int[userArr.length]; // ... Hold my damn beer im going in.
		int[] mergeArr = new int[userArr.length]; // ... I seriously gotta get a life....
		int[] hardCopyArr = new int[userArr.length]; // ... Hold it again...

		for(int i = 0; i < userArr.length; i++) // Deep copy arrays
		{
			insertionArr[i] = userArr[i];
			inversionArr[i] = userArr[i];
			shellArr[i] = userArr[i];
			mergeArr[i] = userArr[i];
			hardCopyArr[i] = userArr[i];
		}


		boolean valid = true;
		while (valid) 
		{

			// User Validation...
			System.out.printf("\n\n1 - Quick Sort\n" 
			+ "2 - Merge Sort\n" 
			+ "3 - Insertion Sort\n" 
			+ "4 - Shell Sort\n"
			+ "5 - Inversion Count\n"
			+ "6 - Exit...\n" );

			System.out.printf("Please choose what sorting algorithm you want: ");
			int intInput = userIn.nextInt();
			
			if (intInput == 1) // Quick Sort
			{
				Integer convertedArr[] = new Integer[arrayInput];
				for(int i = 0; i < userArr.length; i++)
				{
					convertedArr[i] = Integer.valueOf(userArr[i]);
				}

				System.out.println("\nQuick Sort:");
				quicksort(convertedArr);

			}
			else if (intInput == 2) // Merge Sort
			{
				for(int i = 0; i < mergeArr.length; i++) // Refreshes Array...
				{
					mergeArr[i] = hardCopyArr[i];		
				}		
				System.out.println("\nMerge Sort:");
				mergeSort(mergeArr);

			}
			else if (intInput == 3) // Insertion Sort
			{
				for(int i = 0; i < insertionArr.length; i++) // Refreshes Array...
				{
					insertionArr[i] = hardCopyArr[i];		
				}		
				System.out.println("\nInsertion Sort:");
				insertionSort(insertionArr, insertionArr.length); // 2nd Parameter is the length of the array.

			}
			else if (intInput == 4) // Shell Sort
			{
				for(int i = 0; i < shellArr.length; i++) // Refreshes Array...
				{
					shellArr[i] = hardCopyArr[i];		
				}		
				System.out.println("\nShell Sort\n");
				System.out.print("Enter number of shellsort passes: ");
				int passes = userIn.nextInt();
				System.out.println();

				// Gaps Array
				int[] gaps = new int[passes];
				System.out.println("Enter increments in decending order: ");
				for (int i = 0; i < passes; i++) 
				{
					gaps[i] = userIn.nextInt();
				}

				shellsort(Arrays.stream(shellArr).boxed().toArray(Integer[]::new), gaps);

				pressAnyKeyToContinue();
			}
			else if (intInput == 5)  // Inversion Count
			{
				System.out.println("\nInversion Count");
				System.out.printf("Inversion Number %d\n", getInvCount(inversionArr));
				
			}
			else if (intInput == 6) // Closing
			{
				System.out.println("Have a good day!  (•◡•) /");
				valid = false;
			}
			else // Closing loose ends...
			{
				System.out.println("Please select a different option..");
			}

		}
		userIn.close(); // Closing Scanner
		System.exit(0);
	}


	/**
	 * Gets Inversion count and prints the inversions
	 * @param arr
	 */
	public static int getInvCount(int [] arr) 
	{ 
		int inv_count = 0; 
		for (int i = 0; i < arr.length; i++) 
		{
			for (int j = i + 1; j < arr.length; j++) 
				if (arr[i] > arr[j]) 
				{
					System.out.printf("(%d,%d)\t",arr[i],arr[j]);
					inv_count++; 
				}
			System.out.println();
		}
		return inv_count; 
	}
	private static void insertionSort(Comparable[] a, int low, int high ) {
		for( int p = low + 1; p <= high; p++ ) 
		{
			Comparable tmp = a[ p ];
			int j;
             
			for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
			{
				a[ j ] = a[ j - 1 ];
			}
			a[ j ] = tmp;
		}
	}

	/**
	 * Used in quicksort but can also be used by itself.
	 * @param arr - array that will be sorted
	 * @param n - length of array... so type {array name}.length
	 */
	public static void insertionSort(int arr[], int n) 
	{ 
		   int i, key, j; 
		   for (i = 1; i < n; i++) 
		   { System.out.printf("Pass %d : ",i);
			   int swaps = 0;
		       key = arr[i]; 
		       j = i-1; 
		   
		       /* Move elements of arr[0..i-1], that are 
		          greater than key, to one position ahead 
		          of their current position */
		       while (j >= 0 && arr[j] > key) 
		       { 
		           arr[j+1] = arr[j]; 
		           j = j-1; 
		           swaps++;
		       } 
		      
		       arr[j+1] = key; 
		       for(int x = 0; x < arr.length; x++)
		    	   System.out.printf("%d, ", arr[x]);
		       System.out.printf("  With %d swaps\n", swaps);
		   } 
	}
	//Depreciated shellsort algorithm

	/*public static int shellsort(int arr[])
	{ 
		int n = arr.length; 

	  
		// Start with a big gap, then reduce the gap 
		for (int gap = n/2; gap > 0; gap /= 2) 
		{ 
			int numswap=0;
			if(gap==6)
				gap=7;
			if(gap==2)
				gap=3;
				// Do a gapped insertion sort for this gap size. 
				// The first gap elements a[0..gap-1] are already 
				// in gapped order keep adding one more element 
				// until the entire array is gap sorted 
				for (int i = gap; i < n; i += 1) 
				{
					// add a[i] to the elements that have been gap 
					// sorted save a[i] in temp and make a hole at 
					// position i 
					int temp = arr[i]; 
					// shift earlier gap-sorted elements up until 
					// the correct location for a[i] is found 
					int j; 
					for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
						{arr[j] = arr[j - gap]; 
						numswap++;
						}
	  
					// put temp (the original a[i]) in its correct 
					// location 
					arr[j] = temp; 
				}
				System.out.printf("After %d sort:  ",gap);
				for(int i = 0; i < arr.length;i++)
					System.out.printf("%d, ",arr[i]);
					System.out.printf("    with %d swaps\n", numswap);
				
		} 
		return 0; 
	}

	/**
     * Shellsort, using Shell's (poor) increments.
     * @param a an array of Comparable items.
     */
	
	 public static <AnyType extends Comparable<? super AnyType>>void shellsort( AnyType [ ] a, int [ ] gaps)
    {
        int j = -1;
		// prints intial array (on one line) for comparison
		System.out.printf("Inital Array: {");
		for (AnyType anyType : a) {
			System.out.printf("%3s, ", anyType.toString());
		}
		System.out.printf("\b\b}\n");

		//gap-sorts from gap-size gaps[0] -> gaps[n]
        for( int gap : gaps){
            int swaps = 0;
			for( int i = gap; i < a.length; i++ ){
				// add a[i] to the elements that have been gap 
				// sorted save a[i] in temp and make a hole at 
				// position i 
                AnyType tmp = a[ i ];
				// shift earlier gap-sorted elements up until 
				// the correct location for a[i] is found 
                for( j = i; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap ){
					swaps++;
					a[ j ] = a[ j - gap ];
				}

				// put temp (the original a[i]) in its correct 
				// location 
                a[ j ] = tmp;
            }	
		//prints working array and swaps committed
		System.out.printf("After %d sort:  ", gap);
		for(int i = 0; i < a.length;i++)
			System.out.printf("%3s, ",a[i].toString());
		System.out.printf("\b\b");
		System.out.printf("    with %d swaps\n", swaps);
		}
    }



	/**
	 * A wrapper for the actual MergeSort
	 * @param a
	 */
	public static void mergeSort(int [] a)
	{
		int [] tmpArray = new int[a.length];
		
		mergeSort(a,tmpArray,0,a.length - 1);
		
	}
	/**
	 * 
	 * @param a - User Input Array
	 * @param tmpArray - array 'a' length shallow copied
	 * @param left - farthest left of array
	 * @param right - farthest right of array
	 */
	private static void mergeSort(int[] a, int[] tmpArray, int left, int right) 
	{
		// Auto-generated method stub
		if(left < right)
		{
			int center = (left + right) / 2;
			for(int i = left; i <= center;i++ )
			System.out.printf("%d, ", a[i]);
			System.out.print("          " );
			for(int i = center+1; i <= right; i++)
				System.out.printf("%d,", a[i]);
			System.out.println();
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center+ 1, right);
			merge(a, tmpArray, left, center+1, right);
		}
		
	}

	/**
	 * 
	 * @param a
	 * @param tmpArray
	 * @param leftPos
	 * @param rightPos
	 * @param rightEnd
	 */
	private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) 
	{
		int leftEnd = rightPos -1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd)
			if(a[leftPos] <= a[rightPos])
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];
		while (leftPos <=leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];
		while(rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];
		for(int i = 0; i < numElements; i++, rightEnd --)
			a[rightEnd] = tmpArray[rightEnd];
		for(int i = 0; i < a.length;i++)
			System.out.printf("%d, ", a[i]);
		System.out.println();
				
	}

	/**
	 * 
	 * @param a
	 */
	public static void quicksort(Comparable[ ] a) 
	{
		quicksort( a, 0, a.length - 1 );
	}
		
	/**
	 * 
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void quicksort( Comparable [ ] a, int low, int high ) {
		if( low + CUTOFF > high )
		{
			System.out.printf("%d is low pos, and %d is high pos in range:\n", low,high);
			for(int i = 0; i < a.length;i++)
			{
				if(i>=low && i<=high)
					System.out.printf("%d*\t",a[i]);
				else
				System.out.printf("\t");
			}
			System.out.println("\nPost Insertion sorting:");
			insertionSort( a, low, high );
		for(int i = 0; i < a.length;i++)
			System.out.printf("%d\t ", a[i]);
		System.out.println();
		}
		else {
			// Sort low, middle, high
			int middle = ( low + high ) / 2;
			System.out.println("\nMEDIAN 3");
			for(int i = 0; i < a.length;i++)
				System.out.printf("%d\t", a[i]);
				System.out.println();
				for(int i = 0; i < a.length; i++)
				{
					if(i==low || i==high || i==middle)
						System.out.printf("%d*\t", a[i]);
					else System.out.printf("\t");
				}
				System.out.println();
				if( a[ middle ].compareTo( a[ low ] ) < 0 )
					
					swapReferences( a, low, middle );
				if( a[ high ].compareTo( a[ low ] ) < 0 )
					swapReferences( a, low, high );
				if( a[ high ].compareTo( a[ middle ] ) < 0 )
					swapReferences( a, middle, high );

				// Place pivot at position high - 1
				swapReferences( a, middle, high - 1 );
				Comparable pivot = a[ high - 1 ];
				System.out.println("PIVOT IS :" + pivot);
				for(int i = 0; i<a.length;i++)
				{
					if(i==high-1)
						System.out.printf("%d*\t", a[i]);
					else
						System.out.printf("%d\t",a[i]);
				}
				System.out.println();

				// Begin partitioning
				int i, j;
				for( i = low, j = high - 1; ; ) {
					while( a[ ++i ].compareTo( pivot ) < 0 );

					while( pivot.compareTo( a[ --j ] ) < 0 );
					if( i >= j )
						break;
					for(int x = 0; x < a.length;x++)
					{
						if(x==i )
							System.out.printf("%di\t", a[i]);
						else if(x==j)
							System.out.printf("%dj\t", a[j]);
						else System.out.printf("%d\t", a[x]);
					}
					System.out.println("\t BEING SWAPPED");
					swapReferences( a, i, j );
					System.out.println("Post Swapped");
					for(int q = 0; q < a.length;q++)
						System.out.printf("%d\t",a[q]);
					System.out.println();
				}

					// Restore pivot
				swapReferences( a, i, high - 1 );

				for(int z = 0; z < a.length; z++)
				{
					if(z>=low && z<=i-1)
						System.out.printf("%d\t",a[z]);
					else
						System.out.printf("\t");
				}
				System.out.println(" IS S1");
				for(int z = 0; z < a.length; z++)
				{
					if(z>=i+1 && z<=high)
						System.out.printf("%d\t",a[z]);
					else
						System.out.printf("\t");
				}
				System.out.println(" IS S2");

				quicksort( a, low, i - 1 );    // Sort small elements
				quicksort( a, i + 1, high );   // Sort large elements
		}
	}

	/**
	 * Method to swap to elements in an array.
	 * @param a an array of objects.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static final void swapReferences( Object [ ] a, int index1, int index2 ) {
		Object tmp = a[ index1 ];
		a[ index1 ] = a[ index2 ];
		a[ index2 ] = tmp;
	}

	private static void pressAnyKeyToContinue()
 	{ 
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
 }


}