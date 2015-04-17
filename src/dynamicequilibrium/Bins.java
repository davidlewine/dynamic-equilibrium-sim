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
import java.util.ArrayList;

public class Bins {
    int dim = 5;
    ArrayList<Particle>[][] bins;
    int width;
    int height;
    
    
    public Bins(int w, int h){
        width = w;
        height = h;
        int rows = h/dim + 1;
        int cols = w/dim + 1;
        bins = new ArrayList[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j<cols; j++){
                bins[i][j] = new ArrayList<Particle>();
            }
        }
        

    }
    
    public void remove(Particle p){
        //System.out.println("particle: " + p + " bin: " + p.bin[0] + " " + p.bin[1]);
        int row = Math.min(Math.max((int)(p.pos.y()/dim), 0), height/dim);
        int col = Math.min(Math.max((int)(p.pos.x()/dim), 0), width/dim);
        
        int x = bins[row][col].indexOf(p);
        if(x >= 0){
            //System.out.println("remove: " + p + " ex: " + p.bin[0] + " " + p.bin[1] + " ac: " + row + ' ' + col);
            bins[row][col].remove(x);
            p.bin[0] = -1;
            p.bin[1]= -1;
        }
        else{
            System.out.println(p.formula + " " + p + " ex: " + p.bin[0] + " " + p.bin[1] + " ac: " + row + ' ' + col);
        }
    }
    
    public void add(Particle p){
        int row = Math.min(Math.max((int)(p.pos.y()/dim), 0), height/dim);
        int col = Math.min(Math.max((int)(p.pos.x()/dim), 0), width/dim);
 
        bins[row][col].add(p);
        p.bin[0] = row;
        p.bin[1] = col;
        //System.out.println("i: " + i + " j: " + j + " p: " + p);
        //System.out.println();
    }
    
    public ArrayList<Particle> getNeighbors(Particle p){
        ArrayList<Particle> neighbors = new ArrayList();
        int pRow = (int)(p.pos.y()/dim);
        int pCol = (int)(p.pos.x()/dim);
        for(int i = -1; i<2; i++){
            for(int j = -1; j<2; j++){
                int r = pRow + i;
                int c = pCol + j;
                if(r >= 0 && r <= height/dim && c >= 0 && c <= width/dim){
                    neighbors.addAll(bins[pRow + i][pCol + j]);
                }
            }
        }
        return neighbors;
    } 
    
 
}
