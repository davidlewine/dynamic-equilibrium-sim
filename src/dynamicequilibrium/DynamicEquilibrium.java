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
    int width, height;
    double atomRad;

    public DynamicEquilibrium(int w, int h) {
        width = w;
        height = h;
        for (int i = 0; i < 0; i++) {
            Particle tempParticle = new HCl(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            hclList.add(tempParticle);
        }
        for (int i = 0; i < 75; i++) {
            Particle tempParticle = new NaHCO3(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            nahco3List.add(tempParticle);
        }
        for (int i = 0; i < 20; i++) {
            Particle tempParticle = new C6H8O7(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            c6h8o7List.add(tempParticle);
        }
    }

    public void update() {
        moveParticles();
        react();
    }

    public void moveParticles() {
        moveList(nahco3List);
        moveList(hclList);
        moveList(h2oList);
        moveList(hList);
        moveList(naList);
        moveList(clList);
        moveList(hco3List);
        moveList(c6h8o7List);
        moveList(c6h5o7List);
    }

    public void moveList(ArrayList<Particle> list) {
        Iterator<Particle> iter = list.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            particle.move();
            if (particle.pos.x() <= 0 || particle.pos.x() >= width) {
                particle.vel = new Vector2D(-particle.vel.x(), particle.vel.y());
            }
            if (particle.pos.y() <= 0 || particle.pos.y() >= height) {
                particle.vel = new Vector2D(particle.vel.x(), -particle.vel.y());
            }
        }
    }

    public void react() {
        //nahco3 reactions
        Iterator<Particle> iter = nahco3List.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            if (Math.random() > .996) {
                naList.add(new Na(Math.min(particle.pos.x() + 1 * particle.r, width), particle.pos.y()));
                hco3List.add(new HCO3(Math.max(particle.pos.x() - 1 * particle.r, 0), particle.pos.y()));
                iter.remove();
            }
        }

        //hcl reactions
        iter = hclList.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            if (Math.random() > .995) {
                hList.add(new H(Math.min(particle.pos.x() + 1 * particle.r, width), particle.pos.y()));
                clList.add(new Cl(Math.max(particle.pos.x() - 1 * particle.r, 0), particle.pos.y()));
                iter.remove();
            }
        }
        
        //C6H8O7 reactions
        iter = c6h8o7List.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            if(particle.charge > -3){
                if (Math.random() > .998) {
                    hList.add(new H(Math.min(particle.pos.x() + 1 * particle.r, width), particle.pos.y()));
//                    hList.add(new Na(particle.pos.x(), Math.min(particle.pos.y() + 1 * particle.r, height)));
//                    hList.add(new Na(particle.pos.x(), Math.max(particle.pos.y() - 1 * particle.r, height)));
                    particle.charge--;
//                    iter.remove();
                }
            }
        }

        //h reactions
        iter = hList.iterator();
        whileIter:
        while (iter.hasNext()) {
            Particle pa = iter.next();
            Iterator<Particle> iterB = clList.iterator();
            while (iterB.hasNext()) {
                Particle pb = iterB.next();
                if ((pa.pos.minus(pb.pos)).norm() < pa.r + pb.r) {//if pa and pb are touching
                    if (Math.random() > .996) {
                        hclList.add(new HCl(pa.pos.x(), pa.pos.y()));
                        iterB.remove();
                        iter.remove();
                        continue whileIter;
                    }
                }
            }

            iterB = hco3List.iterator();
            while (iterB.hasNext()) {
                Particle pb = iterB.next();
                if ((pa.pos.minus(pb.pos)).norm() < pa.r + pb.r) {//if pa and pb are touching
                    if (Math.random() > .992) {
                        h2oList.add(new H2O(pa.pos.x(), pa.pos.y()));
                        iterB.remove();
                        iter.remove();
                        continue whileIter;
                    }
                }
            }
            
            iterB = c6h8o7List.iterator();
            while (iterB.hasNext()) {
                Particle pb = iterB.next();
                if (pb.charge < 0 && ((pa.pos.minus(pb.pos)).norm() < pa.r + pb.r)) {//if pa and pb are touching
                    if (Math.random() > .992) {
                        pb.charge++;
                        iter.remove();
                        continue whileIter;
                    }
                }
            }
        }

        //Na reactions
        iter = naList.iterator();
        whileIter:
        while (iter.hasNext()) {
            Particle pa = iter.next();
            Iterator<Particle> iterB = hco3List.iterator();
            while (iterB.hasNext()) {
                Particle pb = iterB.next();
                if ((pa.pos.minus(pb.pos)).norm() < pa.r + pb.r) {//if pa and pb are touching
                    if (Math.random() > .997) {
                        nahco3List.add(new NaHCO3(pa.pos.x(), pa.pos.y()));
                        iterB.remove();
                        iter.remove();
                        continue whileIter;
                    }
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
