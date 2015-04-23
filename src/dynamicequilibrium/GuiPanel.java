/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author David
 */
public class GuiPanel extends JPanel {

    private static final int PWIDTH = 600;   // size of panel
    private static final int PHEIGHT = 600;

    private int period;                // period between drawing in _ms_

    private Gui gui;
    private Game game;
    public Engine engine;
    boolean running = true;

    // used at game termination
    // off screen rendering
    private Graphics dbg;
    private Image img = null;
    Color hColor = new Color(255, 0, 0);
    Color h2oColor = new Color(0, 0, 255);
    Color bhColor = new Color(255, 0, 255);
    Color haColor = new Color(255, 255, 0);
    int x = -1, xOld = -1;
    int hy = 0, h2oy = 5, bhy = 10, hay = 15;
    int hyOld = 0, h2oyOld = 0, bhyOld = 0, hayOld = 0;
    Button pause, add, frameRate;

    public GuiPanel(Gui g, Game gameArg, Engine engineArg, int period) {
        //ml = new MyListener(); 
        gui = g;
        game = gameArg;
        this.period = period;

        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH, PHEIGHT));

        setFocusable(true);
        requestFocus();    // the JPanel now has focus, so receives key events
        readyForTermination();

        engine = engineArg;
        if (engine == null) {
            System.out.println("null");
        }

        pause = new Button("pause", 50, 10, 10, Color.DARK_GRAY);
        add = new Button("add particles", 100, 10, 10, Color.CYAN);
        //frameRate = new Button("frame rate", 150, 10, 10, Color.PINK);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                //System.out.println("gui pressed");
                checkButtons(e);

            }
        });

        // set up message font
    }  // end of guiPanel()

    private void readyForTermination() {
        addKeyListener(new KeyAdapter() {
            // listen for esc, q, end, ctrl-c on the canvas to
            // allow a convenient exit from the full screen configuration
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if ((keyCode == KeyEvent.VK_ESCAPE) || (keyCode == KeyEvent.VK_Q)
                        || (keyCode == KeyEvent.VK_END)
                        || ((keyCode == KeyEvent.VK_C) && e.isControlDown())) {
                    running = false;
                }
            }
        });
    }  // end of readyForTermination()

    public void addNotify() // wait for the JPanel to be added to the JFrame before starting
    {
        super.addNotify();   // creates the peer
    }

    public void guiUpdate() {
        int p = 2;
        hyOld = hy;
        hayOld = hay;
        bhyOld = bhy;
        h2oyOld = h2oy;
        xOld = x;
        x++;

        //System.out.println("engine");
        hy = engine.hList.size() / p;
        h2oy = engine.h2oList.size() / p;
        bhy = engine.hclList.size() / p;
        hay = engine.hco3List.size() / p + engine.hco3List.size() / p;
    }

    public void checkButtons(MouseEvent e) {
        if (pause.pressed(e.getX(), e.getY())) {
            game.pause();
        }

        if (add.pressed(e.getX(), e.getY())) {
            game.addParticles();
        }

//        if (frameRate.pressed(e.getX(), e.getY())){
//            game.setFrameRate();
//        }
    }

    public void guiRender() {
        if (img == null) {
            img = createImage(PWIDTH, PHEIGHT);
            if (img == null) {
                System.out.println("img is null");
                return;
            } else {
                dbg = img.getGraphics();
                dbg.setColor(Color.white);
                dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
            }
        }
        if (x == PWIDTH) {
            // clear the background and reset x
            dbg.setColor(Color.white);
            dbg.fillRect(0, 0, PWIDTH, PHEIGHT);
            x = -1;
            //Draw buttons
            pause.drawButton(dbg);
            add.drawButton(dbg);
            //frameRate.drawButton(dbg);
        } else {

            //draw new lineSegments
            dbg.setColor(hColor);
            dbg.drawLine(xOld, PHEIGHT - hyOld, x, PHEIGHT - hy);
            dbg.setColor(h2oColor);
            dbg.drawLine(xOld, PHEIGHT - h2oyOld, x, PHEIGHT - h2oy);
            dbg.setColor(bhColor);
            dbg.drawLine(xOld, PHEIGHT - bhyOld, x, PHEIGHT - bhy);
            dbg.setColor(haColor);
            dbg.drawLine(xOld, PHEIGHT - hayOld, x, PHEIGHT - hay);
            //pause.drawButton(dbg);
            //add.drawButton(dbg);
            //frameRate.drawButton(dbg);

        }

    }

    public void paintScreen() // use active rendering to put the buffered image on-screen
    {
        Graphics g;
        try {
            g = this.getGraphics();
            if ((g != null) && (img != null)) {
                g.drawImage(img, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync();  // sync the display on some systems
            g.dispose();
        } catch (Exception e) {
            System.out.println("Graphics error: " + e);
        }
    } // end of paintScreen()

}  // end of WormPanel class

