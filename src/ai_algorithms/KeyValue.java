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
public class KeyValue  implements Comparable<KeyValue>{
    
    double key;
    double value;

    public KeyValue(double key, double value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(KeyValue o) {
        double des = this.value - o.value;
        if(des > 0) 
            return 1;
        else if(des < 0)
            return -1;
        return 0;
    }
    
    
}
