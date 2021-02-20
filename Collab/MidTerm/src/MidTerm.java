import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class MidTerm 
{
    

	public static void main(String[] args) {

		// User Validation...
		System.out.println("Please choose what sorting algorithm you want: ");
		System.out.printf("1 - Quick Sort\n" + "2 - Merge Sort\n" + "3 - " + "4 - ");

		Scanner userInput = new Scanner(System.in);
		int intInput = userInput.nextInt();

		if (intInput == 1) 
		{
			System.out.println("Enter Array...(Hit Enter After EVERY Number)");
			Scanner userIn = new Scanner(System.in);
			int arrayIn = userInput.nextInt();
			int[] tempArr = arrayIn; // This is definitely wrong....
			
			System.out.println("\nQuick Sort:");
			//quicksort();
			userIn.close();

		}
		else if (intInput == 2)
		{
			System.out.println("\nMerge Sort:");
			int[] a = { 5, 6, 14, 10, 2, 13, 11, 4, 7, 15, 8 };
			mergeSort(a);
		}
		// else if ()
		// {

		// }
		userInput.close();

	}

	public static void quicksort(Comparable[] a) {
		quicksort(a, 0, a.length - 1);
	}

	private static final int CUTOFF = 4;

	private static void quicksort(Comparable[] a, int low, int high) {
		if (low + CUTOFF > high) {
			System.out.printf("%d is low pos, and %d is high pos in range:\n", low, high);
			for (int i = 0; i < a.length; i++) {
				if (i >= low && i <= high)
					System.out.printf("%d*\t", a[i]);
				else
					System.out.printf("\t");
			}
			System.out.println("\nPost Insertion sorting:");
			insertionSort(a, low, high);
			for (int i = 0; i < a.length; i++)
				System.out.printf("%d\t ", a[i]);
			System.out.println();
		} else {
			// Sort low, middle, high
			int middle = (low + high) / 2;
			System.out.println("\nMEDIAN 3");
			for (int i = 0; i < a.length; i++)
				System.out.printf("%d\t", a[i]);
			System.out.println();
			for (int i = 0; i < a.length; i++) {
				if (i == low || i == high || i == middle)
					System.out.printf("%d*\t", a[i]);
				else
					System.out.printf("\t");
			}
			System.out.println();
			if (a[middle].compareTo(a[low]) < 0)

				swapReferences(a, low, middle);
			if (a[high].compareTo(a[low]) < 0)
				swapReferences(a, low, high);
			if (a[high].compareTo(a[middle]) < 0)
				swapReferences(a, middle, high);

			// Place pivot at position high - 1
			swapReferences(a, middle, high - 1);
			Comparable pivot = a[high - 1];
			System.out.println("PIVOT IS :" + pivot);
			for (int i = 0; i < a.length; i++) {
				if (i == high - 1)
					System.out.printf("%d*\t", a[i]);
				else
					System.out.printf("%d\t", a[i]);
			}
			System.out.println();

			// Begin partitioning
			int i, j;
			for (i = low, j = high - 1;;) {
				while (a[++i].compareTo(pivot) < 0)
					;

				while (pivot.compareTo(a[--j]) < 0)
					;
				if (i >= j)
					break;
				for (int x = 0; x < a.length; x++) {
					if (x == i)
						System.out.printf("%di\t", a[i]);
					else if (x == j)
						System.out.printf("%dj\t", a[j]);
					else
						System.out.printf("%d\t", a[x]);
				}
				System.out.println("\t BEING SWAPPED");
				swapReferences(a, i, j);
				System.out.println("Post Swapped");
				for (int q = 0; q < a.length; q++)
					System.out.printf("%d\t", a[q]);
				System.out.println();
			}

			// Restore pivot
			swapReferences(a, i, high - 1);

			for (int z = 0; z < a.length; z++) {
				if (z >= low && z <= i - 1)
					System.out.printf("%d\t", a[z]);
				else
					System.out.printf("\t");
			}
			System.out.println(" IS S1");
			for (int z = 0; z < a.length; z++) {
				if (z >= i + 1 && z <= high)
					System.out.printf("%d\t", a[z]);
				else
					System.out.printf("\t");
			}
			System.out.println(" IS S2");

			quicksort(a, low, i - 1); // Sort small elements
			quicksort(a, i + 1, high); // Sort large elements
		}
	}

	/**
	 * Method to swap to elements in an array.
	 * 
	 * @param a      an array of objects.
	 * @param index1 the index of the first object.
	 * @param index2 the index of the second object.
	 */
	public static final void swapReferences(Object[] a, int index1, int index2) {
		Object tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}

	public static void mergeSort(int[] a) {
		int[] tmpArray = new int[a.length];

		mergeSort(a, tmpArray, 0, a.length - 1);

	}

	private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int center = (left + right) / 2;
			for (int i = left; i <= center; i++) {
				System.out.printf("%d, ", a[i]);
			}
			System.out.print("          ");
			for (int i = center + 1; i <= right; i++) {
				System.out.printf("%d, ", a[i]);
			}
			System.out.println();
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}

	}

	private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos] <= a[rightPos])
				tmpArray[tmpPos++] = a[leftPos++];
			else
				tmpArray[tmpPos++] = a[rightPos++];
		while (leftPos <= leftEnd)
			tmpArray[tmpPos++] = a[leftPos++];
		while (rightPos <= rightEnd)
			tmpArray[tmpPos++] = a[rightPos++];
		for (int i = 0; i < numElements; i++, rightEnd--)
			a[rightEnd] = tmpArray[rightEnd];
		for (int i = 0; i < a.length; i++)
			System.out.printf("%d, ", a[i]);
		System.out.println();

	}

	private static void insertionSort(Comparable[] a, int low, int high) {
		for (int p = low + 1; p <= high; p++) {
			Comparable tmp = a[p];
			int j;

			for (j = p; j > low && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
}
