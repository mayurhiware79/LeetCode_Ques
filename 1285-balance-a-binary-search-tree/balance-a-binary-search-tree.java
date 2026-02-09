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

    List<Integer> inorderList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        //inorder traversal
        inorder(root);

        // creating balanced BST from sorted list
        return buildBST(0, inorderList.size()-1);
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }

    private TreeNode buildBST(int left, int right){
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        //creating binary search tree with root = mid ele of list
        TreeNode root = new TreeNode(inorderList.get(mid));

        root.left = buildBST(left, mid-1);
        root.right = buildBST(mid+1, right);

        return root;
    }
}