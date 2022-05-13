package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JButton sarah;
    JButton Goodbye;
    JLabel label;
    JLabel nikos;
    JLabel Sar;
    JLabel usL;
    int x = 0;
    int y = 0;
    int l = 0;



    Calendar calendar;
    SimpleDateFormat timeFormat;
    String time;


    //String time () {

    //  var d = new Date();
    // var s = d.getSeconds();
    //  var m = d.getMinutes();
    //  var h = d.getHours();
    //  var g = (h + ":" + m + ":" + s);

    //  return g;

    // }


    MyFrame() {

        ImageIcon us = new ImageIcon("us.png");
        Image image4 = us.getImage();
        Image newimg4 = image4.getScaledInstance (200,125, java.awt.Image.SCALE_SMOOTH);
        us = new ImageIcon (newimg4);

        usL = new JLabel();
        usL.setBounds(140, 15, 200, 125);
        usL.setIcon(us);

        ImageIcon cry = new ImageIcon("cry.png");
        Image image3 = cry.getImage();
        Image newimg3 = image3.getScaledInstance (30,30, java.awt.Image.SCALE_SMOOTH);
        cry = new ImageIcon (newimg3);

        ImageIcon picSarah = new ImageIcon("sarah.png");
        Image image2 = picSarah.getImage();
        Image newimg2 = image2.getScaledInstance (120,120, java.awt.Image.SCALE_SMOOTH);
        picSarah = new ImageIcon (newimg2);


        Sar = new JLabel();
        Sar.setBounds(280, 25, 120, 120);
        Sar.setIcon(picSarah);


        ImageIcon picNikos = new ImageIcon("Nikos.png");
        Image image = picNikos.getImage();
        Image newimg = image.getScaledInstance (120,120, java.awt.Image.SCALE_SMOOTH);
        picNikos = new ImageIcon (newimg);


        nikos = new JLabel();
        nikos.setBounds(80, 25, 120, 120);
        nikos.setIcon(picNikos);




        label = new JLabel();
        label.setText(time);


        label.setBounds(190, 225, 150, 150);
        label.setFont(new Font("Comic Sans", Font.BOLD, 25));


        button = new JButton();
        button.setBounds(50, 150, 175, 100);
        button.addActionListener(this);
        button.setText("Nikos");
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setForeground(Color.black);
        button.setBackground(Color.red);
        button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        button.setFocusable(false);


        sarah = new JButton();
        sarah.setBounds(250, 150, 175, 100);
        sarah.addActionListener(this);
        sarah.setText("Sarah");
        sarah.setFont(new Font("Comic Sans", Font.BOLD, 25));
        sarah.setForeground(Color.black);
        sarah.setBackground(Color.CYAN);
        sarah.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        sarah.setFocusable(false);

        Goodbye = new JButton();
        Goodbye.setBounds(155, 325, 175, 50);
        Goodbye.addActionListener(this);
        Goodbye.setText("GoodBye");
        Goodbye.setFont(new Font("Comic Sans", Font.BOLD, 25));
        Goodbye.setForeground(Color.black);
        Goodbye.setBackground(Color.gray);
        Goodbye.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        Goodbye.setIcon(cry);
        Goodbye.setHorizontalTextPosition(JLabel.LEFT);
        Goodbye.setFocusable(false);
        Goodbye.setEnabled(false);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(sarah);
        this.add(label);
        this.add(nikos);
        this.add(Sar);
        this.add(usL);
        usL.setVisible (false);
        this.setResizable(false);
        this.add(Goodbye);
        this.setTitle("Freeze Time App");

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        time = timeFormat.format(Calendar.getInstance().getTime());
        label.setText(time);

        setTime();
    }

    public void setTime() {
        while (true) {
            if (y + x != 2) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                label.setText(time);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException u) {
                    u.printStackTrace();
                }

            }
            if (y + x == 2) {
                label.setText(time);

            }

        }
    }

        @Override
        public void actionPerformed (ActionEvent e){


            if (e.getSource() == button) {
                x = 1;

                button.setEnabled(false);

            }

            if (e.getSource() == sarah) {
                y = 1;

                sarah.setEnabled(false);
            }


            if (x + y == 2) {
                Goodbye.setEnabled(true);


                Sar.setVisible (false);
                nikos.setVisible (false);
                usL.setVisible (true);
            }
            //System.out.println("loop");
            if (e.getSource() == Goodbye) {
                x = 0;
                y = 0;

                button.setEnabled(true);
                sarah.setEnabled(true);
                Goodbye.setEnabled(false);

                Sar.setVisible (true);
                nikos.setVisible (true);
                usL.setVisible (false);






            }


        }


}



