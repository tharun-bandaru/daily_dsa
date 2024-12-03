package daily_dsa;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        // This will store all valid combinations that sum up to the target
	        List<List<Integer>> ans = new ArrayList<>();
	        // This is a temporary list to build combinations during backtracking
	        List<Integer> list = new ArrayList<>();
	        // Start backtracking from the first candidate
	        backtrack(0, candidates, list, ans, target);
	        return ans;
	    }

	    /**
	     * Backtracking helper method to find all combinations.
	     * 
	     * @param ind        The current index in the candidates array.
	     * @param candidates The array of unique integers to choose from.
	     * @param list       The current combination being formed.
	     * @param ans        The list of all valid combinations.
	     * @param sum        The remaining target sum to be achieved.
	     */
	    public void backtrack(int ind, int[] candidates, List<Integer> list, List<List<Integer>> ans, int sum) {
	        // Base case: If the target sum is achieved, add the combination to the result
	        if (sum == 0) {
	            ans.add(new ArrayList<>(list)); // Create a new list to store the current combination
	            return;
	        }

	        // Base case: If the sum becomes negative or we've exhausted all candidates, stop
	        if (sum < 0 || ind == candidates.length) {
	            return;
	        }

	        // Include the current candidate in the combination
	        list.add(candidates[ind]);
	        // Recurse with the same index (ind) since items can be reused
	        backtrack(ind, candidates, list, ans, sum - candidates[ind]);
	        // Backtrack: Remove the last added candidate to explore other possibilities
	        list.remove(list.size() - 1);

	        // Skip the current candidate and move to the next one
	        backtrack(ind + 1, candidates, list, ans, sum);
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
