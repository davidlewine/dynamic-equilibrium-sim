package dynamicequilibrium;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author David
 */
public class C6H8O7 extends Particle{
    
    public C6H8O7(double x, double y){
        super(x, y, 20, new Color(200, 0, 200), "C6H8O7");
    }
    @Override
    public void display(Graphics g){
        System.out.println(charge);
        c = new Color(200 + charge*50, 0, 200 + charge*50);
        g.setColor(c);
        g.fillOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
    }
    
}
