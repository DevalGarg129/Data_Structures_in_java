package BinaryTree;
import java.util.*;
public class BinaryTreeCamera {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(Scanner scn){
        int val = scn.nextInt();
        if(val == -1){
            return null;
        }

        TreeNode root = new TreeNode(val);
        root.left = buildTree(scn);
        root.right = buildTree(scn);
        return root;
    }

    static class Solution{
        int camera = 0;

        public int dfs(TreeNode root){
            if(root == null){
                return 1;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);

            if(left == 0 || right == 0){
                camera++;
                return 1;
            }

            if(left == 1 || right == 1){
                return 2;
            }
            return 0;
        }

        public int minCameraCover(TreeNode root){
            if(dfs(root) == 0){
                camera++;
            }
            return camera;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        TreeNode root = buildTree(scn);
        Solution sol = new Solution();
        int answer = sol.minCameraCover(root);
        System.out.println(answer);
        scn.close();
    }
}
