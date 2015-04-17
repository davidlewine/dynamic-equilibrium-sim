/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game extends JFrame implements WindowListener
{
  private static int DEFAULT_FPS = 60;

  private GamePanel gp;        // where the worm is drawn
  private JTextField jtfBox;   // displays no.of boxes used
  private JTextField jtfTime;  // displays time spent in game
  private JTextField hData;  // displays number of H ions
  private JTextField hco3Data;  // displays number of H ions
  private JTextField hclData;  // displays number of H ions
  private JTextField nahco3Data;  // displays number of H ions
  private JTextField c6h8o7Data;  // displays number of H ions
  private JTextField h2oData;  // displays number of H ions
  private JTextField naData;  // displays number of H ions
  private JTextField clData;  // displays number of H ions


  public Game(int period)
  { super("Dynamic Equilibrium");
    makeGUI(period);

    addWindowListener( this );
    pack();
    setResizable(false);
    setVisible(true);
  }  // end of WormChase() constructor


  private void makeGUI(int period)
  {
    Container c = getContentPane();    // default BorderLayout used

    gp = new GamePanel(this, period);
    c.add(gp, "Center");

    JPanel ctrls = new JPanel();   // a row of textfields
    ctrls.setLayout( new BoxLayout(ctrls, BoxLayout.X_AXIS));

//    jtfBox = new JTextField("Boxes used: 0");
//    jtfBox.setEditable(false);
//    ctrls.add(jtfBox);

    jtfTime = new JTextField("Time Spent: 0 secs");
    jtfTime.setEditable(false);
    ctrls.add(jtfTime);
    
    hData = new JTextField("H+: 0 ");
    hData.setEditable(false);
    ctrls.add(hData);
    
    hclData = new JTextField("HCl: 0 ");
    hclData.setEditable(false);
    ctrls.add(hclData);
    
    clData = new JTextField("cl: 0 ");
    clData.setEditable(false);
    ctrls.add(clData);
    
    hco3Data = new JTextField("HCO3: 0 ");
    hco3Data.setEditable(false);
    ctrls.add(hco3Data);
    
    nahco3Data = new JTextField("NAHCO3: 0 ");
    nahco3Data.setEditable(false);
    ctrls.add(nahco3Data);
    
    c6h8o7Data = new JTextField("C6H8O7: 0 ");
    c6h8o7Data.setEditable(false);
    ctrls.add(c6h8o7Data);
    
    h2oData = new JTextField("H2O: 0 ");
    h2oData.setEditable(false);
    ctrls.add(h2oData);
    
    naData = new JTextField("na: 0 ");
    naData.setEditable(false);
    ctrls.add(naData);
    
    

    c.add(ctrls, "South");
  }  // end of makeGUI()


//  public void setBoxNumber(int no)
//  {  jtfBox.setText("Boxes used: " + no);  }

  public void setTimeSpent(long t)
  {  jtfTime.setText("timeSpent: " + t + " secs"); }
  
  public void seth(int n)
  {  hData.setText("H+: " + n); }
  
  public void sethcl(int n)
  {  hclData.setText("HCl: " + n); }
  
  public void setcl(int n)
  {  clData.setText("Cl: " + n); }
  
  public void sethco3(int n)
  {  hco3Data.setText("HCO3: " + n); }
  
  public void setnahco3(int n)
  {  nahco3Data.setText("NaHCO3: " + n); }
  
  public void setc6h8o7(int n)
  {  c6h8o7Data.setText("C6H8O7: " + n); }
  
  public void seth2o(int n)
  {  h2oData.setText("H2O: " + n); }
  
   public void setna(int n)
  {  naData.setText("Na: " + n); }
  

  

  // ----------------- window listener methods -------------

  public void windowActivated(WindowEvent e) 
  { gp.resumeGame();  }

  public void windowDeactivated(WindowEvent e) 
  {  gp.pauseGame();  }


  public void windowDeiconified(WindowEvent e) 
  {  gp.resumeGame();  }

  public void windowIconified(WindowEvent e) 
  {  gp.pauseGame(); }


  public void windowClosing(WindowEvent e)
  {  gp.stopGame();  }

  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}

  // ----------------------------------------------------

  public static void main(String args[])
  { 
    int fps = DEFAULT_FPS;
    if (args.length != 0)
      fps = Integer.parseInt(args[0]);

    int period = (int) 1000.0/fps;
    System.out.println("fps: " + fps + "; period: " + period + " ms");

    new Game(period);    // ms
  }

} // end of WormChase class