/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

/**
 *
 * @author David
 */

import java.util.*;
public class Reaction {
    String ra, rb;
    ArrayList<String> products = new ArrayList();
    double prob = 0;
    
    public Reaction(String a, String b, ArrayList<String> prods, double p){
        ra = a;
        rb = b;
        products = prods;
        prob = p;
    }
}
