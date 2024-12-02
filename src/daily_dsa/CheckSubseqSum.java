package daily_dsa;

public class CheckSubseqSum {

	/**
	 * Checks if there exists a subsequence in the given array `nums`
	 * whose sum equals `k`.
	 *
	 * @param nums Array of integers
	 * @param k    Target sum
	 * @return     True if such a subsequence exists, otherwise false
	 */
	public boolean checkSubsequenceSum(int[] nums, int k) {
		// Start the recursive helper function from index 0 and the given sum `k`
		return bool(0, nums, k);
	}

	/**
	 * Recursive function to determine if a subsequence exists with a given sum.
	 *
	 * @param ind Current index in the array
	 * @param nums Array of integers
	 * @param sum Remaining sum to check
	 * @return    True if a subsequence exists with the given sum, otherwise false
	 */
	public boolean bool(int ind, int[] nums, int sum) {
		// Base Case 1: If sum is 0, we found a valid subsequence
		if (sum == 0) return true;

		// Base Case 2: If index is out of bounds or sum becomes negative, return false
		if (sum < 0 || ind == nums.length) return false;

		// Recursive Case:
		// Path 1: Include the current element and subtract it from the sum
		boolean path1 = bool(ind + 1, nums, sum - nums[ind]);

		// Path 2: Skip the current element and proceed to the next
		boolean path2 = bool(ind + 1, nums, sum);

		// Return true if either path1 or path2 returns true
		return path1 || path2;
	}

	public static void main(String[] args) {
		CheckSubseqSum solution = new  CheckSubseqSum();

		// Test case 1: Positive case
		int[] nums1 = {1, 2, 3, 4, 5};
		int k1 = 9;
		System.out.println("Test Case 1: " + solution.checkSubsequenceSum(nums1, k1)); 
		// Output: true (e.g., 4 + 5 = 9)

		// Test case 2: Negative case
		int[] nums2 = {1, 2, 3};
		int k2 = 7;
		System.out.println("Test Case 2: " + solution.checkSubsequenceSum(nums2, k2)); 
		// Output: false (no subsequence sums to 7)

		// Test case 3: Edge case (empty array)
		int[] nums3 = {};
		int k3 = 0;
		System.out.println("Test Case 3: " + solution.checkSubsequenceSum(nums3, k3)); 
		// Output: true (sum 0 can be achieved with an empty subsequence)

		// Test case 4: Edge case (negative numbers)
		int[] nums4 = {2, -3, 7};
		int k4 = 4;
		System.out.println("Test Case 4: " + solution.checkSubsequenceSum(nums4, k4)); 
		// Output: true (e.g., 2 + (-3) + 7 = 4)

		// Test case 5: Large target sum
		int[] nums5 = {10, 15, 20, 25};
		int k5 = 100;
		System.out.println("Test Case 5: " + solution.checkSubsequenceSum(nums5, k5)); 
		// Output: false (sum is too large to be achieved)
	}
}
