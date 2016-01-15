/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Sina
 */
public class Graph {
    
    private final int nodeNumber;
    private final int edgeNumber;
    private final int [][]graph;
    private final boolean isDirected;

    private final String []labels;
    
    public Graph(Game game, boolean isDirected) {
        this.nodeNumber = game.getNumber();
        this.edgeNumber = this.nodeNumber;
        graph = new int[nodeNumber][nodeNumber];
        this.isDirected = isDirected;
        this.convertToGraph(game.getStart());
        labels = new String[nodeNumber];
    }
    
    public Graph(String fileName, boolean isDirected) throws FileNotFoundException {
        Scanner infile = new Scanner(new File(fileName));
        
        this.isDirected = isDirected;
        nodeNumber = infile.nextInt();
        graph = new int [nodeNumber][nodeNumber];
        edgeNumber = infile.nextInt();
        
        int i,j;
        for(i = 0; i < nodeNumber; i++)
            for(j = 0; j < nodeNumber; j++)
                graph[i][j] = 0;
        
        int head, tail, weight;
        for(i = 0; i < edgeNumber; i++) {
            head = infile.nextInt();
            tail = infile.nextInt();
            weight = infile.nextInt();
            graph[head][tail] = weight;
            if(!isDirected)
                graph[tail][head] = weight;
        }
        
        for(i = 0; i < nodeNumber; i++) {
            for(j = 0; j < nodeNumber; j++)
                System.out.print(graph[i][j] + " ");
            System.out.println("");
        }
        labels = new String[nodeNumber];    
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public int getGraph(int i, int j) {
        return graph[i][j];
    }

    public boolean isDirected() {
        return isDirected;
    }  
        
                 
    private void convertToGraph(State current) {

        int i;
        for(i = 0; i < current.getChildrenSize(); i++) {
            graph[current.getNumber()][current.getChild(i).getNumber()] = 1;
            convertToGraph(current.getChild(i));
        }
    }
}
