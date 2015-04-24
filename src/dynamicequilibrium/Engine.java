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

public class Engine extends JPanel {

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
    ArrayList<Particle> c6h6o7List = new ArrayList();
    ArrayList<Particle> c6h7o7List = new ArrayList();
    Hashtable<String, ArrayList<Particle>> particleLists = new Hashtable(20);
    int width, height;
    double atomRad;
    double hCountOld = 0, hRate = 0;
    long rateTimer = 3, startTime = 0;
    Bins bins;

    public Engine(int w, int h) {
        width = w;
        height = h;
        bins = new Bins(w, h);
        particleLists.put("HCl", hclList);
        particleLists.put("NaHCO3", nahco3List);
        particleLists.put("H2O", h2oList);
        particleLists.put("HCO3", hco3List);
        particleLists.put("C6H8O7", c6h8o7List);
        particleLists.put("C6H7O7", c6h7o7List);
        particleLists.put("C6H6O7", c6h6o7List);
        particleLists.put("C6H5O7", c6h5o7List);
        particleLists.put("Na", naList);
        particleLists.put("Cl", clList);
        particleLists.put("H", hList);

        for (int i = 0; i < 0; i++) {
            Particle tempParticle = new HCl(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            hclList.add(tempParticle);
            bins.add(tempParticle);
        }
        for (int i = 0; i < 0; i++) {
            Particle tempParticle = new NaHCO3(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            nahco3List.add(tempParticle);
            bins.add(tempParticle);
        }
        for (int i = 0; i < 0; i++) {
            Particle tempParticle = new C6H8O7(Math.random() * width, Math.random() * height);
            //particles.add(tempParticle);
            c6h8o7List.add(tempParticle);
            bins.add(tempParticle);
        }
    }

    public void addParticles(String s, int numPs) {
        int numParticles = numPs;
        if (s.equals("HCl")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new HCl(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                hclList.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("H")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new H(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                hList.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("Cl")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new Cl(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                clList.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("NaHCO3")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new NaHCO3(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                nahco3List.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("HCO3")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new HCO3(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                hco3List.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("Na")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new Na(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                naList.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        if (s.equals("C6H8O7")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new C6H8O7(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                c6h8o7List.add(tempParticle);
                bins.add(tempParticle);
            }
        }
        
        if (s.equals("C6H5O7")) {
            for (int i = 0; i < numParticles; i++) {
                Particle tempParticle = new C6H5O7(Math.random() * width, Math.random() * height);
                //particles.add(tempParticle);
                c6h5o7List.add(tempParticle);
                bins.add(tempParticle);
            }
        }
    }

    public void update() {
        moveParticles();
        reactParticles();
        updateRates();
    }

    public void updateRates() {
        long currentTime = System.currentTimeMillis();
        if (currentTime >= startTime + rateTimer * 1000) {
            hRate = 1000 * (hList.size() - hCountOld) / (currentTime - startTime);
            hCountOld = hList.size();
            startTime = currentTime;
        }
    }

    public void moveParticles() {
        for (Enumeration e = particleLists.keys(); e.hasMoreElements();) {
            ArrayList<Particle> list = particleLists.get(e.nextElement());
            moveList(list);
            //System.out.println("moveList" + list);
        }
    }

    public void moveList(ArrayList<Particle> list) {
        Iterator<Particle> iter = list.iterator();
        while (iter.hasNext()) {
            Particle particle = iter.next();
            if (particle.bin[0] == -1) {
                System.out.println("-1: " + particle);
            }
            bins.remove(particle);
            particle.move();

            if (particle.pos.x() < 0) {
                particle.vel = new Vector2D(Math.abs(particle.vel.x()), particle.vel.y());
                particle.pos = new Vector2D(0, particle.pos.y());
            }
            if (particle.pos.x() > width) {
                particle.vel = new Vector2D(-1 * Math.abs(particle.vel.x()), particle.vel.y());
                particle.pos = new Vector2D(width, particle.pos.y());
            }
            if (particle.pos.y() < 0) {
                particle.vel = new Vector2D(particle.vel.x(), Math.abs(particle.vel.y()));
                particle.pos = new Vector2D(particle.pos.x(), 0);
            }
            if (particle.pos.y() > height) {
                particle.vel = new Vector2D(particle.vel.x(), -1 * Math.abs(particle.vel.y()));
                particle.pos = new Vector2D(particle.pos.x(), height);
            }
            bins.add(particle);

        }
    }

    public void reactParticles() {
        //to do: search for neighbors and react with first neighbor.
        for (Enumeration e = particleLists.keys(); e.hasMoreElements();) {
            ArrayList<Particle> list = particleLists.get(e.nextElement());
            int listIndex = 0;//this cant be an iterator because the neighbor might be of the same type 
            //and then the neighbor and the particle will both need to be removed from 
            //the same list, i.e. Concurrent modification.
            while (listIndex < list.size()) {
                Particle particle = list.get(listIndex);
                ArrayList<Particle> products = new ArrayList();
                ArrayList<Particle> destroyed = new ArrayList();

                ArrayList<Particle> neighbors = bins.getNeighbors(particle);
                Iterator<Particle> neighborsIter = neighbors.iterator();
                while (neighborsIter.hasNext() && products.size() == 0) {
                    Particle neighbor = neighborsIter.next();
                    if (neighbor != particle) {
                        Hashtable<String, ArrayList<Particle>> results = particle.react(neighbor);
                        products = results.get("produced");
                        destroyed = results.get("destroyed");
                        if (products.size() > 0) {
                            //System.out.println("part: " + particle + " neighbor: " + neighbor);
                            for (Particle p : products) {
                                particleLists.get(p.formula).add(p);
                                bins.add(p);
                                //System.out.println("part: " + particle + " neighbor: " + neighbor + " prod: " + p);
                            }
                        }
//                            for(Particle p : destroyed){
//                                bins.remove(p);
//                                particleLists.get(p.formula).remove(p);
//                            }
                        //}
                    }
                }

                if (destroyed.size() > 0) {
                    for (Particle p : destroyed) {
                        bins.remove(p);
                        particleLists.get(p.formula).remove(p);
                        if (p == particle) {
                            listIndex--;
                        }
                    }

                }
                listIndex++;
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
//        for (Particle p : h2oList) {
//            p.display(g);
//        }
        for (Particle p : c6h8o7List) {
            p.display(g);
        }
        for (Particle p : c6h7o7List) {
            p.display(g);
        }
        for (Particle p : c6h6o7List) {
            p.display(g);
        }
        for (Particle p : c6h5o7List) {
            p.display(g);
        }
    }
}
