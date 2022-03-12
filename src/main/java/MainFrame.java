import org.ini4j.Wini;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    //private Mainpg m_pg = null;

    private Point initialClick;

    public MainFrame()
    {
        //setLocationByPlatform(true);
        //setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);

        // setTitle("MainFrame")
        setSize(Main.barSize, 10);
        int x = 0, y = 0;

        x = Integer.parseInt((String)Main.barLocation.get(0).get("x"));
        y = Integer.parseInt((String)Main.barLocation.get(0).get("y"));

        setLocation(x, y);
        setAlwaysOnTop( true );
        setVisible(true);
        BevelBorder bb = new BevelBorder(BevelBorder.RAISED);

        Main.panel = new JPanel();
        Main.panel.setBackground(Color.GREEN);
        Main.panel.setSize(Main.barSize * 30 / 100, 10);
        //panel.setSize(0, 0);
        Main.panel.setLocation(0,0);
        Main.panel.setBorder(bb);

        Main.panel2 = new JPanel();
        Main.panel2.setBackground(Color.red);
        Main.panel2.setSize(Main.barSize * 40 / 100, 10);
        //panel2.setSize(0, 0);
        Main.panel2.setLocation(0,0);
        Main.panel2.setBorder(bb);

        Main.panel3 = new JPanel();
        Main.panel3.setBackground(Color.blue);
        Main.panel3.setSize(Main.barSize * 100 / 100, 10);
        //panel3.setSize(0, 0);
        Main.panel3.setLocation(0,0);
        Main.panel3.setBorder(bb);

        setLayout(null);
        getContentPane().add(Main.panel);
        getContentPane().add(Main.panel2);
        getContentPane().add(Main.panel3);

        this.addMouseListener(new moveWindows());
        this.addMouseMotionListener(new moveWindows());
    }

    class moveWindows extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            initialClick = e.getPoint();
            getComponentAt(initialClick);
        }

        public void mouseDragged(MouseEvent e)
        {
            JFrame jf = (JFrame) e.getSource();

            int thisX = jf.getLocation().x;
            int thisY = jf.getLocation().y;

            int xMoved = e.getX() - initialClick.x;
            int yMoved = e.getY() - initialClick.y;

            int X = thisX + xMoved;
            int Y = thisY + yMoved;
            jf.setLocation(X, Y);

            File iniFile = new File("recipe.ini");

            try {
                Wini wini = new Wini(iniFile);

                wini.put("사이드바 위치", "x", "" + X);
                wini.put("사이드바 위치", "y", "" + Y);

                //신규생성
                wini.store();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
