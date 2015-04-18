/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Gui extends JFrame implements WindowListener {


  private GuiPanel gp;        // where the worm is drawn
  
  private JTextField hData;  // displays number of H ions
  private JTextField hco3Data;  // displays number of H ions
  private JTextField hclData;  // displays number of H ions
  private JTextField nahco3Data;  // displays number of H ions
  private JTextField c6h8o7Data;  // displays number of H ions
  private JTextField h2oData;  // displays number of H ions
  private JTextField naData;  // displays number of H ions
  private JTextField clData;  // displays number of H ions
  private Game game;
  private Engine engine;

  public Gui(Game g, Engine e, int period){
    super("GUI");
    game = g;
    engine = e;
    makeGuiPanel(period);

    addWindowListener( this );
    pack();
    setResizable(false);
    setVisible(true);
  }  // end of WormChase() constructor


  private void makeGuiPanel(int period)
  {
    Container c = getContentPane();    // default BorderLayout used

    gp = new GuiPanel(this, game, engine, period);
    c.add(gp, "Center");

    JPanel ctrls = new JPanel();   // a row of textfields
    ctrls.setLayout( new BoxLayout(ctrls, BoxLayout.X_AXIS));
    
    

    c.add(ctrls, "South");
  }  // end of makeGUI()
  
  
 public void update(){
     gp.guiUpdate();
 }
 public void render(){
     gp.guiRender();
     gp.paintScreen();
 }
  

  // ----------------- window listener methods -------------

  public void windowActivated(WindowEvent e) 
  {  }

  public void windowDeactivated(WindowEvent e) 
  {   }


  public void windowDeiconified(WindowEvent e) 
  {    }

  public void windowIconified(WindowEvent e) 
  {   }


  public void windowClosing(WindowEvent e)
  {   }

  public void windowClosed(WindowEvent e) {}
  public void windowOpened(WindowEvent e) {}

    
}
