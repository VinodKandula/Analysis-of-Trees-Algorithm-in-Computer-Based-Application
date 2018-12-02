package bfs_dfs;

public class Main {

    public static void main(String[] args){

        long StartTime = System.currentTimeMillis();

        Node nA = new Node('A');
        Node nB = new Node('B');
        Node nC = new Node('C');
        Node nD = new Node('D');
        Node nE = new Node('E');
        Node nF = new Node('F');

        Graph graph = new Graph();
        graph.addNodes(nA);
        graph.addNodes(nB);
        graph.addNodes(nC);
        graph.addNodes(nD);
        graph.addNodes(nE);
        graph.addNodes(nF);

        graph.setrootNode(nA);
        graph.connectedNodes(nA,nB);

        graph.connectedNodes(nA,nC);
        graph.connectedNodes(nB,nE);
        graph.connectedNodes(nC,nD);
        graph.connectedNodes(nC,nE);

//        System.out.println("this is for BFS");
//        graph.BFS();
        System.out.println("this is for DFS");
        graph.DFS();

        long EndTime = System.currentTimeMillis();
        long TotalTime = StartTime - EndTime;
        System.out.println("Elapsed time in milliseconds: "+TotalTime);
//        System.out.println("this is for DFS");
//        graph.DFS();


    }

}

