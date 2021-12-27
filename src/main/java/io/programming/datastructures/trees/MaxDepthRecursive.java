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

    /**
     * Recursive search algorithm with linear time complexity O(h), where h is denoted as height of the binary tree
     * @param n node
     * @param key search key
     * @return search item @code{key}
     */
    private static Integer search(Node n, int key) {
        if (n == null || n.key == key) {
            return key;
        }
        if (key < n.key) {
            return search(n.left, key);
        } else {
            return search(n.right, key);
        }
    }

    public static void main(String[] args) {
        //              10
        //             /   \
        //            5     -
        //          /  \
        //         2    7
        BinaryTree binaryTree = new BinaryTree(
            new Node(10,
                new Node(5,
                    new Node(2, null, null),
                    new Node(7, null, null)),
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

        System.out.println("======================");
        System.out.println(search(binaryTree.root, 0));
        System.out.println(search(binaryTree.root, 7));
    }
}
