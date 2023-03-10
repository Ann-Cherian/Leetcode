class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructHelper(grid, 0, 0, n);
    }
    private Node constructHelper(int[][] grid, int row, int col, int size) {
        if (size == 1) {
            return new Node(grid[row][col] == 1, true, null, null, null, null);
        }
        
        int halfSize = size / 2;
        Node topLeft = constructHelper(grid, row, col, halfSize);
        Node topRight = constructHelper(grid, row, col + halfSize, halfSize);
        Node bottomLeft = constructHelper(grid, row + halfSize, col, halfSize);
        Node bottomRight = constructHelper(grid, row + halfSize, col + halfSize, halfSize);
        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && 
            ((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
             (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val))) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}
 