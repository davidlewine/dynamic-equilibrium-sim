package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class Na extends Particle{
    public static double pNaandHCO3 = .001;
    public Na(double x, double y){
        super(x, y, 20, new Color(200, 200, 0), "Na");
    }
    
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
        if(p.formula.equals("HCO3")){
            if (Math.random() < pNaandHCO3) {
                products.add(new NaHCO3(pos.x(), pos.y()));
                destroyed.add(this);
                destroyed.add(p);
            }
        }
        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
    }
    
}
