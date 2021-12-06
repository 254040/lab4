package pl.draw;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MyFrame start = new MyFrame();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
