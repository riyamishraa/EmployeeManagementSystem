package Employee_Management_System;

import javax.swing.*;
import java.awt.Font;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main_class extends JFrame {


    Main_class(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);


        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(100,80,400,40);
        heading.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(105,160,200,30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new addEmployee();
                setVisible(false);

            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(105,230,200,30);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.BLACK);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);


            }
        });
        img.add(view);


        JButton rem = new JButton("Remove Employee");
        rem.setBounds(105,300,200,30);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.BLACK);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new remove_employee();
            }
        });
        img.add(rem);



        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String args[]){
        new Main_class();

    }
}
