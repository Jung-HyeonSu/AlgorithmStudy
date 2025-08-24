import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char left, right;
        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(root, new Node(left, right));
        }

        // 전위 순회
        preorder('A');
        System.out.println();
        // 중위 순회
        inorder('A');
        System.out.println();
        // 후위 순회
        postorder('A');
        System.out.println();
    }

    static void preorder(char root) {
        if (root == '.') return;
        System.out.print(root);                // Root
        preorder(tree.get(root).left);         // Left
        preorder(tree.get(root).right);        // Right
    }

    static void inorder(char root) {
        if (root == '.') return;
        inorder(tree.get(root).left);          // Left
        System.out.print(root);                // Root
        inorder(tree.get(root).right);         // Right
    }

    static void postorder(char root) {
        if (root == '.') return;
        postorder(tree.get(root).left);        // Left
        postorder(tree.get(root).right);       // Right
        System.out.print(root);                // Root
    }
}
