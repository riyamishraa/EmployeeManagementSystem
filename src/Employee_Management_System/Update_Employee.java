package Employee_Management_System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.BreakIterator;

public class Update_Employee extends JFrame implements ActionListener {
    JTextField teducation,tfname,taddress,tphone,tadhar,temail,tsalary,tdesignation,tgender,texper;
    JLabel temp;


    JButton add,back;
    String number;


    Update_Employee(String number){

        this.number=number;
        getContentPane().setBackground(new Color(115, 147, 179));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,25));
//        setForeground(Color.WHITE);
        add(heading);



        JLabel name = new JLabel("NAME");
        name.setBounds(50,150,150,15);
        name.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(name);

        JLabel tname= new JLabel();
        tname.setBounds(250,150,150,20);
        tname.setBackground(Color.WHITE);
        add(tname);



        JLabel fname = new JLabel("FATHER'S NAME");
        fname.setBounds(450,150,250,15);
        fname.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(fname);

        tfname= new JTextField();
        tfname.setBounds(650,150,150,20);
        tfname.setBackground(Color.WHITE);
        add(tfname);




        JLabel ano = new JLabel("ADHAAR NUMBER");
        ano.setBounds(45,200,250,15);
        ano.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(ano);

        JLabel tadhar= new JLabel();
        tadhar.setBounds(250,200,150,20);
        tadhar.setBackground(Color.WHITE);
        add(tadhar);




        JLabel gender = new JLabel("GENDER");
        gender.setBounds(450,200,250,15);
        gender.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(gender);

        JLabel tgender= new JLabel();
        tgender.setBounds(650,200,150,20);
        tgender.setBackground(Color.WHITE);
        add(tgender);




        JLabel phone = new JLabel("PHONE");
        phone.setBounds(50,250,250,15);
        phone.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(phone);

        tphone= new JTextField();
        tphone.setBounds(250,250,150,20);
        tphone.setBackground(Color.WHITE);
        add(tphone);



        JLabel email = new JLabel("EMAIL");
        email.setBounds(450,250,200,15);
        email.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(email);

        temail= new JTextField();
        temail.setBounds(650,250,150,20);
        temail.setBackground(Color.WHITE);
        add(temail);



        JLabel salary = new JLabel("SALARY");
        salary.setBounds(50,300,250,15);
        salary.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(salary);

        tsalary= new JTextField();
        tsalary.setBounds(250,300,150,20);
        tsalary.setBackground(Color.WHITE);
        add(tsalary);




        JLabel desig = new JLabel("DESIGNATION");
        desig.setBounds(450,300,250,15);
        desig.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(desig);

        tdesignation= new JTextField();
        tdesignation.setBounds(650,300,150,20);
        tdesignation.setBackground(Color.WHITE);
        add(tdesignation);

        JLabel dob = new JLabel("DATE-OF-BIRTH");
        dob.setBounds(50,350,250,15);
        dob.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(dob);

       JLabel tdob= new JLabel();
       tdob.setBounds(250,350,150,20);
       tdob.setFont(new Font(Font.SERIF,Font.BOLD,20));
       add(tdob);

        JLabel exper = new JLabel("EXPERIENCE");
        exper.setBounds(450,350,250,15);
        exper.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(exper);

        texper= new JTextField();
        texper.setBounds(650,350,150,20);
        texper.setBackground(Color.WHITE);
        add(texper);


        JLabel edu = new JLabel("EDUCATION");
        edu.setBounds(50,400,150,20);
        edu.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(edu);

        teducation= new JTextField();
        teducation.setBounds(250,400,150,20);
        teducation.setBackground(Color.WHITE);
        add(teducation);




//        tedu= new JTextField();
//        tedu.setBounds(250,400,150,20);
//        tedu.setBackground(Color.WHITE);
//        add(tedu);


        JLabel empid = new JLabel("EMPLOYEE ID");
        empid.setBounds(50,450,150,20);
        empid.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(empid);

        temp= new JLabel();
        temp.setBounds(250,450,150,20);//        temp.setBackground(Color.WHITE);
        temp.setFont(new Font (Font.SERIF,Font.BOLD,20));
        temp.setForeground(Color.BLACK);

        add(temp);


        JLabel address = new JLabel("ADDRESS");
        address.setBounds(450,400,250,15);

        address.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add(address);

        taddress= new JTextField();
        taddress.setBounds(650,395,150,20);
        taddress.setBackground(Color.WHITE);
        add(taddress);
        try{
            conn c= new conn();
            String query ="SELECT * FROM employee where EMP_ID ='"+ number +"' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("NAME"));
                tfname.setText(resultSet.getString("Father_NAME"));
                tdob.setText(resultSet.getString("DOB"));
                taddress.setText(resultSet.getString("ADDRESS"));
                tsalary.setText(resultSet.getString("SALARY"));
                tphone.setText(resultSet.getString("PHONE"));
                temail.setText(resultSet.getString("EMAIL"));
                teducation.setText(resultSet.getString("EDUCATION"));
                tadhar.setText(resultSet.getString("ADHAAR"));
                temp.setText(resultSet.getString("EMP_ID"));
                tdesignation.setText(resultSet.getString("DESIGNATION"));
                texper.setText(resultSet.getString("EXPERIENCE"));
                tgender.setText(resultSet.getString("GENDER"));



            }
        }catch(Exception E){
            E.printStackTrace();
        }


        add = new JButton("UPDATE");
        add.setBounds(300,500,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(500,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);





        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==add){
            String Father_NAME= tfname.getText();
            String SALARY=tsalary.getText();
            String ADDRESS = taddress.getText();
            String PHONE = tphone.getText();
            String EMAIL= temail.getText();
            String EDUCATION =teducation.getText();
            String EXPERIENCE = texper.getText();
            String DESIGNATION = tdesignation.getText();


            try{
                conn c= new conn();
                String query = "UPDATE employee set FATHER_NAME = '"+tfname.getText()+"', ADDRESS='"+taddress.getText()+"', SALARY='"+tsalary.getText()+"',PHONE='"+tphone.getText()+"',EMAIL='"+temail.getText()+"',EDUCATION='"+teducation.getText()+"',EXPERIENCE='"+texper.getText()+"', DESIGNATION='"+tdesignation.getText()+"' where EMP_ID= '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"DETAILS UPDATED SUCCESSFULLY");
                setVisible(false);
                new Main_class();



            }catch(Exception E){
                E.printStackTrace();

            }

        }

        else{
            setVisible(false);
            new ViewEmployee();

        }



    }
    public static void main(String[] args) {

        new Update_Employee(" ");

    }
}
