package assignment1;

public class Program2 {
}
class Binary_search_tree {
    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    Node root;

    Binary_search_tree(){
        root = null;
    }
    void deleteKey(int key) {
        root = delete_Recursive(root, key);
    }

    Node delete_Recursive(Node root, int key)  {
        if (root == null)  return root;

        if (key < root.key)
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);
        else  {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root)  {
        int minval = root.key;
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }
    Node insert_Recursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);
        return root;
    }

    void inorder() {
        inorder_Recursive(root);
    }

    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }

    boolean search(int key)  {
        root = search_Recursive(root, key);
        if (root!= null)
            return true;
        else
            return false;
    }

    Node search_Recursive(Node root, int key)  {
        if (root==null || root.key==key)
            return root;
        if (root.key > key)
            return search_Recursive(root.left, key);

        return search_Recursive(root.right, key);
    }
}
class Main{
    public static void main(String[] args)  {
        //create a BST object
        Binary_search_tree bst = new Binary_search_tree();
        bst.insert(10);
        bst.insert(12);
        bst.insert(14);
        bst.insert(13);
        bst.insert(11);
        bst.insert(50);

        System.out.println("The BST Created ");
        bst.inorder();

        System.out.println("\nThe BST after Deleting 12:");
        bst.deleteKey(12);
        bst.inorder();

        System.out.println("\nThe BST after Deleting 90:");
        bst.deleteKey(13);
        bst.inorder();


        System.out.println("\nThe BST after Deleting 45 :");
        bst.deleteKey(14);
        bst.inorder();

        boolean ret_val = bst.search (50);
        System.out.println("\nKey 50 found in BST:" + ret_val );
        ret_val = bst.search (12);
        System.out.println("\nKey 12 found in BST:" + ret_val );
    }
}
