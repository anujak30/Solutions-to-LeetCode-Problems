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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        if (root == null) {
            return allPaths;
        }
        StringBuilder sb = new StringBuilder();
        navigatePaths(root, allPaths, sb);
        return allPaths;
    }
    public void navigatePaths(TreeNode root, List<String> allPaths, StringBuilder currentPath) {
        int len = currentPath.length();
        if (root.left == null && root.right == null) {
            allPaths.add(currentPath.append(root.val).toString());
            currentPath.setLength(len);
        } else {
            currentPath.append(root.val).append("->");
            if (root.left != null) {
                navigatePaths(root.left, allPaths, currentPath);
            }
            if (root.right != null) {
                navigatePaths(root.right, allPaths, currentPath);
            }
            currentPath.setLength(len);
        }
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
// Memory Usage: 39.1 MB, less than 99.06% of Java online submissions for Binary Tree Paths.