package src.com.jd.leetcode.textI;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] re = new int[]{-1, -1};
        if (nums.length == 0) {
            return re;
        }
        int left = getLeft(nums, target);
        if (left == -1) {
            return re;
        }
        int right = getRight(nums, target);
        re[0] = left;
        re[1] = right;
        return re;
    }

    private int getLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }

    private int getRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                index = mid;
                left = mid + 1;
            }
        }
        return index;
    }

}
