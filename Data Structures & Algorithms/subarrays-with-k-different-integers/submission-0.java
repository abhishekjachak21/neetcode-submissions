class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        int left = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            // 1. Expand
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // 2. Shrink till valid
            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            // 3. Update
            count += right - left + 1;
        }

        return count;
    }
}

/*

Core understanding 🧠
Hum At Most isliye nahi nikal rahe kyunki Exactly K nikalna impossible hai. Hum At Most isliye nikal rahe hain kyunki usko efficiently count karna aasaan hai.

*/