class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        for(; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(j < i) {
                    nums[j] = nums[i];
                    nums[i] =0;
                }
            j++;
            }        
        }
    }
}