/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Sina
 */
public final class Genetic {
    
    private final int populationNumber;
    private final int childNumber;
    private final double min;
    private final double max;
    private final int iterationNumber;
    
    private final double deviate;
    
    private KeyValue firstPopulation[];
    private KeyValue selectedNumbers[];
    private KeyValue children[];
    
    public Genetic(int populationNumber, int childNumber, double min, double max, int iterationNumber, double deviate) {
        this.populationNumber = populationNumber;
        this.childNumber = childNumber;
        this.min = min;
        this.max = max;
        this.iterationNumber = iterationNumber;
        this.deviate = deviate;
        
        firstPopulation = new KeyValue[populationNumber];
        selectedNumbers = new KeyValue[childNumber];
        children = new KeyValue[childNumber];
        
        double incrementValue = (max - min) / populationNumber;
        
        int i;
        double key, value;
        for(i = 0; i < populationNumber; i++) {
            key = min + i * incrementValue;
            value = GoalFunc(key);
            firstPopulation[i] = new KeyValue(key, value);
        }
        
        Arrays.sort(firstPopulation);
        
        for(i = 0; i < childNumber; i++) {
            selectedNumbers[i] = firstPopulation[i];
        }
        
        for(i = 0; i < iterationNumber; i++) {
            run();
        }
        
        for(i = 0; i < childNumber; i++)
            System.out.println(selectedNumbers[i].key + " : " + selectedNumbers[i].value);
    }
    
    
    private double GoalFunc(double x) {
        return Math.abs(x * x - 5 * x);
    }
    
    public void run() {
        
        int i;
        double newKey, newValue;
        Random rand = new Random();
        double normalNoise;
        for( i = 0; i < childNumber; i++) {
            if(i != childNumber - 1) {
                newKey = (selectedNumbers[i].key + selectedNumbers[i+1].key) / 2;            
            } else {
                newKey = (selectedNumbers[i].key + selectedNumbers[0].key) / 2;
            }
                       
            // Mutation
            normalNoise = rand.nextGaussian() * deviate;
            newKey += normalNoise;
            
            newValue = GoalFunc(newKey);
            children[i] = new KeyValue(newKey, newValue);
        }

        //int mutationElement = rand.nextInt(childNumber);
        //double mutatedKey = selectedNumbers[mutationElement].key + normalNoise;
        //children[childNumber-1] = new KeyValue(mutatedKey, GoalFunc(mutatedKey));

        Arrays.sort(children);
        merge();
        
    }
    
    private void merge() {
        
        KeyValue result[] = new KeyValue[childNumber];
        int i, j = 0, k = 0;
        for(i = 0; i < childNumber; i++) {
            if(children[j].value < selectedNumbers[k].value) {
                result[i] = children[j];
                j++;
            } else {
                result[i] = selectedNumbers[k];
                k++;
            }
        }
        for(i = 0; i < childNumber; i++)
            selectedNumbers[i] = result[i];
    }
}