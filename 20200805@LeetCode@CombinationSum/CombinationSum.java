package src.com.jd.leetcode.textI;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> llist = new ArrayList<>();
        if (candidates.length == 0) {
            return llist;
        }
        Set<List<Integer>> set = new HashSet<>();
        combination(set, new ArrayList<>(), candidates, target);
        Iterator<List<Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            llist.add(iterator.next());
        }
        return llist;
    }

    private void combination(Set<List<Integer>> set, List<Integer> list, int[] candidates, int margin) {
        for (int i = 0; i < candidates.length; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidates[i]);
            if (candidates[i] == margin) {
                Collections.sort(temp);
                set.add(temp);
            } else if (candidates[i] < margin) {
                combination(set, temp, candidates, margin - candidates[i]);
            }
        }
    }

}
