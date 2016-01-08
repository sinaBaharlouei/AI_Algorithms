/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.io.FileNotFoundException;

/**
 *
 * @author Sina
 */
public class AI_Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, Exception {
        // TODO code application logic here
        
        // Genetic Part
        //Genetic genetic = new Genetic(10, 5, -86, 120, 20, 0.2); // (Population Number, Child number, Min, Max, Iteration times, noise)
       /* 
        Graph graph = new Graph("graph1.txt", true);
       
        // DFS
        DFS dfs = new DFS(graph, 0, 3);
        dfs.RUN_DFS();
        dfs.printPath();
        
        System.out.println("----------------------------");
        // BFS
        BFS bfs = new BFS(graph, 0, 3);
        bfs.RUN_BFS();
        */
        // Best first search
        /*
        Graph graph2 = new Graph("graph2.txt", true);
        System.out.println("-------------------------\nBest First Saerch");
        InformedSearch informedSearch = new InformedSearch(graph2, 0, 4);
        informedSearch.readHeuristics("heuristic2.txt");
        informedSearch.RUN_ASTAR();
        */
        // A*
        Graph graph3 = new Graph("graph3.txt", true);
        System.out.println("\nA*");
        InformedSearch A_STAR = new InformedSearch(graph3, 0, 6);
        A_STAR.readHeuristics("heuristic3.txt");
        A_STAR.RUN_ASTAR(false); // A_STAR
        
        // Greedy
        System.out.println("\nGreedy:");
        InformedSearch greedy = new InformedSearch(graph3, 0, 6);
        greedy.readHeuristics("heuristic3.txt");
        greedy.RUN_ASTAR(true); // greedy
        
        
    }
}