package src.com.jd.leetcode.textJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> llist = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            int left = i + 1;
            int right = len - 1;
            // TwoSum, 遍历第二个数，找第三个数，需要找到所有符合的组合
            for (; left < len; left++) {
                // 避免第二个数重复
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    llist.add(list);
                }
            }
        }
        return llist;
    }

}
