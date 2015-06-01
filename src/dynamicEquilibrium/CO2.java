/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.awt.Color;
import java.awt.Graphics;
import math.geom2d.Vector2D;

/**
 *
 * @author David
 */
public class CO2 extends Particle{
    
    public CO2(double x, double y){
        super(x, y, 20, new Color(0, 0, 255), "CO2");
        vel = new Vector2D(0, -2);
        state = "gas";
    }
    
    public void display(Graphics g){
        g.setColor(c);
        g.setFont(particleFont);
        g.drawOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
      
        g.drawString(formula, (int)pos.x(), (int)pos.y());
    }
    
   
}
