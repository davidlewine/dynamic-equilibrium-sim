package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class NaHCO3 extends Particle{
    public static double pNaHCO3 = .01;
    public NaHCO3(double x, double y){
        super(x, y, 20, new Color(0, 0, 200), "NaHCO3");
    }
    
//    public ArrayList<Particle> react(){
//        ArrayList<Particle> products = new ArrayList();
//        if (Math.random() > .996) {
//                products.add(new Na(pos.x(), Math.max(pos.y() - 1*r, 0)));
//                products.add(new HCO3(Math.max(pos.x() - 1 * r, 0), pos.y()));
//                //System.out.println("p: " + pos + " na:" + newNa.pos + " HCO3: " + newHCO3.pos);
//            }
//        return products;
//    }
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
        if(p.formula.equals("BackgroundH2O")){
            if (Math.random() < pNaHCO3) {
                products.add(new Na(pos.x(),pos.y()));
                products.add(new HCO3(pos.x(), pos.y()));
                destroyed.add(this);
                }
        }
        
        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
    }
    
}
