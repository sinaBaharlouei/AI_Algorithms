/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sina
 */
public class LocalSearch {
    
    private final int start;
    private final Graph graph;
    private final int nodeNumbers;
    private int visitedNodeNumbers;
    
    private Random random;
    
    private int bestState;
    private int currentState;
    
    private int [] values;
    private boolean [] marked;
    
    private int goalFunction(int x) {
        return x*x - 5 * x;
    }
    

    public LocalSearch(Graph graph, int start) {
        this.start = start;
        this.graph = graph;
        this.nodeNumbers = graph.getNodeNumber();
        this.visitedNodeNumbers = 0;
        this.bestState = start;
        currentState = start;
    
        values = new int[nodeNumbers];
        marked = new boolean[nodeNumbers];
        for(int i = 0; i < nodeNumbers; i++)
            marked[i] = false;
        
        random = new Random();
    }

    public void readValues(String fileName) throws FileNotFoundException {
    
        Scanner infile = new Scanner(new File(fileName));
        int nodeNum = infile.nextInt();
        for(int i  = 0; i < nodeNum; i++) {
            values[i] = infile.nextInt();
        }
        

    }
    
    public int getStart() {
        return start;
    }

    public int getNodeNumbers() {
        return nodeNumbers;
    }
    
    public int hillClimbing(int maximumNodes) {
        
        marked[start] = true;
        visitedNodeNumbers++;
        
        int index;
        while(visitedNodeNumbers < maximumNodes) {
            index = findBest(currentState);
            if(index < 0) {
                // random start
                currentState = random.nextInt(nodeNumbers);
            } else {
                currentState = index;
                bestState = values[currentState] < values[bestState] ? currentState : bestState;
            }
            
        }
        
        return bestState;
    }
    
    public void simulatedAnnealing(double p) {
        
    }
    
    private int findBest(int state) {
        
        int min = values[state];
        int index = -1;
        
        for(int i = 0; i < nodeNumbers; i++) {
            if(graph.getGraph(currentState, i) > 0) {
                if(!marked[i]) {
                    visitedNodeNumbers++;
                    marked[i] = true;
                }
                if(values[i] < min) {
                    min = values[i];
                    index = i;
                }
            }
        } 
        return index;
    }
}