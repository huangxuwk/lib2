package src.com.jd.leetcode.textI;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> llist = new ArrayList<>();
        if (nums.length == 0) {
            return llist;
        }
        int[] sign = new int[nums.length];
        perm(llist, nums, new ArrayList<Integer>(), sign);
        return llist;
    }

    private void perm(List<List<Integer>> llist, int[] nums, List<Integer> list, int[] sign) {
        if (list.size() >= nums.length) {
            llist.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sign[i] == 0) {
                sign[i] = 1;
                list.add(nums[i]);
                perm(llist, nums, list, sign);
                sign[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

}
