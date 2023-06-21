/** @author Peter Adi Saputro 07 June 2023 */
import java.util.*;
import java.util.regex.*;

public class QuickSort
{
   public static void main(String[] args)
   {
	   System.out.print("Input numbers to be sorted (separated by comma): ");
	   Scanner input = new Scanner(System.in);
	   String strInput = input.nextLine(); // read input from user
	   Scanner s = new Scanner(strInput).useDelimiter("\\s*,\\s*");
       int n = 0;
       // count how many numbers inputed by user
   	   while(s.hasNextInt())
       {
		   n++;
		   s.nextInt();
       }

	   // defined input and output array
       int[] numbersInput = new int[n];
       n = 0;

       // regex: zero or more white space characters followed by , followed by zero or more white space characters
       s = new Scanner(strInput).useDelimiter("\\s*,\\s*");

       // split user input into array
       while(s.hasNextInt())
       {
		   numbersInput[n] = s.nextInt();
		   n++;
	   }

	   System.out.println("Before sorting: ");
	   printArray(numbersInput);

	   quickSort(numbersInput, 0, numbersInput.length - 1);

	   System.out.println("After sorting: ");
	   printArray(numbersInput);

	   System.exit(0);
   }

   // Basically QuickSort algorithm is a Divide and Conquer algorithm, there are many versions of QuickSort differentiated by its pivot selection
   // The main process of Quicksort algorithm is a recursive function
   public static void quickSort(int[] array, int low, int high)
   {
	   if (low < high) {
		   int pivotIndex = partition(array, low, high);

		   quickSort(array, low, pivotIndex - 1); // left side of pivot
		   quickSort(array, pivotIndex + 1, high); // right side of pivot
	   }
   }

   // Lomuto partition scheme is used in this implementation of Quicksort algorithm
   public static int partition(int[] array, int low, int high)
   {
	   // choose the last element as pivot
	   int pivot = array[high];
	   int i = low - 1; // temporary pivot index

	   for (int j = low; j < high; j++) {
		   if (array[j] <= pivot) {
			   i++;
			   swap(array, i, j);
		   }
	   }

	   // move the pivot element to the correct pivot position
	   swap(array, i + 1, high);

	   return i + 1;
   }

   public static void swap(int[] array, int i, int j)
   {
	   int temp = array[i];
	   array[i] = array[j];
	   array[j] = temp;
   }

   public static void printArray(int[] array)
   {
	   for (int element : array) {
		   System.out.print(element + " ");
	   }
	   System.out.println();
   }
}
