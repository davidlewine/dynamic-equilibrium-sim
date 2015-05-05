/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.MouseInputAdapter;


public class Game extends JFrame implements WindowListener
{
  private static int DEFAULT_FPS = 60;
  private int width = 800;
  private int height = 600;
  private GamePanel gp;        // where the worm is drawn
  
  public Engine engine;
  public boolean paused = false;


  public Game(int period)
  { super("Dynamic Equilibrium");
    engine = new Engine(width, height);
    makeGamePanel(period);
    

    addWindowListener( this );
    pack();
    setResizable(false);
    setVisible(true);
  }  // end of WormChase() constructor


  private void makeGamePanel(int period)
  {
    Container c = getContentPane();    // default BorderLayout used

    gp = new GamePanel(this, engine, period);
    c.add(gp, "Center");
  }

    



  
//  public void guiUpdate(){
//      if(gui != null){
//      gui.update();
//      }
//  }
//  public void guiRender(){
//      if(gui != null){
//      gui.render();
//      }
//  }

 
//  public void seth(int n)
//  {  hData.setText("H+: " + n); }
  
  
  
 public void pause(){
     if(paused){
         paused = false;
         gp.resumeGame();
         System.out.println("resume");
     }
     else{
         paused = true;
         gp.pauseGame();
         System.out.println("pause");
     }
 }
 
 public void clearParticles(){
     pause();//pause to avoid concurrent modification depending on what is happening--
            //engine could be modifying particle lists in reaction method.
     engine.clearParticles();
     pause();//unpause
 }
 
 public void addParticles(String formula, int numParticles){
     pause();//pause to avoid concurrent modification depending on what is happening--
            //engine could be modifying particle lists in reaction method.
     //int numParticles = Integer.parseInt(JOptionPane.showInputDialog(this, "enter number of particles"));
     engine.addParticles(formula, numParticles);
     pause();//unpause
 }
 
 public void setFrameRate(){
     int newPeriod = Integer.parseInt(JOptionPane.showInputDialog(this, "set frame rate")); 
     gp.setPeriod(newPeriod);
     //System.out.println("period: " + gp.getPeriod());
 }
  

  // ----------------- window listener methods -------------

  public void windowActivated(WindowEvent e) 
  { 
      //gp.resumeGame();
  }

  public void windowDeactivated(WindowEvent e) 
  {  
    //gp.pauseGame();    
  }


  public void windowDeiconified(WindowEvent e) 
  {  
      //gp.resumeGame();  
  }

  public void windowIconified(WindowEvent e) 
  {  
      //gp.pauseGame(); 
  }


  public void windowClosing(WindowEvent e)
  {  gp.stopGame();  }

  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}

  // ----------------------------------------------------

//  public static void main(String args[])
//  { 
//    int fps = DEFAULT_FPS;
//    if (args.length != 0)
//      fps = Integer.parseInt(args[0]);
//
//    int period = (int) 1000.0/fps;
//    System.out.println("fps: " + fps + "; period: " + period + " ms");
//
//    new Game(period);    // ms
//  }
  
} // end of WormChase class