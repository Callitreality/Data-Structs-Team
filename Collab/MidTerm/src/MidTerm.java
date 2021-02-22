
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;
import java.util.Scanner;

public class MidTerm {

	public static void main(String[] args) {

		System.out.print("Enter Size of the Array: ");
		Scanner userIn = new Scanner(System.in);
		int arrayInput = userIn.nextInt();
		System.out.println();

		// Array
		int[] userArr = new int[arrayInput];
		System.out.println("Enter array: ");
		for (int i = 0; i < arrayInput; i++) 
		{
			userArr[i] = userIn.nextInt();
		}

		/**
		 * Testing Purposes...
		 */
		// System.out.println("\n\nPrinted Array:");
		// for (int i = 0; i < arrayInput; i++) 
		// {
		// 	System.out.printf("%d ", userArr[i]);
		// }

		// User Validation...
		System.out.printf("\n\n1 - Quick Sort\n" 
		+ "2 - Merge Sort\n" 
		+ "3 - Inversion Count\n" 
		+ "4 - Shell Sort\n" 
		+ "5 - Exit...\n" );

		System.out.printf("Please choose what sorting algorithm you want: ");
		int intInput = userIn.nextInt();
		userIn.close(); // Closing Scanner

		if (intInput == 1) // Quick Sort
		{
		System.out.println("\nQuick Sort:");

		}
		else if (intInput == 2) // Merge Sort
		{
		System.out.println("\nMerge Sort:");

		}
		else if (intInput == 3) // Inversion Count
		{
			System.out.println("\nInversion Count");

		}
		else if (intInput == 4) // Shell Sort
		{
			System.out.println("\nShell Sort");

		}
		else if (intInput == 5) // Closing
		{
			System.out.println("Have a good day!  (•◡•) /");
			System.exit(0);
		}
		else // Closing loose ends...
		{
			System.out.println("Please select a different option..");
		}
	}
}