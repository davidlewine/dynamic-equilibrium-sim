package dynamicequilibrium;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class C6H6O7 extends Particle{
    public static double pC6H6O7 = .002;
    public C6H6O7(double x, double y){
        super(x, y, 20, new Color(200, 0, 200), "C6H6O7");
    }
//    @Override
//    public void display(Graphics g){
//        //System.out.println(charge);
//        c = new Color(150, 0,  150);
//        g.setColor(c);
//        g.fillOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
//    }
    
    public Hashtable<String, ArrayList<Particle>> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);
        if(p.formula.equals("BackgroundH2O")){
            if (Math.random() < pC6H6O7) {
                products.add(new H(pos.x(), pos.y()));
                products.add(new C6H5O7(pos.x() ,pos.y()));
                destroyed.add(this);
            }
        }
        
        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
    }
    
}