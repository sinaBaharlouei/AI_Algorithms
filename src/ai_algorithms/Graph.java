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
    
    private int nodeNumber;
    private int edgeNumber;
    private int [][]graph;

    public Graph(String fileName) throws FileNotFoundException {
        Scanner infile = new Scanner(new File("graph1.txt"));
        
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
        }
        
        
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public int getGraph(int i, int j) {
        return graph[i][j];
    }
    
        
    
}
