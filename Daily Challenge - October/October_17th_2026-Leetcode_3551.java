// -- Leetcode 3551 -- 
// -- Minimum Swaps to Sort by Digit Sum -- 

APPROACH I: 
  // Using Permutation Cycles
  
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, sum(i));
        }

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (!map.get(nums[a]).equals(map.get(nums[b]))) {
                return Integer.compare(map.get(nums[a]), map.get(nums[b]));
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[arr[i]] = i;
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || target[i] == i) {
                continue;
            }

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = target[j];
                cycle++;
            }

            ans += cycle - 1;
        }

        return ans;
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private int sum(int i) {
        int sum = 0;

        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }
}


/* 
Complexity:

Let n be the length of the array nums, and M be the maximum value in the array.

Time complexity: O(nlogn+nlogM).

Calculating the digit sums takes O(nlogM), sorting takes O(nlogn), and traversing the permutation cycles takes O(n). The overall time complexity is O(nlogn+nlogM).

Space complexity: O(n).

We need four auxiliary arrays, digitSum, indices, targetPos, and visited, each taking O(n) space.
*/
