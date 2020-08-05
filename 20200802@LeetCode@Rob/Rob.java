package src.com.jd.leetcode.textI;

import src.com.jd.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!cache.containsKey(root)) {
            //当前层和下下层的和
            int val1 = root.val;
            if (root.left != null) {
                val1 += helper(root.left.left) + helper(root.left.right);
            }
            if (root.right != null) {
                val1 += helper(root.right.left) + helper(root.right.right);
            }
            //下一层的和
            int val2 = helper(root.left) + helper(root.right);
            cache.put(root, Math.max(val1, val2));
        }
        return cache.get(root);
    }

}
