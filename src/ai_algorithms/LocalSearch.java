/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

/**
 *
 * @author Sina
 */
public class LocalSearch {
    
    private final int start;
    private final Graph graph;
    private final int nodeNumbers;
    
    private boolean [] mark;
    private int [] parent;
    private int [] heuristic;
    
    private int goalFunction(int x) {
        return x*x - 5 * x;
    }

    public LocalSearch(Graph graph, int start, int nodeNumbers) {
        this.start = start;
        this.graph = graph;
        this.nodeNumbers = nodeNumbers;
    }

    public int getStart() {
        return start;
    }

    public int getNodeNumbers() {
        return nodeNumbers;
    }
    
    
    
    
}
