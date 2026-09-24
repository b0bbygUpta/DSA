// -- Leetcode 1658 -- 
// -- Minimum Operations to Reduce X to Zero -- 

class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;

        int target = total - x;
        if (target < 0) return -1;  // impossible

        int n = nums.length;
        int left = 0, currSum = 0, maxLen = -1;

        // Sliding window to find longest subarray with sum = target
        for (int right = 0; right < n; right++) {
            currSum += nums[right];

            // shrink window if sum exceeds target
            while (currSum > target && left <= right) {
                currSum -= nums[left++];
            }

            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return (maxLen == -1) ? -1 : n - maxLen;
    }
}
