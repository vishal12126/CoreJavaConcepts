import java.util.Optional;

class Node {
    int data;
    Node left;
    Node right;
}

class BST {

    public Node createNewNode(int data) {
        Node a = new Node();
        a.data = data;
        a.left = null;
        a.right = null;

        return a;
    }

    public Node insert(Node node, int data) {
        if (node == null) {
            return createNewNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public static boolean flag = false;

    public void searchBT(Node node, int val) {

        if (node == null) {
            System.out.println("Tree is empty");
        } else {
            if (val == node.data) {
                flag = true;
                System.out.println("Element is present in the binary tree");
                return;
            } else {
                if (flag == false && node.left != null) {
                    searchBT(node.left, val);
                }

                if (flag == false && node.right != null) {
                    searchBT(node.right, val);
                }
            } //System.out.println("Element is not present in the binary tree");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        BST b = new BST();
        Node root = null;
        root = b.insert(root, 8);
        root = b.insert(root, 3);
        root = b.insert(root, 1);
        root = b.insert(root, 10);
        root = b.insert(root, 4);
        root = b.insert(root, 7);
        root = b.insert(root, 14);
        root = b.insert(root, 13);

        b.searchBT(root, 11);

    }
}


