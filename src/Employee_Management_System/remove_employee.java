package Employee_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class remove_employee extends JFrame implements ActionListener {

    Choice choiceEMPID;
    JButton remove,back;

    remove_employee(){
        JLabel label= new JLabel("EMPLOYEE ID");
        label.setBounds(50,50,200,30);
        label.setFont(new Font(Font.SERIF,Font.BOLD,15));
        add(label);


        choiceEMPID= new Choice();
        choiceEMPID.setBounds(250,50,150,30);
        add(choiceEMPID);
        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("SELECT * FROM employee ");

            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("EMP_ID"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }

        JLabel labelName= new JLabel("NAME");
        labelName.setBounds(50,100,400,30);
        labelName.setFont(new Font(Font.SERIF,Font.BOLD,15));
        add(labelName);

        JLabel textName= new JLabel();
        textName.setBounds(250,100,100,30);
        add(textName);

        JLabel labelphone= new JLabel("PHONE");
        labelphone.setBounds(50,150,400,30);
        labelphone.setFont(new Font(Font.SERIF,Font.BOLD,15));
        add(labelphone);

        JLabel textphone= new JLabel();
        textphone.setBounds(250,150,100,30);
        add(textphone);


        JLabel labelemail= new JLabel("EMAIL");
        labelemail.setBounds(50,200,400,30);
        labelemail.setFont(new Font(Font.SERIF,Font.BOLD,15));
        add(labelemail);

        JLabel textemail = new JLabel();
        setLayout(null);
        textemail.setBounds(250,200,100,30);
        add(textemail);

        try{
            conn c= new conn();
            ResultSet resultSet= c.statement.executeQuery("SELECT * FROM employee where EMP_ID= '"+choiceEMPID.getSelectedItem()+"'");
            while(resultSet.next()){
                textName.setText(resultSet.getString("NAME"));
                textphone.setText(resultSet.getString("PHONE"));
                textemail.setText(resultSet.getString("EMAIL"));

            }

        }catch(Exception E){
            E.printStackTrace();
        }


        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c= new conn();
                    ResultSet resultSet= c.statement.executeQuery("SELECT * FROM employee where EMP_ID= '"+choiceEMPID.getSelectedItem()+"'");
                    while(resultSet.next()){
                        textName.setText(resultSet.getString("NAME"));
                        textphone.setText(resultSet.getString("PHONE"));
                        textemail.setText(resultSet.getString("EMAIL"));

                    }


                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        remove= new JButton("REMOVE");
        remove.setBounds(80,300,100,30);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        add(remove);

        back= new JButton("BACK");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i12 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i13 = new ImageIcon(i12);
        JLabel image = new JLabel(i13);
        image.setBounds(0,0,1120,630);
        add(image);


        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        setLayout(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==remove){
            try{
                conn c= new conn();
                String query = "DELETE FROM employee WHERE EMP_ID='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"DATA DELETED SUCCESSFULLY");
                setVisible(false);
                new Main_class();

            }catch(Exception E){
            E.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }

    }

    public static void main(String[] args) {
       new remove_employee();
    }
}
