// 2196. Create Binary Tree From Descriptions

// https://leetcode.com/problems/create-binary-tree-from-descriptions/

/*

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

 

Example 1:


Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.
Example 2:


Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.
 

Constraints:

1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // the root node is the node that is never a child
        // you want to organize it so that you start from the leaves and build upwards!
        //leaves are never parents!!
        // then you want to go through the parents of those leaves, and the parents of the parents, etc until you get to the root! -- which you found at the beginning -- that's how you know when to stop (since values are unique)
        
        //make a set of children and a set of parents?
        //First:
        //find the root node
        // find the leaf nodes
        HashMap<Integer, int[]> parentToChild = new HashMap<>();
        Set<Integer> root = new HashSet<>();
        for (int[] k : descriptions) {
            int parent = k[0];
            root.add(parent);
            int child = k[1];
            int isLeft = k[2];
            if (!parentToChild.containsKey(parent)) {
                int[] children = new int[2];
                if (isLeft == 1) {
                    children[0] = child;
                } else {
                    children[1] = child;
                }
                parentToChild.put(parent, children);
            } else {
                if (isLeft == 1) {
                    parentToChild.get(parent)[0] = child;
                } else {
                    parentToChild.get(parent)[1] = child;
                }
            }
        }

        for (int[] desc : descriptions) {
            if (root.contains(desc[1])) {
                root.remove(desc[1]);
            } 
        }
        int rootVal = 0;
        for (int val : root) {
            rootVal = val;
        }

        TreeNode rootNode = new TreeNode(rootVal);
        helper(parentToChild, rootNode);
        return rootNode;
        

    }

    public void helper(HashMap<Integer, int[]> parentToChild, TreeNode node) {
        if (!parentToChild.containsKey(node.val)) {
            return;
        }
        int left = parentToChild.get(node.val)[0];
        int right = parentToChild.get(node.val)[1];
        if (left != 0) {
            node.left = new TreeNode(left);
            helper(parentToChild, node.left);
        }
        if (right != 0) {
            node.right = new TreeNode(right);
            helper(parentToChild, node.right);
        }

    }
}