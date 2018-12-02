package bst;
import java.util.LinkedList;
import java.util.Queue;

public class BST_Construction {
    Node root;
    public void addNode(int key,String name){
        Node newNode = new Node(key,name);
        if (root == null){
            root = newNode;

        }
        else {
            Node focusNode = root;
            Node parent;
            while (true){

                parent = focusNode;
                if (key<focusNode.key){
                    focusNode = focusNode.leftChild;
                    if (focusNode==null){

                        parent.leftChild = newNode;
                        return;
                    }

                }
                else {

                    focusNode = focusNode.rightChild;
                    if (focusNode==null){
                        parent.rightChild = newNode;
                        return;
                    }

                }
            }
        }


    }

    public void inOrderTraverseTree(Node focusNode){
        if (focusNode!=null){
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }
    public void preOrderTraverseTree(Node focusNode){
        if (focusNode!=null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void postOrderTraverseTree(Node focusNode){
        if (focusNode!=null){
            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    public void levelOrdertraverseTree(Node focusNode) {

        if (focusNode == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(focusNode);

        while(!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.println(tempNode);

            if(tempNode.leftChild != null) {
                queue.add(tempNode.leftChild);
            }

            if(tempNode.rightChild != null) {
                queue.add(tempNode.rightChild);
            }
        }

    }


    public Node searchNodes(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;

            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;

        }
        return focusNode;

    }
    public static void main(String[] args){

        long StartTime = System.currentTimeMillis();
        BST_Construction bst_construction = new BST_Construction();
        System.out.println("This is Inorder Traversal(Left,Root,Right): ");
        bst_construction.addNode(50,"nishat");
        bst_construction.addNode(25,"medel");
        bst_construction.addNode(15,"abhi");
        bst_construction.addNode(30,"alamin");
        bst_construction.addNode(75,"tareq");
        bst_construction.addNode(85,"sohan");
        bst_construction.addNode(5,"arman");
        bst_construction.addNode(2,"sohel");
        bst_construction.addNode(16,"tuhin");
        bst_construction.addNode(32,"runa");
        bst_construction.addNode(47,"monika");
        bst_construction.addNode(71,"udoy");
        //bst_construction.postOrderTraverseTree(bst_construction.root);

        //bst_construction.preOrderTraverseTree(bst_construction.root);
         bst_construction.inOrderTraverseTree(bst_construction.root);
         long EndTime = System.currentTimeMillis();
         long TotalTime = StartTime - EndTime;

        System.out.println("Elapsed time in milliseconds: "+TotalTime);
//        System.out.println("This is preOrder Traversal(Root,Left,Right): ");
//        bst_construction.preOrderTraverseTree(bst_construction.root);
//        System.out.println("This is postOrder Traversal(Left,Right,Root): ");
//        bst_construction.postOrderTraverseTree(bst_construction.root);
//        System.out.println("searching :- ");
//        System.out.println(bst_construction.searchNodes(75));



    }
}
