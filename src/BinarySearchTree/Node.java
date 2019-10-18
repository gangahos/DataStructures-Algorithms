public class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public int getData() {
    return data;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setData(int data) {
    this.data = data;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
