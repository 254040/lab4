package pl.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame implements MouseMotionListener, MouseListener, KeyListener, ActionListener {

    private final JButton cancelButton;
    private  final JButton acceptButton;
    private final DrawPanel panel;
    protected int x_accept = 800;
    protected int y_accept = 700;
    protected int mouse_x;
    protected int mouse_y;
    protected boolean j_key = false;
    protected boolean k_key = false;


    public MyFrame(){
        JFrame frame = new JFrame("App");

        panel = new DrawPanel();
        panel.setLayout(null);

        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(200, 700, 130, 100);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        acceptButton = new JButton("Accept");
        acceptButton.setBounds(x_accept, y_accept, 130, 100);
        panel.add(acceptButton);
        panel.addMouseMotionListener(this);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);

        frame.setSize(1200,1000);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(cancelButton)){
            move_button(800, 700);
            panel.removeAll();
            panel.add(acceptButton);
            panel.add(cancelButton);
            panel.repaint();
        }
    }

    class DrawPanel extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();


            if(k_key) {
                g2d.setColor(Color.BLACK);
                g2d.fillOval(mouse_x, mouse_y, 30, 30);
                k_key = false;
            }
            if(j_key){
                g2d.setColor(Color.BLUE);
                g2d.fillRect(mouse_x, mouse_y, 40, 40);
                j_key = false;
            }


        }


    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyChar() == 'o' || e.getKeyChar() == 'O'){
            this.k_key = true;
            panel.paintImmediately(mouse_x, mouse_y, 30, 30);

        }
        if(e.getKeyChar() == 'k' || e.getKeyChar() == 'K'){
            this.j_key = true;
            panel.paintImmediately(mouse_x, mouse_y, 40, 40);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse_x = e.getX();
        mouse_y = e.getY();

        if (e.getX() > x_accept - 30 && e.getX() < x_accept && e.getY() > y_accept - 30 && e.getY() < y_accept + 130) {
            if(e.getX() < x_accept && e.getX() > x_accept -30 && e.getY() < y_accept && e.getY() > y_accept - 30){

                move_button(e.getX() + 30, e.getY() + 30);
            }
            else if(e.getX() < x_accept && e.getX() > x_accept -30 && e.getY() > y_accept + 100 && e.getY() < y_accept + 130) {

                move_button(e.getX() + 60, e.getY() - 160);

            }
            else {
                move_button(e.getX() + 30, this.y_accept);
            }


        }

        if (e.getX() > x_accept && e.getX() < x_accept + 140 && e.getY() < y_accept && e.getY() > y_accept - 30){
            move_button(this.x_accept, e.getY() + 30);
        }

        if (e.getX() > x_accept && e.getX() < x_accept + 140 && e.getY() > y_accept + 100 && e.getY() < y_accept + 130){
            move_button(this.x_accept, e.getY() - 160);
        }
    }

    public void move_button(int x, int y){

        acceptButton.setBounds(x, y, 140, 100);
        setX(x);
        setY(y);

    }
    public void setX(int x) {
        this.x_accept = x;
    }

    public void setY(int y) {
        this.y_accept = y;
    }
}
