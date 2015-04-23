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
import java.util.ArrayList;
public class H extends Particle{
    
    public H(double x, double y){
        super(x, y, 10, new Color(255, 0, 0), "H");

    }
    public ArrayList<Particle> react(Particle p){
        ArrayList<Particle> products = new ArrayList();
        if(p.formula.equals("Cl")){
            if (Math.random() > 1) {
                    products.add(new HCl(pos.x(), pos.y()));
                }
        }
        if(p.formula.equals("HCO3")){
            if (Math.random() > .988) {
                    products.add(new H2O(pos.x(), pos.y()));
                }
        }
        if(p.formula.equals("C6H7O7")){
            if (Math.random() > .996) {
                    products.add(new C6H8O7(pos.x(), pos.y()));
                }
        }
        if(p.formula.equals("C6H6O7")){
            if (Math.random() > .996) {
                    products.add(new C6H7O7(pos.x(), pos.y()));
                }
        }
        if(p.formula.equals("C6H5O7")){
            if (Math.random() > .996) {
                    products.add(new C6H6O7(pos.x(), pos.y()));
                }
        }
        return products;
    }
    
}
