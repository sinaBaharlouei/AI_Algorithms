/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

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
    
    private final boolean [] mark;
    private final int [] parent;
    private ArrayList<Integer> path;
    boolean isFind = false;
    
    private int maxDepth;
    
    public DFS(Graph graph, int start, int goal) {
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
    }
    
    
    public void RUN_DFS() {
        _RUN_DFS(start);
    }
    
    public void RUN_DFS_WITH_MAX_DEPTH(int maxDepth) {
          this.maxDepth = maxDepth;
          System.out.println("\nLimited depth:");
          _RUN_LIMITED_DEPTH_DFS(start, 0);
          System.out.println("");
    }
    
    public void RUN_ITERATIVE_DFS(int maximum) {
        
        for(int i = 1; i <= maximum; i++) {
            this.maxDepth = i;
            System.out.print("\nLevel [" + i + "]: ");
            _RUN_LIMITED_DEPTH_DFS(start, 0);
        }
        System.out.println("");
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
    
    private void _RUN_LIMITED_DEPTH_DFS(int a, int d) {
 
        if(isFind)
            return;
        
        if(this.isGoal(a)) {
            isFind = true;  
            path = new ArrayList<>();
            return;
        }
        
        if(d >= maxDepth)
            return;        
        int i;
        for(i = 0; i < nodeNumbers; i++) {
            if (graph.getGraph(a, i) > 0) {
                parent [i] = a;
                System.out.print(i + " ");
                _RUN_LIMITED_DEPTH_DFS(i, d+1);
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