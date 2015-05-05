/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.awt.*;

/**
 *
 * @author David
 */
public class Button {
    int x, y, r;
    Color c;
    Font buttonFont;
    String buttonLabel;
    
    public Button(String bl, int x, int y, int r, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
        this.r = r;
        buttonLabel = bl;
        buttonFont = new Font("TimesRoman", Font.PLAIN, 14); 
    }
    
    public void drawButton(Graphics g){
        g.setColor(c);
        g.setFont(buttonFont);
        g.fillOval(x, y, 2*r, 2*r); 
        g.drawString(buttonLabel, x, y);
        //System.out.println("Button");
    }
    
    public boolean pressed(double a, double b){
        if (Math.sqrt(Math.pow((x+r)-a, 2) + Math.pow((y+r)-b, 2))<r){
            return true;
        }
        else return false;
    }
    
    
}
