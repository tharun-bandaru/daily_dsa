package daily_dsa;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /**
     * Generates all possible subsets (power set) of the given array.
     *
     * @param nums Array of integers for which subsets need to be generated.
     * @return List of all subsets of the input array.
     */
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); // List to store all subsets
        List<Integer> list = new ArrayList<>(); // Temporary list to store the current subset
        backtrack(0, nums, nums.length, list, ans); // Start backtracking from index 0
        return ans;
    }

    /**
     * Recursive method to generate subsets using backtracking.
     *
     * @param ind Current index in the array.
     * @param nums Input array.
     * @param n Length of the input array.
     * @param list Temporary list to store the current subset.
     * @param ans Final list containing all subsets.
     */
    public void backtrack(int ind, int[] nums, int n, List<Integer> list, List<List<Integer>> ans) {
        // Base case: if the index reaches the end of the array
        if (ind == n) {
            ans.add(new ArrayList<>(list)); // Add the current subset to the result
            return;
        }

        // Include the current element in the subset
        list.add(nums[ind]);
        backtrack(ind + 1, nums, n, list, ans); // Move to the next index
        list.remove(list.size() - 1); // Backtrack by removing the last added element

        // Exclude the current element from the subset
        backtrack(ind + 1, nums, n, list, ans); // Move to the next index without including the element
    }
    public static void main(String[] args) {
       PowerSet sol = new PowerSet();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = sol.powerSet(nums);

        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
