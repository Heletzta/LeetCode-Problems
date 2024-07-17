// 2096. Step-By-Step Directions From a Binary Tree Node to Another

// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

/*
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
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
    HashMap<Integer, ArrayList<Integer>> children;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathStart = new StringBuilder();
        getPath(root, startValue, pathStart);
        StringBuilder pathDest = new StringBuilder();
        getPath(root, destValue, pathDest);
        
        int i = 0;
        while (i < pathDest.length() && i < pathStart.length() && pathDest.charAt(i) == pathStart.charAt(i)) {
            i++;
        }
        StringBuilder path = new StringBuilder();
        for (int k = i; k < pathStart.length(); k++) {
            path.append("U");
        }
        for (int l = i; l < pathDest.length(); l++) {
            path.append(pathDest.charAt(l));
        }

        return path.toString();
    }

    
    public boolean getPath(TreeNode node, int value, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        }

        path.append("L");
        if (getPath(node.left, value, path)) {
            return true;
        } else {
            path.deleteCharAt(path.length() - 1);
        }
        
        path.append("R");
        if (getPath(node.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;

        
        // too slow, but also works! gets all the children before it runs, and the getting children takes too long
        /*loop: while (node != null && node.val != value) {
            if (children.get(node.val).isEmpty()) {
                break loop;
            } else if (node.left != null && children.get(node.left.val).contains(value)) {
                node = node.left;
                path.append("L");
            } else if (node.right != null && children.get(node.right.val).contains(value)) {
                node = node.right;
                path.append("R");
            } else if (node.left != null && node.left.val == value) {
                path.append("L");
                break loop;
            } else {
                path.append("R");
                break loop;
            }
        }
        return path;*/
    }



/*
    HashMap<Integer, ArrayList<Integer>> childrenG = new HashMap<>();

    public HashMap<Integer, ArrayList<Integer>> getChildren(TreeNode node) {
        ArrayList<Integer> childrenNode = new ArrayList<>();
        if (node.left != null) {
            childrenNode.add(node.left.val);
            HashMap<Integer, ArrayList<Integer>> childrenLeft = getChildren(node.left);
            for (ArrayList<Integer> k : childrenLeft.values()) {
                childrenNode.addAll(k);
            }
            childrenG.putAll(childrenLeft);
        }
        if (node.right != null) {
            childrenNode.add(node.right.val);
            HashMap<Integer, ArrayList<Integer>> childrenRight = getChildren(node.right);
            for (ArrayList<Integer> k : childrenRight.values()) {
                childrenNode.addAll(k);
            }
            childrenG.putAll(childrenRight);
        }
        childrenG.put(node.val, childrenNode);
        return childrenG;

    }
    */

    /*public HashMap<Integer, Integer> getParents(TreeNode node) {
        HashMap<Integer, Integer> parentsG = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();;
        if (node.left == null && node.right == null) {
            return parentsG;
        }
        if (node.left != null) {
            parentsG.put(node.left.val, node.val);
            left = getParents(node.left);

        }
        if (node.right != null) {
            parentsG.put(node.right.val, node.val);
            right = getParents(node.right);
        }
        
        if (!left.isEmpty()) {
            parentsG.putAll(left);
            
        }
        if (!right.isEmpty()) {
            parentsG.putAll(right);
        }
        return parentsG;

    }*/
}