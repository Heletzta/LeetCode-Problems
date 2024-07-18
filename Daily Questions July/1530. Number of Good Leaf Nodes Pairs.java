// 1530. Number of Good Leaf Nodes Pairs

// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/

/*

You are given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a binary tree is said to be good if the length of the shortest path between them is less than or equal to distance.

Return the number of good leaf node pairs in the tree.

 

Example 1:


Input: root = [1,2,3,null,4], distance = 3
Output: 1
Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between them is 3. This is the only good pair.
Example 2:


Input: root = [1,2,3,4,5,6,7], distance = 3
Output: 2
Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good because the length of ther shortest path between them is 4.
Example 3:

Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
Output: 1
Explanation: The only good pair is [2,5].
 

Constraints:

The number of nodes in the tree is in the range [1, 210].
1 <= Node.val <= 100
1 <= distance <= 10

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
    HashMap<TreeNode, List<TreeNode>> adj = new HashMap<>();
    Set<TreeNode> leaves = new HashSet<>();
    public int countPairs(TreeNode root, int distance) {
        // something is a leaf node if it has no children
        // shortest distance will always be to the common parent and then down to the other node
        int count = 0;
        
        // find leaves and make adjacency list
        traverseTree(root, null);

        if (leaves.size() < 2) {
            return 0;
        }
        // go through all the leaves and see if they have pairs
        // remember to divide by 2
        for (TreeNode leaf : leaves) {
            count += bfs(leaf, distance, 0);
        }
        return count / 2;


        // then see how long to get to each node from that ancestor

    }
    
    
    public int bfs(TreeNode node, int distance, int currDist) {
        int count = 0;
        if (currDist > distance) {
            return count;
        }
        HashMap<TreeNode, Integer> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        visited.put(node, currDist);
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll(); 
            for (TreeNode neighbor : adj.get(currentNode)) {
                if (!visited.containsKey(neighbor)) {
                    if (isLeaf(neighbor) && visited.get(currentNode) + 1 <= distance) {
                        count++;
                    } 
                    visited.put(neighbor, visited.get(currentNode) + 1);
                    queue.add(neighbor);
                }
            }
            
            
        }
        return count;
        
    }

    public boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } 
        return false;
    }


    public void traverseTree(TreeNode node, TreeNode parent) {
        if (isLeaf(node)) {
            leaves.add(node);
        }

        if (adj.containsKey(parent) && node != null && parent != null) {
            adj.get(parent).add(node);
        } else if (node != null && parent != null) {
            ArrayList<TreeNode> adjNode = new ArrayList<>();
            adjNode.add(node);
            adj.put(parent, adjNode);
        }

        if (adj.containsKey(node) && parent != null && node != null) {
            adj.get(node).add(parent);
        } else if (parent != null && node != null){
            ArrayList<TreeNode> adjParent = new ArrayList<>();
            adjParent.add(parent);
            adj.put(node, adjParent);
        }
        
        
        if (node.left != null) {
            traverseTree(node.left, node);
        }
        if (node.right != null) {
            traverseTree(node.right, node);
        }
        return;
    }

    

    
}