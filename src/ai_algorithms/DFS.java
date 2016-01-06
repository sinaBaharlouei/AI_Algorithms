/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Sina
 */
public class DFS {
 
    private final int start;
    private final int goal;
    Graph graph;
    private final int nodeNumbers;
    
    private boolean [] mark;
    private int [] parent;
    private ArrayList<Integer> path;
    boolean isFind = false;
    
    public DFS(int start, int goal, int nodeNumbers) throws FileNotFoundException {
        this.start = start;
        this.goal = goal;
        graph = new Graph("graph1.txt");
        this.nodeNumbers = nodeNumbers;
        
        parent = new int [nodeNumbers];
        mark = new boolean [nodeNumbers];
        
        for(int i = 0; i < nodeNumbers; i++) {
            parent [i] = 0;
            mark [i] = false;
        }
    }
    
    
    public void RUN_DFS() {
        _RUN_DFS(start);
    }
    
    private void _RUN_DFS(int a) {
 
        if(isFind)
            return;
        
        if(this.isGoal(a)) {
            isFind = true;  
            path = new ArrayList<>();
            return;
        }
            
        int i;
        for(i = 0; i < nodeNumbers; i++) {
            if (graph.getGraph(a, i) > 0 && mark[i] == false) {
                parent [i] = a;
                mark [i] = true;
                _RUN_DFS(i);
            }
        }
            
    }
    
    private boolean isGoal(int a) {
        return a == goal;
    }
    
    public void printPath() {
        
        if (!isFind) {
            System.out.println("There is no path to goal.");
        } else {
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