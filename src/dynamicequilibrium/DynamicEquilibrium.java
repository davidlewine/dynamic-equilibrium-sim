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
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import math.geom2d.*;

public class DynamicEquilibrium extends JPanel {

    ArrayList<Particle> particles = new ArrayList();
    ArrayList<Particle> hList = new ArrayList();
    ArrayList<Particle> h2oList = new ArrayList();
    ArrayList<Particle> hclList = new ArrayList();
    ArrayList<Particle> nahco3List = new ArrayList();
    ArrayList<Particle> hco3List = new ArrayList();
    ArrayList<Particle> naList = new ArrayList();
    ArrayList<Particle> clList = new ArrayList();
    ArrayList<Particle> c6h8o7List = new ArrayList();
    ArrayList<Particle> c6h5o7List = new ArrayList();
    Hashtable<String, ArrayList<Particle>> particleLists = new Hashtable(20);
    int width, height;
    double atomRad;
    Bins bins;

    public DynamicEquilibrium(int w, int h) {
        width = w;
        height = h;
        bins = new Bins(w, h);
        particleLists.put("HCl", hclList);
        particleLists.put("NaHCO3", nahco3List);
        particleLists.put("H2O", h2oList);
        particleLists.put("HCO3", hco3List);
        particleLists.put("C6H8O7", c6h8o7List);
        particleLists.put("Na", naList);
        particleLists.put("Cl", clList);
        particleLists.put("H", hList);
        
        for (int i = 0; i < 20; i++) {
            Particle tempParticle = new HCl(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            hclList.add(tempParticle);
            bins.add(tempParticle);
        }
        for (int i = 0; i < 75; i++) {
            Particle tempParticle = new NaHCO3(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            nahco3List.add(tempParticle);
            bins.add(tempParticle);
        }
        for (int i = 0; i < 20; i++) {
            Particle tempParticle = new C6H8O7(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            c6h8o7List.add(tempParticle);
            bins.add(tempParticle);
        }
    }

    public void update() {
        moveParticles();
        reactParticles();
    }

    public void moveParticles() {
        for (Enumeration e = particleLists.keys(); e.hasMoreElements();){
            ArrayList<Particle> list = particleLists.get( e.nextElement() );
            moveList(list);
            //System.out.println("moveList" + list);
        }
    }

    public void moveList(ArrayList<Particle> list) {
        Iterator<Particle> iter = list.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            bins.remove(particle);
            particle.move();
            bins.add(particle);
            if (particle.pos.x() <= 0 || particle.pos.x() >= width) {
                particle.vel = new Vector2D(-particle.vel.x(), particle.vel.y());
            }
            if (particle.pos.y() <= 0 || particle.pos.y() >= height) {
                particle.vel = new Vector2D(particle.vel.x(), -particle.vel.y());
            }
        }
    }
    
    public void reactParticles() {
        for (Enumeration e = particleLists.keys(); e.hasMoreElements();){
            ArrayList<Particle> list = particleLists.get( e.nextElement() );
            Iterator<Particle> iter = list.iterator();
            while (iter.hasNext()) {
                Particle particle = iter.next();
                ArrayList<Particle> products = particle.react();
                if(products.size() > 0){
                    bins.remove(particle);
                    for(Particle p: products){
                        particleLists.get(p.formula).add(p);
                        bins.add(p);
                    }
                    iter.remove();
                }
            }
        }     
    }


    public void draw(Graphics g) {
        for (Particle p : nahco3List) {
            p.display(g);
        }
        for (Particle p : hclList) {
            p.display(g);
        }
        for (Particle p : hList) {
            p.display(g);
        }
        for (Particle p : clList) {
            p.display(g);
        }
        for (Particle p : naList) {
            p.display(g);
        }
        for (Particle p : hco3List) {
            p.display(g);
        }
        for (Particle p : h2oList) {
            p.display(g);
        }
        for (Particle p : c6h8o7List) {
            p.display(g);
        }
    }
}
