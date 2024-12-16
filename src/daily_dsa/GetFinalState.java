package daily_dsa;

public class GetFinalState {

	public static int[] getFinalState(int[] nums, int k, int multiplier) {

		for (int i = 0; i < k; i++) {
			int index = 0;
			int minIndex = Integer.MAX_VALUE;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < minIndex) {
					minIndex = nums[j];
					index = j;
				}
			}
			nums[index] = nums[index] * multiplier;
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
