package src.com.jd.leetcode.textI;

public class Search {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (target > nums[len - 1] && target < nums[0]) {
            return -1;
        }
        if (len == 1 && target == nums[0]) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (target <= nums[len - 1]) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target){
                    if (nums[mid] > nums[len - 1]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    return mid;
                }
            } else if (target >= nums[0]) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    if (nums[mid] < nums[0]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    return mid;
                }
            }
        }

        return -1;
    }

}
