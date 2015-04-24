package dynamicequilibrium;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author David
 */
public class C6H8O7 extends Particle {

    public C6H8O7(double x, double y) {
        super(x, y, 20, new Color(200, 0, 200), "C6H8O7");
    }

//    @Override
//    public void display(Graphics g) {
//        //System.out.println(charge);
//        c = new Color(250, 0, 250);
//        g.setColor(c);
//        g.fillOval((int) pos.x(), (int) pos.y(), (int) r, (int) r);
//    }

//    public ArrayList<Particle> react(){
//        ArrayList<Particle> products = new ArrayList();
//            if (Math.random() > .992) {
//                products.add(new H(pos.x(), Math.max(pos.y() - 1*r, 0)));
//                products.add(new C6H7O7(Math.max(pos.x() - 1 * r, 0), pos.y()));
//            }
//        return products;
//    }
    public Hashtable<String, ArrayList<Particle>> react(Particle p) {
        ArrayList<Particle> products = new ArrayList();
        ArrayList<Particle> destroyed = new ArrayList();
        Hashtable<String, ArrayList<Particle>> results = new Hashtable(5);

        if (Math.random() > .991) {
            products.add(new H(pos.x(), Math.max(pos.y() - 1 * r, 0)));
            products.add(new C6H7O7(Math.max(pos.x() - 1 * r, 0), pos.y()));
            destroyed.add(this);
        }

        results.put("produced", products);
        results.put("destroyed", destroyed);
        return results;
    }

}
