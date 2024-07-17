// 1110. Delete Nodes And Return Forest

// https://leetcode.com/problems/delete-nodes-and-return-forest/

/*

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.

 

Example 1:


Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
Example 2:

Input: root = [1,2,4,null,3], to_delete = [3]
Output: [[1,2,4]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000

 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();
        int[] to_delete_new = new int[to_delete.length + 1];
        System.arraycopy(to_delete, 0, to_delete_new, 0, to_delete.length);
        to_delete_new[to_delete_new.length - 1] = 0;

        TreeNode blank = new TreeNode(0, root, null);
        return helper(root, to_delete);
    }

    public List<TreeNode> helper (TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();
        if (root.left == null && root.right == null) {
            if (contains(to_delete, root.val)) {
                root = null;
                return roots;
            }
        }
        if (root.left != null) {
            roots.addAll(helper(root.left, to_delete));
            if (contains(to_delete, root.left.val)) {
                root.left = null;
            }
        }
        if (root.right != null) {
            roots.addAll(helper(root.right, to_delete));
            if (contains(to_delete, root.right.val)) {
                root.right = null;
            }
        }
        
        if (contains(to_delete, root.val)) {
            if (root.left != null) {
                roots.add(root.left);
            }
            if (root.right != null) {
                roots.add(root.right);
            }
            root.left = null;
            root.right = null;
            root = null;
        }
        return roots;
    }

    public boolean contains(int[] arr, int val) {
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }
}