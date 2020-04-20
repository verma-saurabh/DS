package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
429. N-ary Tree Level Order Traversal

 */
public class LevelOrderTraversalOfNArrayTree {
    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> children = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                children.add(node.val);

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            ans.add(children);
        }


        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}