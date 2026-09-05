import java.util.HashMap;
import java.util.Map;
public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Long, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0L, 1);
        long prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            count += prefixFrequencies.getOrDefault(prefixSum - k, 0);
            prefixFrequencies.put(prefixSum, prefixFrequencies.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}