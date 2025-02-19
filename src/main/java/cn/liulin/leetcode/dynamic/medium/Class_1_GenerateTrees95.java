package cn.liulin.leetcode.dynamic.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author liulin
 * @date 2025-02-19 11:34:00
 */
public class Class_1_GenerateTrees95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allNode = new ArrayList<>();
        if (start > end) {
            allNode.add(null);
            return allNode;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTreeNodeList = generateTrees(start, i - 1);
            List<TreeNode> rightTreeNodeList = generateTrees(i + 1, end);
            for (TreeNode leftNode : leftTreeNodeList) {
                for (TreeNode rightNode : rightTreeNodeList) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    allNode.add(treeNode);
                }
            }

        }
        return allNode;
    }

    public static void main(String[] args) {
        new Class_1_GenerateTrees95().generateTrees(3);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
