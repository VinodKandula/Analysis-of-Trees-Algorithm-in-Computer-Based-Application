package bfs_dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Graph {
    public Node rootNode;
    public ArrayList nodes =  new ArrayList();
    public int[][] AdjMatrix;
    int size;

    public void setrootNode(Node n){
        this.rootNode=n;
    }

    public Node getrootNode(){
        return this.rootNode;
    }

    public void addNodes(Node n){
        nodes.add(n);
    }
    public void connectedNodes(Node start,Node end){
        if (AdjMatrix==null){
           size = nodes.size();
           AdjMatrix =  new int[size][size];

        }

        int startIndex = nodes.indexOf(start);
        int endIndex = nodes.indexOf(end);
        AdjMatrix[startIndex][endIndex]=1;
        AdjMatrix[endIndex][startIndex]=1;
       }

       private Node getUnvisitedChildNode(Node node){

        int index = nodes.indexOf(node);
        int j=0;
        while (j<size){
            if (AdjMatrix[index][j]==1 && ((Node)nodes.get(j)).Visited==false){
                return (Node)nodes.get(j);
            } j++;
        }
          return null;

       }
       public void BFS(){
           Queue queue = new LinkedList();
           queue.add(this.rootNode);
           printNode(this.rootNode);
           rootNode.Visited=true;
           while (!queue.isEmpty()){
               Node n = (Node)queue.remove();
               Node child = null;
               while ((child=getUnvisitedChildNode(n))!=null){

                   child.Visited = true;
                   printNode(child);
                   queue.add(child);
               }
           }
           clearNodes();



     }
     public void DFS(){
        Stack stack = new Stack();
        stack.push(this.rootNode);
        rootNode.Visited=true;
        printNode(this.rootNode);

        while(!stack.isEmpty()){
          Node node = (Node)stack.peek();
          Node child=getUnvisitedChildNode(node);
          if (child != null){
              child.Visited=true;
              printNode(child);
              stack.push(child);

          }
          else{
              stack.pop();
          }


        }
        clearNodes();

     }


     private  void clearNodes(){
        int i=0;
        while (i<size){
           Node n = (Node)nodes.get(i);
           n.Visited = false;
           i++;

        }
     }
     private void printNode(Node n){
         System.out.println(n.label+ " ");
     }


}
