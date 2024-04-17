package Employee_Management_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {
    JTable table;
    Choice choiceEMP;
    JButton searchbtn ,print,update,back;
    ViewEmployee(){


        getContentPane().setBackground(new Color(250,250,250));
        JLabel search = new JLabel("SEARCH BY EMPLOYEE ID");
        search.setFont(new Font(Font.SERIF,Font.BOLD,20));
        search.setBounds(280,60,300,20);
        add(search);
         choiceEMP = new Choice();
         choiceEMP.setBounds(550,90,150,20);
         add(choiceEMP);

         try{
             conn c= new conn();
             ResultSet resultset= c.statement.executeQuery("Select * FROM employee ");
             while(resultset.next()){
                 choiceEMP.add(resultset.getString("EMP_ID"));
             }

         }catch (Exception e){
             e.printStackTrace();

        }
         table = new JTable();
         try{
             conn c= new conn();
             ResultSet  resultSet= c.statement.executeQuery("Select * FROM employee");
             table.setModel(DbUtils.resultSetToTableModel(resultSet));


         }
         catch(Exception E){
             E.printStackTrace();
         }

         JScrollPane jp = new JScrollPane(table);
         jp.setBounds(0,150,900,600);
         add(jp);

         searchbtn = new JButton("SEARCH");
         searchbtn.setBounds(20,117,90,20);
         searchbtn.addActionListener(this);
         add(searchbtn);

        print = new JButton("PRINT");
        print.setBounds(120,117,90,20);
        print.addActionListener(this);
        add(print);


        update = new JButton("UPDATE");
        update.setBounds(220,117,90,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(320,117,90,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==searchbtn){
            String query="Select * FROM employee Where Emp_ID ='"+ choiceEMP.getSelectedItem()+"'";
            try{
                conn c= new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch(Exception E){
                E.printStackTrace();
            }

        }
        else if(e.getSource()==print){
            try{
                table.print();

            }catch(Exception E){
                E.printStackTrace();

            }
        }

        else if (e.getSource()==update){
            setVisible(false);
            new Update_Employee(choiceEMP.getSelectedItem());


        }

        else {
            setVisible(false);
            new Main_class();

        }



    }
    public static void main(String[] args) {
        new ViewEmployee();


    }


}
