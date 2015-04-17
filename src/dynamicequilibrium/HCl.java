package dynamicequilibrium;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class HCl extends Particle{
    
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
    public ArrayList<Particle> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        if(p.formula.equals("HCl")){
            if (Math.random() > .991) {
                products.add(new H(pos.x(), Math.max(pos.y() - 1*r, 0)));
                products.add(new Cl(Math.max(pos.x() - 1 * r, 0), pos.y()));
                products.add(new H(Math.max(pos.x() - 1 * r, 0), Math.max(pos.y() - 1*r, 0)));
                products.add(new Cl(pos.x(), pos.y()));
                }
        }
        return products;
    }
    
}
