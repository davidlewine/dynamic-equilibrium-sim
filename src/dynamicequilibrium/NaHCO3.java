package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class NaHCO3 extends Particle{
    
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
    public ArrayList<Particle> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        if(p.formula.equals("NaHCO3")){
            if (Math.random() > .990) {
                products.add(new Na(pos.x(), Math.max(pos.y() - 1*r, 0)));
                products.add(new HCO3(Math.max(pos.x() - 1 * r, 0), pos.y()));
                products.add(new Na(Math.max(pos.x() - 1 * r, 0), Math.max(pos.y() - 1*r, 0)));
                products.add(new HCO3(pos.x(), pos.y()));
                }
        }
        return products;
    }
    
}
