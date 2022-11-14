/*
* This is a class to display the use of recursive sort
* merge on an array of integers. It contains the
* following functions:
*	mergeSort(int[]) - takes an array of integers and
*		separates them into two equally sized arrays
*		to be recursively separated and sorted
*	merge(int[] list, int[] leftList[], int[] rightList[]) -
*		takes the two separated lists that have been
*		already sorted and merges them together by
*		sorting (comparing each next element in left and
*		right lists against the other)
* This program prints the unsorted list, sorts it, then
* prints the sorted list.
*
* @author Stephanie Gremillion
* @version 17.0.2
* @since 2022/11/14
*/

import java.util.Arrays;

class MergeSort {
	public static void main(String[] args) {
		int[] list = { -100, -6, 34, 968, -21, 97, 440, -237, 106, -54 };

		// printing unsorted list
		System.out.println("Unsorted list:");
		for(int i = 0; i < list.length; i++) {
			if(i != list.length - 1) { System.out.print(list[i] + ", "); }
			else { System.out.print(list[i]); }
		}
		System.out.println("\n");

		// sorting list
		System.out.println("Sorting list...\n");
		mergeSort(list);

		// printing sorted list
		System.out.println("Sorted list:");
		for(int i = 0; i < list.length; i++) {
			if(i != list.length - 1) { System.out.print(list[i] + ", "); }
			else { System.out.print(list[i]); }
		}
		System.out.println();
	}


	public static void mergeSort(int[] list) {
		// base case if cannot sort
		if(list.length <= 1) { return; }

		// finding the two lists
		int mid = list.length / 2;
		int[] leftList = new int[mid];
		int[] rightList = new int[list.length - mid];
		for(int i = 0; i < mid; i++) { leftList[i] = list[i]; }
		for(int i = mid, ii = 0; i < list.length; i++, ii++) { rightList[ii] = list[i]; }

		// sorting the lists
		mergeSort(leftList);
		mergeSort(rightList);

		// merging the lists
		merge(list, leftList, rightList);

	}

	public static void merge(int[] list, int[] leftList, int[] rightList) {
		int next = 0; // where the next sorted item goes in the list
		int left = 0; // where the next item to be sorted in the left list
		int right = 0; // where the next item to be sorted in the right list

		// while both of the left and right index points are
		// still within the length of their respective arrays,
		// compare and sort the lists
		while(left < leftList.length && right < rightList.length) {
			// if the next in left list is smaller than the next
			// in the right list, add the next in the left list
			if(leftList[left] < rightList[right]) {
				list[next] = leftList[left];
				left++;
			}
			// otherwise, add the next in the right list
			else {
				list[next] = rightList[right];
				right++;
			}
			next++;
		}

		// adding the remaining items from the left list
		while(left < leftList.length) {
			list[next] = leftList[left];
			left++;
			next++;
		}

		// adding the remaining items from the right list
		while(right < rightList.length) {
			list[next] = rightList[right];
			right++;
			next++;
		}
	}
}