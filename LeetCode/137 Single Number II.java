public class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int result = 0;

        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < len; j++) {
                sum += ((nums[j] >> i) & 1);
            }

            result += (sum % 3) << i;
        }

        return result;
    }
}
