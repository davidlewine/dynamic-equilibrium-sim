package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Na extends Particle{
    
    public Na(double x, double y){
        super(x, y, 20, new Color(200, 200, 0), "Na");
        System.out.println("vel: " + vel.x() + " " + vel.y());
    }
    
    public ArrayList<Particle> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        if(p.formula.equals("HCO3")){
            if (Math.random() > .999) {
                products.add(new NaHCO3(pos.x(), pos.y()));
            }
        }
        return products;
    }
    
}
