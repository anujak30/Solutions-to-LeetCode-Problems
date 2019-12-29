/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode originalRoot = root, parent = null;
        String direction = "";
        // 1. Search for key node
        while(root != null) {
            if(key == root.val)
                break;
            parent = root;
            if(key < root.val) {
                direction = "left";
                root = root.left;
            }
            else {
                direction = "right";
                root = root.right;
            }
        }
        
        // Edge Case: root is null, or key does not exist
        if(root == null)                
            return originalRoot;
        // Edge Case: Delete tree with only one node
        if(parent == null && (root.left == null && root.right == null))
            return null;

        // 2. Find in order successor
        TreeNode successor = null;
        if(root.right == null) {
            if(direction == "left")
                parent.left = root.left;
            else if(direction == "right")
                parent.right = root.left;
            else
                return root.left;
        }
        else {
            parent = root;
            successor = root.right;
            direction = "right";
            while(successor.left != null) {
                parent = successor;
                successor = successor.left;
                direction = "left";
            }  
            if(direction == "left")
                parent.left = successor.right;
            else if(direction == "right")
                parent.right = successor.right;
            root.val = successor.val;
        }
        
        return originalRoot;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
// Memory Usage: 39.2 MB, less than 96.55% of Java online submissions for Delete Node in a BST.