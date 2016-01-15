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
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, Exception {
        // TODO code application logic here
        
        // Genetic Part
        //Genetic genetic = new Genetic(10, 5, -86, 120, 20, 0.2); // (Population Number, Child number, Min, Max, Iteration times, noise)
       
        Graph graph = new Graph("graph1.txt", true);
       
        // DFS
        //DFS dfs = new DFS(graph, 0, 3);
        //dfs.RUN_DFS(); // Normal DFS
        //dfs.RUN_DFS_WITH_MAX_DEPTH(3); // Max depth limited dfs
        //dfs.RUN_ITERATIVE_DFS(3);// Iterative DFS
        //dfs.printPath(); 
        
        ///* 
        System.out.println("----------------------------");
        // BFS
        BFS bfs = new BFS(graph, 0, 3);
        bfs.RUN_BFS();
        //*/
        // Best first search
        /*
        Graph graph2 = new Graph("graph2.txt", true);
        System.out.println("-------------------------\nBest First Saerch");
        InformedSearch informedSearch = new InformedSearch(graph2, 0, 4);
        informedSearch.readHeuristics("heuristic2.txt");
        informedSearch.RUN_ASTAR();
        */
        // A*
        /*
        Graph graph3 = new Graph("graph3.txt", true);
        System.out.println("\nA*");
        InformedSearch A_STAR = new InformedSearch(graph3, 0, 6);
        A_STAR.readHeuristics("heuristic3.txt");
        A_STAR.RUN_ASTAR(false); // A_STAR
        */
        // Greedy
        /*
        System.out.println("\nGreedy:");
        InformedSearch greedy = new InformedSearch(graph3, 0, 6);
        greedy.readHeuristics("heuristic3.txt");
        greedy.RUN_ASTAR(true); // greedy
        */
        // Hill climbing
        /*
        LocalSearch localSearch = new LocalSearch(graph3, 0);
        localSearch.readValues("values3.txt");
        int best = localSearch.hillClimbing(7);
        System.out.println("\nHill climbing: " + best);        
        */
        // Simulated annealing
//        Graph graph3 = new Graph("graph3.txt", false);
//        LocalSearch simulatedAnnealing = new LocalSearch(graph3, 0);
//        simulatedAnnealing.readValues("values3.txt");
//        simulatedAnnealing.simulatedAnnealing(100);
         
        
        // Game
        State start = new State("000000000", 0, null);
        Game game = new Game(start);
        //Graph graph5 = new Graph(game, true);
        System.out.println(start.getValue());
        start.getChild(2).getChild(2).getChild(2).getChild(2).print();
        System.out.println(start.getChild(2).getChild(2).getChild(2).getChild(2).getTurn());
    }
}