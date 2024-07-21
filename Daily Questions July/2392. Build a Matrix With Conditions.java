// 2392. Build a Matrix With Conditions

// https://leetcode.com/problems/build-a-matrix-with-conditions/

/*

You are given a positive integer k. You are also given:

a 2D integer array rowConditions of size n where rowConditions[i] = [abovei, belowi], and
a 2D integer array colConditions of size m where colConditions[i] = [lefti, righti].
The two arrays contain integers from 1 to k.

You have to build a k x k matrix that contains each of the numbers from 1 to k exactly once. The remaining cells should have the value 0.

The matrix should also satisfy the following conditions:

The number abovei should appear in a row that is strictly above the row at which the number belowi appears for all i from 0 to n - 1.
The number lefti should appear in a column that is strictly left of the column at which the number righti appears for all i from 0 to m - 1.
Return any matrix that satisfies the conditions. If no answer exists, return an empty matrix.

 

Example 1:


Input: k = 3, rowConditions = [[1,2],[3,2]], colConditions = [[2,1],[3,2]]
Output: [[3,0,0],[0,0,1],[0,2,0]]
Explanation: The diagram above shows a valid example of a matrix that satisfies all the conditions.
The row conditions are the following:
- Number 1 is in row 1, and number 2 is in row 2, so 1 is above 2 in the matrix.
- Number 3 is in row 0, and number 2 is in row 2, so 3 is above 2 in the matrix.
The column conditions are the following:
- Number 2 is in column 1, and number 1 is in column 2, so 2 is left of 1 in the matrix.
- Number 3 is in column 0, and number 2 is in column 1, so 3 is left of 2 in the matrix.
Note that there may be multiple correct answers.
Example 2:

Input: k = 3, rowConditions = [[1,2],[2,3],[3,1],[2,3]], colConditions = [[2,1]]
Output: []
Explanation: From the first two conditions, 3 has to be below 1 but the third conditions needs 3 to be above 1 to be satisfied.
No matrix can satisfy all the conditions, so we return the empty matrix.
 

Constraints:

2 <= k <= 400
1 <= rowConditions.length, colConditions.length <= 104
rowConditions[i].length == colConditions[i].length == 2
1 <= abovei, belowi, lefti, righti <= k
abovei != belowi
lefti != righti



 */

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int [][] matrix = new int[k][k];

        Map<Integer, List<Integer>> adjListRow = adjListMaker(k, rowConditions);
        Map<Integer, List<Integer>> adjListCol = adjListMaker(k, colConditions);
        int [] blank = new int[k]; 
        int[] row = khansAlg(k, adjListRow);
        int[] col = khansAlg(k, adjListCol);

        int [][] matrixFalse = new int[0][0];
        if (row == null || col == null) {
            return matrixFalse;
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == col[j]) {
                    matrix[i][j] = row[i];
                }
            }
        }

        return matrix;


    }

    public Map<Integer, List<Integer>> adjListMaker(int k, int[][] conditions) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] cond : conditions) {
            if (adjList.containsKey(cond[0])) {
                if (!adjList.get(cond[0]).contains(cond[1])) {
                    adjList.get(cond[0]).add(cond[1]);
                }
            } else {
                List<Integer> adj = new ArrayList<>();
                adj.add(cond[1]);
                adjList.put(cond[0], adj);
            }
        }
        return adjList;
    }

    public int[] inDegrees (int k, Map<Integer, List<Integer>> adjList) {
        int[] inDegrees = new int[k + 1];
        for (int m : adjList.keySet()) {
            for (int i : adjList.get(m)) {
                inDegrees[i] += 1;
            }
        }
        return inDegrees;
    }


    public int[] khansAlg(int vertices, Map<Integer, List<Integer>> adjList) {
        // add all nodes with in-degree 0 to a queue
        // in-degree 0 means that there is no edge that must go into it
        // this would mean that it is never on the right side of the array ([1, 5] for example means 1 --> 5)
        Queue<Integer> starting = new LinkedList<>();
        int[] inDegrees = inDegrees(vertices, adjList);
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                starting.add(i);
            }
        }

        int[] indices = new int[vertices];
        int i = 0;
        while (!starting.isEmpty()) {
            int curr = starting.poll();
            if (adjList.containsKey(curr)) {
                for (int vertex : adjList.get(curr)) {
                    inDegrees[vertex]--;
                    if (inDegrees[vertex] == 0) {
                        starting.add(vertex);
                    }
                }
                adjList.remove(curr);
            }
            indices[i] = curr;
            i++;
        }


        if (!adjList.isEmpty()) {
            return null;
        }
        
        return indices;


    }

}