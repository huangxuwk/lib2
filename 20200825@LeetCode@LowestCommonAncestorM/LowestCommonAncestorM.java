package src.com.jd.leetcode.textK;

import src.com.jd.leetcode.util.TreeNode;

public class LowestCommonAncestorM {
    private TreeNode node;
    private int deep = Integer.MAX_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowest(root, p, q, 0);
        return node;
    }

    private boolean lowest(TreeNode root, TreeNode p, TreeNode q, int deep) {
        if (root == null) {
            return false;
        }
        boolean left = lowest(root.left, p, q, deep + 1);
        boolean right = lowest(root.right, p, q, deep + 1);
        if (root.val == p.val || root.val == q.val) {
            if ((left || right) && deep < this.deep) {
                node = root;
                this.deep = deep;
            }
            return true;
        }
        if ((left && right) && deep < this.deep) {
            node = root;
            this.deep = deep;
            return true;
        }
        return left || right;
    }
}
