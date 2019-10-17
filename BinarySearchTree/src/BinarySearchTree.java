import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

  public static Node insertIterative(Node root, int key) {
    //current Node
    Node curr = root;
    Node parent = null;

    Node newNode = new Node(key);

    if (root == null) {
      root = newNode;
      return root;
    }

    while (curr != null) {
      parent = curr;

      if (key < curr.data) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }

    if (key < parent.data) {
      parent.left = newNode;

    } else {
      parent.right = newNode;
    }

    return root;

  }

  public static boolean iterativeSearch(Node root, int key) {
    while (root != null) {
      if (key > root.data) {
        root = root.getRight();
      } else if (key < root.data) {
        root = root.getLeft();
      } else {
        return true;
      }
    }
    return false;
  }

  public static void inOrderRec(Node root) {
    if (root == null) {
      return;
    }
    inOrderRec(root.left);
    System.out.print(root.data+" ");
    inOrderRec(root.right);

  }

  /*
  Iterative traversal of BinarySearch Tree.
   */
  public static void dfsStack(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> s1 = new Stack<>();
    Node curr = root;
    s1.add(curr);
    while (!s1.isEmpty()) {
      Node temp = s1.pop();
      if (temp.right != null) {
        s1.add(temp.right);
      }
      if (temp.left != null) {
        s1.add(temp.left);
      }
      System.out.println(temp.data);

    }

  }

  public static void inOrder (Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> s1 = new Stack<>();
    Node curr = root;
    while (curr != null || s1.size() > 0) {
      while (curr != null) {
        s1.push(curr);
        curr = curr.left;
      }
      curr = s1.pop();
      System.out.println(curr.data);
      curr = curr.right;
    }
  }

  public static int getLeafCount(Node node) {
    if (node == null) {
      return 0;
    }
    int count = 0;
    //Do level order traversal
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      // Get the parent out, add the left and right node to queue
      Node temp = queue.peek();
      queue.poll();
      if (temp.getLeft() != null) {
        queue.add(temp.getLeft());
      }
      if (temp.getRight() != null) {
        queue.add(temp.getRight());
      }
      if (temp.getLeft() == null && temp.getRight() == null) {
        count++;
      }
    }
    return count;
  }

  /*
  Given a complete binary tree, count the number of nodes.
   */
  public static int getNodeCount(Node node) {
    if (node == null) {
      return 0;
    }
    int count = 0;
    //Do level order traversal
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      // Get the parent out, add the left and right node to queue
      Node temp = queue.peek();
      queue.poll();
      count++;
      if (temp.getLeft() != null) {
        queue.add(temp.getLeft());
      }
      if (temp.getRight() != null) {
        queue.add(temp.getRight());
      }
    }
    return count;
  }



  public static void main(String[] args) {
    Node root = null;
    root = insertIterative(root,50);
    insertIterative(root,30);
    insertIterative(root,20);
    insertIterative(root,40);
    insertIterative(root,70);
    insertIterative(root,60);
    insertIterative(root,80);
    if (iterativeSearch(root,50)) {
      System.out.println("Key found");
    }
    inOrder(root);
    System.out.println(getLeafCount(root));
    System.out.println(getNodeCount(root));

  }

}
