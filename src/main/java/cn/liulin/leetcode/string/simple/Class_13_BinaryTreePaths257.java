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
        List<String> list =  new ArrayList<>();
        String sb = "";
        binaryTreePaths2(sb, list, root);
        return list;
    }

    private void binaryTreePaths2(String sb, List<String> list, TreeNode root) {
        if (sb.isEmpty()) {
            sb += root.val;
        } else {
            sb += "->" + root.val;
        }
        // 输出条件，左右节点都为null
        if (root.left == null && root.right == null) {
            list.add(sb);
            return;
        }
        if (root.left != null) {
            binaryTreePaths2(sb, list, root.left);
        }
        if (root.right != null) {
            binaryTreePaths2(sb, list, root.right);
        }
    }

    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
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
