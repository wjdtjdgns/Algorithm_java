import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node root = new Node("A", null, null);

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            makeTree(root, temp[0], temp[1], temp[2]);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public static class Node {
        String cur;
        Node left;
        Node right;

        public Node(String cur, Node left, Node right) {
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
    }

    public static void makeTree(Node root, String cur, String left, String right) {
        if (root.cur.equals(cur)) {
            if (left.equals(".")) {
                root.left = null;
            } else {
                root.left = new Node(left, null, null);
            }
            if (right.equals(".")) {
                root.right = null;
            } else {
                root.right = new Node(right, null, null);
            }
        } else {
            if (root.left != null) makeTree(root.left, cur, left, right);
            if (root.right != null) makeTree(root.right, cur, left, right);
        }
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.cur);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.cur);
        inOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.cur);
    }
}
