import java.util.LinkedList;
import java.util.Queue;

/**
 * In this class, coding to add, delete and search in BinarySearch Tree
 * using recursive approach.
 */

public class BinarySearchTreeRec {

  private Node root;

  private Node addRecursive(Node current, int value) {
    if (current == null) {
      return new Node(value);
    }
    if (value < current.data) {
      current.left = addRecursive(current.left, value);
    } else if (value > current.data) {
      current.right = addRecursive(current.right, value);
    } else {
      return current;
    }
    return current;
  }

  public void add(int value) {
    root = addRecursive(root, value);
  }

  private boolean containsNodeRecursive(Node current, int value) {
    if (current == null) {
      return false;
    }
    if (current.data == value) {
      return true;
    }
    return current.data < value ? containsNodeRecursive(current.right, value)
        : containsNodeRecursive(current.left, value);
  }

  public boolean contains(int value) {
    return containsNodeRecursive(root, value);
  }

  private Node deleteRecurive(Node current, int value) {
    if (current == null) {
      return null;
    }
    if (value < current.data) {
      current.left = deleteRecurive(current.left, value);
    } else if (value > current.data) {
      current.right = deleteRecurive(current.right, value);
    }
    //Value matches the current.value
    else {
      if (current.left == null && current.right == null) {
        return null;
      }
      //Node with 0 or 1 child
      if (current.left == null) {
        return current.right;
      }
      if (current.right == null) {
        return current.left;
      }
      //Node with 2 children
      //Replace value with minimum value on the right subtree.
      current.data = minValue(current.right);

      //Delete the minimum value node on the right subtree
      current.right = deleteRecurive(current.right, current.data);
    }
    return current;

  }

  private int minValue(Node root) {
    int minV = root.data;
    while (root.left != null) {
      minV = root.left.data;
      root = root.left;
    }
    return minV;
  }

  //Level order traversal
  public void traverseLevelOrder() {
    breadthSearch(root);
  }

  private void breadthSearch(Node root) {
    if (root == null) {
      return;
    }
    Queue<Node> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    while (!nodeQueue.isEmpty()) {
      Node temp = nodeQueue.remove();
      System.out.print(temp.data+" ");
      if (temp.left != null) {
        nodeQueue.add(temp.left);
      }
      if (temp.right != null) {
        nodeQueue.add(temp.right);
      }
    }
  }

  //Breadth search traversal
  //Inorder
  public void inorder()  {
    inOrderRec(root);
  }

  // A utility function to do inorder traversal of BST
  public static void inOrderRec(Node root) {
    if (root == null) {
      return;
    }
      inOrderRec(root.left);
      System.out.print(root.data+" ");
      inOrderRec(root.right);

  }

  //Preorder
  public void preOrder()  {
    preOrderRec(root);
  }

  // A utility function to do preorder traversal of BST
  public static void preOrderRec(Node root) {
    if (root != null) {
      System.out.print(root.data+" ");
      preOrderRec(root.left);
      preOrderRec(root.right);
    }
  }

  //Postorder
  public void postOrder()  {
    postOrderRec(root);
  }

  // A utility function to do preorder traversal of BST
  public static void postOrderRec(Node root) {
    if (root == null) {
      return;
    }
      postOrderRec(root.left);
      postOrderRec(root.right);
      System.out.print(root.data+" ");

  }

  // Getting size of the binary tree
  public static int getSize(Node root) {
    if (root == null) {
      return 0;
    }
    else {
      return getSize(root.getLeft()) + getSize(root.getRight()) + 1;
    }
  }


  public static void main(String[] args) {
    BinarySearchTreeRec tree = new BinarySearchTreeRec();
    tree.add(50);
    tree.add(30);
    tree.add(20);
    tree.add(40);
    tree.add(70);
    tree.add(60);
    tree.add(80);
    System.out.println("Inorder: ");
    tree.inorder();

  }
}
