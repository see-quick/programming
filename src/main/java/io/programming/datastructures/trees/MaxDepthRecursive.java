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

    /**
     * Recursive traverse algorithm with linear time complexity O(n).
     * @param node @code{node} from traverse the tree
     */
    private static void traversePreOrder(Node node) {
        if (node == null) return;

        System.out.println(node.key);
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    /**
     * Recursive traverse algorithm with linear time complexity O(n).
     * @param node @code{node} from traverse the tree
     */
    private static void traverseInOrder(Node node) {
        if (node == null) return;

        traversePreOrder(node.left);
        System.out.println(node.key);
        traversePreOrder(node.right);
    }

    /**
     * Recursive traverse algorithm with linear time complexity O(n).
     * @param node @code{node} from traverse the tree
     */
    private static void traversePostOrder(Node node) {
        if (node == null) return;

        traversePreOrder(node.left);
        traversePreOrder(node.right);
        System.out.println(node.key);
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

        System.out.println("Traverse Pre-order");
        System.out.println("======================");
        traversePreOrder(binaryTree.root);
        System.out.println("======================");
        System.out.println("Traverse In-order");
        traverseInOrder(binaryTree.root);
        System.out.println("======================");
        System.out.println("Traverse Post-order");
        traversePostOrder(binaryTree.root);
    }
}
