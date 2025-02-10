package cn.liulin.leetcode.string.simple;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * @author liulin
 * @date 2025-02-10 17:54:00
 */
public class Class_13_BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        String sb = String.valueOf(root.val);
        List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(sb);
            return result;
        }
        if (root.left != null) {
            binaryTreePaths(sb, result, root.left);
        }
        if (root.right != null) {
            binaryTreePaths(sb, result, root.right);
        }
        return result;
    }

    private void binaryTreePaths(String sb, List<String> result, TreeNode left) {
        sb += "->" + left.val;
        if (left.left == null && left.right == null) {
            result.add(sb);
            return;
        }
        if (left.left != null) {
            binaryTreePaths(sb, result, left.left);
        }
        if (left.right != null) {
            binaryTreePaths(sb, result, left.right);
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        StringBuilder sb = new StringBuilder(root.val);
        List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return result;
        }
        if (root.left != null) {
            binaryTreePaths2(sb, result, root.left);
        }
        if (root.right != null) {
            binaryTreePaths2(sb, result, root.right);
        }
        return result;
    }

    private void binaryTreePaths2(StringBuilder sb, List<String> result, TreeNode left) {
        sb.append("->").append(left.val);
        if (left.left == null && left.right == null) {
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (left.left != null) {
            binaryTreePaths2(sb, result, left.left);
        }
        if (left.right != null) {
            binaryTreePaths2(sb, result, left.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
