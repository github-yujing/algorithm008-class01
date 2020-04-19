class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
          return nums.length;
        }
        int fir = 0;
        int sec = 1;
        while (sec < nums.length) {
            if (nums[sec] != nums[fir]) {
                if (++fir < sec) {
                    nums[fir] = nums[sec];
                }
            }
            sec++;
        }
        return fir+1;
    }
}