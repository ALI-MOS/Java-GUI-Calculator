package com.mycompany.guicalculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static com.mycompany.guicalculator.Validator.checkValidChars;
import static com.mycompany.guicalculator.Tokenizer.tokenize;
import static com.mycompany.guicalculator.Solver.solve;
import java.util.List;

public class GUIcalculator extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    JButton b11,b12,b13,b14,b15,b16,b17,b18,b19,b20;
    JTextArea t1;
    public GUIcalculator() {      
        this.setTitle("Console Calculator");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLUE);
        this.setForeground(Color.red);
        this.setSize(365, 490);
        this.setLayout(null);
        this.setResizable(false);
             
        
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("0");
        b11 = new JButton("+");
        b12 = new JButton("-");
        b13 = new JButton("*");
        b14 = new JButton("/");
        b15 = new JButton(".");
        b16 = new JButton("(");
        b17 = new JButton(")");
        b18 = new JButton("=");
        b19 = new JButton("Del");
        b20 = new JButton("C");
        t1 = new JTextArea();
        
        b11.setBackground(Color.lightGray);
        b12.setBackground(Color.lightGray);
        b13.setBackground(Color.lightGray);
        b14.setBackground(Color.lightGray);
        b15.setBackground(Color.lightGray);
        b16.setBackground(Color.lightGray);
        b17.setBackground(Color.lightGray);
        b18.setBackground(Color.PINK);
        b19.setBackground(Color.PINK);
        b20.setBackground(Color.PINK);
        
        b1.setFont(new Font("Arial", Font.PLAIN, 40));
        b2.setFont(new Font("Arial", Font.PLAIN, 40));
        b3.setFont(new Font("Arial", Font.PLAIN, 40));
        b4.setFont(new Font("Arial", Font.PLAIN, 40));
        b5.setFont(new Font("Arial", Font.PLAIN, 40));
        b6.setFont(new Font("Arial", Font.PLAIN, 40));
        b7.setFont(new Font("Arial", Font.PLAIN, 40));
        b8.setFont(new Font("Arial", Font.PLAIN, 40));
        b9.setFont(new Font("Arial", Font.PLAIN, 40));
        b10.setFont(new Font("Arial", Font.PLAIN, 40));       
        b11.setFont(new Font("Arial", Font.PLAIN, 40));
        b12.setFont(new Font("Arial", Font.PLAIN, 40));
        b13.setFont(new Font("Arial", Font.PLAIN, 40));
        b14.setFont(new Font("Arial", Font.PLAIN, 40));
        b15.setFont(new Font("Arial", Font.PLAIN, 40));
        b16.setFont(new Font("Arial", Font.PLAIN, 40));
        b17.setFont(new Font("Arial", Font.PLAIN, 40));
        b18.setFont(new Font("Arial", Font.PLAIN, 40));
        b19.setFont(new Font("Arial", Font.PLAIN, 40));
        b20.setFont(new Font("Arial", Font.PLAIN, 40));
        t1.setFont(new Font("Arial", Font.PLAIN, 40));
        String equ = t1.getText();
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(b10);
        this.add(b11);
        this.add(b12);
        this.add(b13);
        this.add(b14);
        this.add(b15);
        this.add(b16);
        this.add(b17);
        this.add(b18);
        this.add(b19);
        this.add(b20);  
        this.add(t1);
        
        //numbers 7 8 9
        b7.setBounds(5, 170,85,55);
        b8.setBounds(90, 170,85,55);
        b9.setBounds(175, 170,85,55);
        //plus
        b11.setBounds(260, 170,85,55);
        //numbers 4 5 6
        b4.setBounds(5, 225,85,55);        
        b5.setBounds(90, 225,85,55);
        b6.setBounds(175, 225,85,55);
        //minus
        b12.setBounds(260, 225,85,55);
        //numbers 1 2 3
        b1.setBounds(5, 280,85,55);
        b2.setBounds(90, 280,85,55);       
        b3.setBounds(175, 280,85,55);
        //mlti
        b13.setBounds(260, 280,85,55);
        //zero
        b10.setBounds(90, 335,85,55);
        //parentheses
        b16.setBounds(5, 335,85,55);
        b17.setBounds(175, 335,85,55);
        //div
        b14.setBounds(260, 335,85,55);
        //dot and equals
        b15.setBounds(5, 390,170,55);
        b18.setBounds(175, 390,170,55);
        //Del and c
        b19.setBounds(5, 115,170,55);
        b20.setBounds(175, 115,170,55);
        //text
        t1.setBounds(5, 10, 340, 80);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
    }

    public static void main(String[] args) {
        GUIcalculator guIcalculator = new GUIcalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {  
     //Equals
      if(e.getSource()==b18){
        String str = t1.getText();
        List<String> tokens = tokenize(str);
        double result = solve(tokens);
        String n = Double.toString(result);
      
        if (!checkValidChars(str)){
         t1.setText("");
        }if(checkValidChars(str)){
         tokenize(str); 
         solve(tokens);
         t1.setText(n);
        }
    
    }else if(e.getSource()==b19){     //Delete  
      String s = t1.getText();
      int p = t1.getCaretPosition();
      t1.replaceRange("", p - 1, p);
      t1.setCaretPosition(p - 1);
     
    } else if(e.getSource()==b20){        //C
        t1.setText(""); 
        
    } else if (e.getSource() == b1) {
        t1.append("1");
    } else if (e.getSource() == b2) {
        t1.append("2");
    } else if (e.getSource() == b3) {
        t1.append("3");
    } else if (e.getSource() == b4) {
        t1.append("4");
    } else if (e.getSource() == b5) {
        t1.append("5");
    } else if (e.getSource() == b6) {
        t1.append("6");
    } else if (e.getSource() == b7) {
        t1.append("7");
    } else if (e.getSource() == b8) {
        t1.append("8");
    } else if (e.getSource() == b9) {
        t1.append("9");
    } else if (e.getSource() == b10) {
        t1.append("0");
    } else if (e.getSource() == b11) {
        t1.append("+");
    } else if (e.getSource() == b12) {
        t1.append("-");
    } else if (e.getSource() == b13) {
        t1.append("*");
    } else if (e.getSource() == b14) {
        t1.append("/");
    } else if (e.getSource() == b15) {
        t1.append(".");
    } else if (e.getSource() == b16) {
        t1.append("(");
    } else if (e.getSource() == b17) {
        t1.append(")");
    }
       
     throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
