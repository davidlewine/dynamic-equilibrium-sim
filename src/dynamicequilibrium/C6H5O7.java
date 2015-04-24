package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class C6H5O7 extends Particle{
    
    public C6H5O7(double x, double y){
        super(x, y, 20, new Color(100, 0, 100), "C6H5O7");
    }
    
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
        
        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
        
    }
    
}
