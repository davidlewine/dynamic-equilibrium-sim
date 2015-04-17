package dynamicequilibrium;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class C6H6O7 extends Particle{
    
    public C6H6O7(double x, double y){
        super(x, y, 20, new Color(200, 0, 200), "C6H6O7");
    }
    @Override
    public void display(Graphics g){
        //System.out.println(charge);
        c = new Color(150, 0,  150);
        g.setColor(c);
        g.fillOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
    }
    
    public ArrayList<Particle> react(){
        ArrayList<Particle> products = new ArrayList();
            if (Math.random() > .992) {
                products.add(new H(pos.x(), Math.max(pos.y() - 1*r, 0)));
                products.add(new C6H5O7(Math.max(pos.x() - 1 * r, 0), pos.y()));
            }
        return products;
    }
    
}