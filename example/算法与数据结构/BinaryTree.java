package com.github.hcsp.algorithm;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        System.out.println(bfs(node1));
        System.out.println(dfs2(node1));
    }


    // 请实现二叉树的广度优先遍历（层次遍历）
    public static List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        List<Integer> result = new ArrayList<>();
        while (!treeNodeQueue.isEmpty()) {
            TreeNode node = treeNodeQueue.poll();
            result.add(node.value);

            if (node.left != null) {
                treeNodeQueue.add(node.left);
            }
            if (node.right != null) {
                treeNodeQueue.offer(node.right);
            }
        }
        return result;
    }

    // 请实现二叉树的深度优先遍历（前序，递归实现）
    public static List<Integer> dfs(TreeNode root) {
        // 根 --> 左 --> 右
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.value);
            result.addAll(dfs(root.left));
            result.addAll(dfs(root.right));
        }
        return result;
    }

    // 请实现二叉树的深度优先遍历（前序，Stack 实现）
    public static List<Integer> dfs2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode pollNode = stack.pop();
            result.add(pollNode.value);
            if (pollNode.right != null) {
                stack.push(pollNode.right);
            }
            if (pollNode.left != null) {
                stack.push(pollNode.left);
            }
        }

        return result;
    }


    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
