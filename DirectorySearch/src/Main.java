import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\ProgramData");
        Directory directory = new Directory(file);
        BST bst = new BST();
        for (FileDescription fileDescription : directory.getFileDescriptionList()) {
            Node leaf = new Node();
            leaf.setName(fileDescription.getFileName());
            leaf.setData(fileDescription.getFileSize());
            bst.treeInsert(leaf);
        }

        System.out.println("Pre Order Traversal:");
        bst.preOrder(bst.getRoot());
        System.out.println();
        System.out.println("\nIn Order Traversal:");
        bst.inOrder(bst.getRoot());
        System.out.println();
        System.out.println("\nPost Order Traversal:");
        bst.postOrder(bst.getRoot());
        System.out.println();
        System.out.println("\nLevel Order Traversal:");
        LinkedList<Node> visitedList = new LinkedList<>();
        bst.levelOrder(bst.getRoot(), visitedList);

        boolean proceed = true;
        Scanner scanner = new Scanner(System.in);
        while (proceed) {
            System.out.println("\n\nEnter folder/file name: ( enter 'q' to exit )");
            String searchName = scanner.nextLine();
            if (searchName.equals("q"))
                proceed = false;
            else {
                long searchFileSize = 0;
                for (FileDescription fileDescription : directory.getFileDescriptionList()) {
                    if (searchName.equals(fileDescription.getFileName()))
                        searchFileSize = fileDescription.getFileSize();
                }

                Node node = bst.treeSearch(bst.getRoot(), searchName, searchFileSize);
                if (node != null) {
                    Stack<Node> stack = new Stack<>();
                    while (node != null) {
                        stack.push(node);
                        node = node.getParent();
                    }
                    while (!stack.empty()) {
                        node = stack.pop();
                        System.out.print(node.getName());
                        if (!stack.empty())
                            System.out.print(" -> ");
                    }
                    System.out.println();
                } else System.out.println("Not Found");
            }
        }
    }
}
