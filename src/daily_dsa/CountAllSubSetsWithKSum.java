package daily_dsa;

public class CountAllSubSetsWithKSum {

}
class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here

        return count(0,nums,k);
    }

    public int count(int ind, int[] nums, int k){

        if ( k == 0)
            return 1;
        
        if( k<0 || ind == nums.length)
            return 0;
        
        int path1 = count( ind+1, nums, k-nums[ind]);
        int path2 = count( ind+1, nums, k);
       
        return path1+path2;
    }
}