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
import java.awt.Font;
import math.geom2d.*;
import java.util.*;

public class Particle{
    
    public Vector2D pos, vel;
    public double r;
    public Color c;
    public double rate = .5;
    public String formula;
    public int charge = 0;
    public int[] bin = {0,0};
    public Font particleFont;

    
    public Particle(double x, double y, double rr, Color cc, String f){
        pos = new Vector2D(x, y);
        r = rr;
        c = cc;
        vel = new Vector2D(Math.random()/rate - .5/rate, Math.random()/rate - .5/rate);
        formula = f;
        particleFont = new Font("TimesRoman", Font.PLAIN, 10); 
    }
    
    
    public void move(){
        pos = pos.plus(vel);
    }
    
    public ArrayList<Particle> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        return products;
    }
    public ArrayList<Particle> react(){
        ArrayList<Particle> products = new ArrayList();
        return products;
    }
    
    public void display(Graphics g){
        g.setColor(c);
        g.setFont(particleFont);
        //g.fillOval((int)pos.x(), (int)pos.y(), (int)r, (int)r);
      
        g.drawString(formula, (int)pos.x(), (int)pos.y());
    }
    
}
