// 1637. Widest Vertical Area Between Two Points Containing No Points

// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

/*

Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.

A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.

Note that points on the edge of a vertical area are not considered included in the area.

 

Example 1:

​
Input: points = [[8,7],[9,9],[7,4],[9,7]]
Output: 1
Explanation: Both the red and the blue area are optimal.
Example 2:

Input: points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
Output: 3
 

Constraints:

n == points.length
2 <= n <= 105
points[i].length == 2
0 <= xi, yi <= 109
 */

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        //Faster solution
        int widest = 0;
        int[] numbers = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            numbers[i] = points[i][0];
        }

        Arrays.sort(numbers);
        for (int k = 0; k < numbers.length-1; k++) {
            int diff = Math.abs(numbers[k] - numbers[k+1]);
            if (diff > widest) {
                widest = diff;
            }
        }
        return widest;

        /*
        //Slow solution
        int widest = 0;
        //sort the array by x value
        Arrays.sort(points, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            int a1 = a[0];
            int b1 = b[0];

            // Integer.compare(a1, b1)
            if (a1 < b1) {
            return -1; // negative = less than
            } else if (a1 == b1) {
            return 0; // zero = equal to
            } else {
            return 1; // positive = greater than
            }
        }
        });


        for (int i = 0; i < points.length-1; i++) {
            int diff = Math.abs(points[i][0] - points[i+1][0]);
            if (diff > widest) {
                widest = diff;
            }
        }
        return widest;*/
        
    }
}