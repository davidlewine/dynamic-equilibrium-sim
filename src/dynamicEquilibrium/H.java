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
import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
public class H extends Particle{
    
    public static double pHandCl = .001;
    public static double pHandC6HxO7 = .01;
    public static double pHandHCO3 = .01;
   
    
    
    public H(double x, double y){
        super(x, y, 10, new Color(255, 0, 0), "H");

    }
    
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
        if(p.formula.equals("Cl")){
            if (Math.random() < pHandCl) {
                    products.add(new HCl(pos.x(), pos.y()));
                    destroyed.add(this);
                    destroyed.add(p);
                }
        }
        if(p.formula.equals("HCO3")){
            if (Math.random() < pHandHCO3) {
                    products.add(new H2O(pos.x(), pos.y()));
                    products .add(new CO2(pos.x(), pos.y()));
                    destroyed.add(this);
                    destroyed.add(p);
                }
        }
        if(p.formula.equals("C6H7O7")){
            if (Math.random() < pHandC6HxO7) {
                    products.add(new C6H8O7(pos.x(), pos.y()));
                    destroyed.add(this);
                    destroyed.add(p);
                }
        }
        if(p.formula.equals("C6H6O7")){
            if (Math.random() < pHandC6HxO7) {
                    products.add(new C6H7O7(pos.x(), pos.y()));
                    destroyed.add(this);
                    destroyed.add(p);
                }
        }
        if(p.formula.equals("C6H5O7")){
            if (Math.random() < pHandC6HxO7) {
                    products.add(new C6H6O7(pos.x(), pos.y()));
                    destroyed.add(this);
                    destroyed.add(p);
                }
        }

        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
   

    }
    
}
