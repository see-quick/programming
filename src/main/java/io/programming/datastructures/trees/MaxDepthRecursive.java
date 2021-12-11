package io.programming.datastructures.trees;

public class MaxDepthRecursive {

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    static class BinaryTree {
        Node root;

        public BinaryTree(Node root) {
            this.root = root;
        }
    }

    static int maxDepth = 1;

    /**
     * Top-down approach using additional @code{depth} variable
     *
     * @param root binary tree node
     * @param depth depth tree
     */
    private static void maxDepth(Node root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }

        maxDepth(root.left, maxDepth + 1);
        maxDepth(root.right, maxDepth + 1);
    }

    /**
     * Bottom-up approach without additional parameter space-complexity but using auxiliary variables @code{left_depth} and @code{right_depth}.
     *
     * @param root binary tree node
     */
    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(
            new Node(0,
                new Node(1,
                    new Node(2, null, null),
                    new Node(3, null, null)),
                null));

        // top-down approach
        maxDepth(binaryTree.root, maxDepth);
        // bottom-up approach
        System.out.println(maxDepth(binaryTree.root));

        System.out.println(maxDepth);
    }
}
