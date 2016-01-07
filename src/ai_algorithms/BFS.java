/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import sun.misc.Queue;

/**
 *
 * @author Sina
 */
public class BFS {
 
    private final int start;
    private final int goal;
    Graph graph;
    private final int nodeNumbers;
    
    private boolean [] mark;
    private int [] parent;
    private ArrayList<Integer> path;
    boolean isFind = false;
    
    private Queue Q;
    
    public BFS(Graph graph, int start, int goal) {
        this.start = start;
        this.goal = goal;
        this.graph = graph;
        this.nodeNumbers = graph.getNodeNumber();
        
        parent = new int [nodeNumbers];
        mark = new boolean [nodeNumbers];
        
        for(int i = 0; i < nodeNumbers; i++) {
            parent [i] = -1;
            mark [i] = false;
        }
        Q = new Queue();
        
    }
    
    
    public void RUN_BFS() throws InterruptedException {
    
        Q.enqueue(start);
    
        int current;
        

        while( !Q.isEmpty() && !isFind) {
            current = (int) Q.dequeue();
            
            for(int i = 0; i < nodeNumbers; i++) {
                if(isFind)
                    break;
                if(graph.getGraph(current, i) > 0 && !mark[i]) {
                    parent[i] = current;
                    mark[i] = true;
                    if(isGoal(i)) {
                       isFind = true;
                       break;
                    }
                    Q.enqueue(i);
                } 
            }
        }
        printPath();

    }
    
    private boolean isGoal(int a) {
        return a == goal;
    }
    
    public void printPath() {
        
        if (!isFind) {
            System.out.println("There is no path to goal.");
        } else {
            path = new ArrayList<>();
            int current = goal;
            while( current != start) {
                path.add(current);
                current = parent[current];
            }
            path.add(current);
            
            System.out.println("Path to goal:");
            for(int i = path.size() - 1; i >= 0; i--) 
                System.out.println(path.get(i));
        }
    }   
}