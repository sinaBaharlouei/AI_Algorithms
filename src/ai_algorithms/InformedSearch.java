/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import sun.misc.Queue;

/**
 *
 * @author Sina
 */
public class InformedSearch {

    private final int start;
    private final int goal;
    Graph graph;
    private final int nodeNumbers;
    
    private boolean [] mark;
    private int [] parent;
    private int [] heuristic;
    
    private ArrayList<Integer> path;
    boolean isFind = false;
    
    private ArrayList<Integer> openList;
    private ArrayList<Integer> openListWeight;
    private ArrayList<Integer> closeList;
    
    
    public InformedSearch(Graph graph, int start, int goal) {
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
         openList = new ArrayList<>();
         openListWeight = new ArrayList<>();
         closeList = new ArrayList<>();
    }
    
    public void readHeuristics(String fileName) throws FileNotFoundException, Exception {
    
        heuristic = new int[nodeNumbers];
        Scanner infile = new Scanner(new File(fileName));
        
        int nodeNumber = infile.nextInt();
        if( nodeNumber != nodeNumbers)
            throw  new Exception("Unmatched node numbers.");
        
        int i,value;
        for(i = 0; i < nodeNumber; i++) {
            value = infile.nextInt();
            heuristic[i] = value;
            //System.out.println(heuristic[i]);
        }        
    }
    
    
    public void RUN_UCS() {
    
        openList.add(start);
        openListWeight.add(0);
        
        int current_index, current, weight, current_weight;
        

        while( !openList.isEmpty()) {
           
            current_index = this.getBest();
            
            weight = openListWeight.get(current_index);
            current = openList.get(current_index);
            
            openList.remove(current_index);
            openListWeight.remove(current_index);
       
            mark[current] = true;
            if(isGoal(current)) {
                isFind = true;
                break;
            }
            closeList.add(current);
            
            for(int i = 0; i < nodeNumbers; i++) {
                current_weight = graph.getGraph(current, i);
                if(current_weight > 0 && !inCloseList(i)) {
                    openList.add(i);
                    openListWeight.add(current_weight + weight);                        
                    parent[i] = current;
                }
            }
        }
        printPath();

    }

    public void RUN_ASTAR() {
        
        openList.add(start);
        openListWeight.add(0 + heuristic[0]);
        
        int current_index, current, weight, current_weight;
        

        while( !openList.isEmpty()) {
           
            current_index = this.getBest();
            
            weight = openListWeight.get(current_index);
            current = openList.get(current_index);
            
            openList.remove(current_index);
            openListWeight.remove(current_index);
       
            mark[current] = true;
            if(isGoal(current)) {
                isFind = true;
                break;
            }
            closeList.add(current);
            
            for(int i = 0; i < nodeNumbers; i++) {
                current_weight = graph.getGraph(current, i);
                if(current_weight > 0 && !inCloseList(i)) {
                    openList.add(i);
                    openListWeight.add(current_weight + heuristic[i]);                        
                    parent[i] = current;
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
    
    private int getBest() {
        
        int i, j;
        int min = openListWeight.get(0);
        j = 0;
        for(i = 1; i < openList.size(); i++) {
            if(openListWeight.get(i) < min) {
                j = i;
                min = openListWeight.get(i); 
            }
        }
        return j;
    }
    
    
    private boolean inCloseList(int index) {
        
        for (Integer closeList1 : closeList) {
            if (closeList1 == index) {
                return true;
            }
        }
        return false;
    }
}
