package daily_dsa;

import java.util.PriorityQueue;

/*
 3264. Final Array State After K Multiplication Operations I

You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.



Example 1:

Input: nums = [2,1,3,5,6], k = 5, multiplier = 2

Output: [8,4,6,5,6]

Explanation:

Operation	Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]
Example 2:

Input: nums = [1,2], k = 3, multiplier = 4

Output: [16,8]

Explanation:

Operation	Result
After operation 1	[4, 2]
After operation 2	[4, 8]
After operation 3	[16, 8]

 */
public class GetFinalState2 {

	// Method to compute the final state of the array
	public static int[] getFinalState(int[] nums, int k, int multiplier) {
		// Create a priority queue (min-heap) to store indices by their values
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[a[0]], nums[b[0]]));

		// Initialize the heap with all elements and their indices
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(new int[] { i });
		}

		// Perform k operations
		for (int i = 0; i < k; i++) {
			// Get the index of the minimum element
			int[] min = minHeap.poll();
			int index = min[0];

			// Update the value by multiplying it
			nums[index] *= multiplier;

			// Re-insert the updated index into the heap
			minHeap.offer(new int[] { index });
		}

		return nums;
	}

	public static void main(String[] args) {

		int[] nums = {2,1,3,5,6};
		int k = 5, multiplier = 2;
		getFinalState(nums,k,multiplier);
				for(int i: nums) { System.out.print(i+" ");};
	}

}
