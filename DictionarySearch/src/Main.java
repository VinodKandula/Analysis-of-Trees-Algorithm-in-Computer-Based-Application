import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        File file = new File("E:\\Thesis\\DictionarySearch-master\\src\\WordList.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BTree bTree = new BTree(2);
        bTree.bTreeCreate();
        while (scanner != null && scanner.hasNext())
            bTree.bTreeInsert(scanner.next());

        LinkedList<Node> visitedList = new LinkedList<>();
        bTree.levelOrder(bTree.getRoot(), visitedList);

        String search = "use";
        System.out.println("\nSearch: " + search);
        System.out.println(bTree.bTreeSearch(bTree.getRoot(), search) ? "Yes" : "No");

    }
}
