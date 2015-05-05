package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class HCl extends Particle{
    public static double pDecomp = .01;
    public HCl(double x, double y){
        super(x, y, 20, new Color(255, 150, 0), "HCl");
    }
//    public ArrayList<Particle> react(){
//        ArrayList<Particle> products = new ArrayList();
//        if (Math.random() > .996) {
//                products.add(new H(pos.x(), Math.max(pos.y() - 1*r, 0)));
//                products.add(new Cl(Math.max(pos.x() - 1 * r, 0), pos.y()));
//            }
//        return products;
//    }
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
            if (Math.random() < pDecomp) {
                products.add(new H(pos.x(), Math.max(pos.y() - 1*r, 0)));
                products.add(new Cl(Math.max(pos.x() - 1 * r, 0), pos.y()));
                destroyed.add(this);
                }
        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
    }
    
}
