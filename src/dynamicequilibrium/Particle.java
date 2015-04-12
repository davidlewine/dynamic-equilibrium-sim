/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

/**
 *
 * @author David
 */


import java.awt.Graphics;
import java.awt.Color;
import math.geom2d.*;

public class Particle{
    
    public Vector2D pos, vel;
    public double r;
    public Color c;
    public int width;
    public double rate = .5;
    public String formula;
    public int charge = 0;

    
    public Particle(double x, double y, double rr, Color cc, String f){
        pos = new Vector2D(x, y);
        r = rr;
        c = cc;
        vel = new Vector2D(Math.random()/rate - .5/rate, Math.random()/rate - .5/rate);
        formula = f;
    }
    
    
    public void move(){
        pos = pos.plus(vel);
    }
    
    public void display(Graphics g){
        g.setColor(c);
        g.fillOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
    }
    
}
