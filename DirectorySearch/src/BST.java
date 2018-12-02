import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {

    private Node root;

    public Node getRoot()
    {
        return root;
    }

    public void treeInsert(Node leaf)
    {
        Node successor = null;
        Node treeRoot = root;

        while (treeRoot != null) {
            successor = treeRoot;
            if (leaf.getData() < treeRoot.getData())
                treeRoot = treeRoot.getLeft();
            else treeRoot = treeRoot.getRight();
        }

        leaf.setParent(successor);

        if (successor == null)
            root = leaf;
        else if (leaf.getData() < successor.getData())
            successor.setLeft(leaf);
        else successor.setRight(leaf);
    }

    public void preOrder(Node root)
    {
        if (root != null) {
            System.out.print(root.getName() + "  ");

            if (root.getLeft() != null)
                preOrder(root.getLeft());

            if (root.getRight() != null)
                preOrder(root.getRight());
        }
    }

    public void inOrder(Node root)
    {
        if (root != null) {
            if (root.getLeft() != null)
                inOrder(root.getLeft());

            System.out.print(root.getName() + "  ");

            if (root.getRight() != null)
                inOrder(root.getRight());
        }
    }

    public void postOrder(Node root)
    {
        if (root != null) {
            if (root.getLeft() != null)
                postOrder(root.getLeft());


            if (root.getRight() != null)
                postOrder(root.getRight());

            System.out.print(root.getName() + "  ");
        }
    }

    private boolean checkVisit(Node node, LinkedList<Node> visitedList)
    {
        return visitedList.contains(node);
    }

    private void visit(Node node, LinkedList<Node> visitedList)
    {
        visitedList.add(node);
    }

    public void levelOrder(Node root, LinkedList<Node> visitedList)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.peek() != null) {
            Node node = queue.remove();
            if (!checkVisit(node, visitedList)) {
                System.out.print(node.getName() + "  ");
                visit(node, visitedList);
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
        }

    }

    public Node treeSearch(Node root, String name, long size)
    {
        if (root == null)
            return null;
        else if (root.getName().equals(name))
            return root;

        if (size < root.getData())
            return treeSearch(root.getLeft(), name, size);
        else return treeSearch(root.getRight(), name, size);
    }
}
