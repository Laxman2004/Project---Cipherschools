class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Search for a key
    boolean search(int key) {
        return searchRec(root, key) != null;
    }

    Node searchRec(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    // Delete a key
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }


    // InOrder Traversal
    void inOrder() {
        inOrderRec(root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // PreOrder Traversal
    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // PostOrder Traversal
    void postOrder() {
        postOrderRec(root);
    }

    void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Driver code
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("InOrder traversal:");
        bst.inOrder();

        System.out.println("\n\nPreOrder traversal:");
        bst.preOrder();

        System.out.println("\n\nPostOrder traversal:");
        bst.postOrder();

        System.out.println("\n\nSearch for 40: " + bst.search(40));
        System.out.println("Search for 100: " + bst.search(100));

        bst.delete(20);
        System.out.println("\nInOrder traversal after deleting 20:");
        bst.inOrder();

        bst.delete(30);
        System.out.println("\nInOrder traversal after deleting 30:");
        bst.inOrder();

        bst.delete(50);
        System.out.println("\nInOrder traversal after deleting 50:");
        bst.inOrder();
    }
}




