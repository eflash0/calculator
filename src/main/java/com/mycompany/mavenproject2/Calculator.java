/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
/**
 *
 * @author admin
 */
public class Calculator implements ActionListener{
    JFrame f = new JFrame();
    int numsButtons[]={0,1,2,3,4,5,6,7,8,9};
    char opButtons[]={'+','-','/','%','*','='};
    String num="";
    JTextField t = new JTextField();
    JPanel p1 = new JPanel();    
    JButton nb[] = new JButton[numsButtons.length];
    JButton ob[] = new JButton[opButtons.length];
    double n=0;
    double k;
    String s2="";

    
    public Calculator(){
        f.setTitle("Calculator");
        f.setSize(500,500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.red);
//        f.setLayout(null);
        
        p1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        for(int i=0;i<numsButtons.length;i++){
            nb[i] = new JButton(String.valueOf(numsButtons[i]));
            nb[i].setPreferredSize(new Dimension(45,45));
            nb[i].setFocusable(false);
            p1.add(nb[i]);
        }
        for(int i=0;i<opButtons.length;i++){
            ob[i] = new JButton(String.valueOf(opButtons[i]));
            ob[i].setPreferredSize(new Dimension(45,45));
            ob[i].setFocusable(false);
            ob[i].setForeground(Color.red);
            p1.add(ob[i]);
        }
        
        //t text field    
        //---------set the caret of the textfield to invisible
        Caret invisibleCaret = new DefaultCaret() {
            @Override
            public void paint(Graphics g) {
                // Do nothing to make it invisible
            }
        };
        invisibleCaret.setVisible(false);
        // Set the custom caret to the text field
        t.setCaret(invisibleCaret);
        t.setForeground(Color.white);
        t.setHorizontalAlignment(JTextField.CENTER);
        t.setPreferredSize(new Dimension(50,100));
        t.setFont(new Font("Arial",Font.BOLD,20));
        t.setBackground(new Color(0x2e3c73));
        
        //p1
        p1.setFont(new Font("Arial",Font.BOLD,10));
        p1.setPreferredSize(new Dimension(200,200));
        p1.setBounds(20,20,100,100);
        p1.setBackground(new Color(0x3e4354));
  
        for(int i=0;i<numsButtons.length;i++)
            nb[i].addActionListener(this);
        for(int i=0;i<opButtons.length;i++)
            ob[i].addActionListener(this);
        
        f.add(p1,BorderLayout.CENTER);
        f.add(t,BorderLayout.NORTH);
        f.setVisible(true);      
        

    }
    
    public static void main(String[] args){
        new Calculator();
    }
    
//    public void actionPerformed(ActionEvent e){
//        t.setText("fpok");
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o instanceof JButton){
            JButton b = (JButton) o;
            String s = "0123456789";
            
//            String num="";
            String s1 = b.getText();
            if(s.contains(s1)){
                num += s1;
                t.setText(num);
            }
            
            else{
                if(num.equals(""))
                    k=0;
                else{
                    k=Integer.parseInt(num);
                    num="";
                    System.out.println(k);
                }
                if(!s2.equals("")){
                    if (s2.equals("+")) {
                        t.setText("");
                        n += k;
                        System.out.println(n);
                    } else if (s2.equals("-")) {
                        n -= k;
                        t.setText("");
                    } else if (s2.equals("*")) {
                        n *= k;
                        t.setText("");
                    } else if (s2.equals("/")) {
                        try{
                            n /= k;
                        }
                        catch(ArithmeticException ex){System.out.print("cannot devide by 0");}
                    } else if (s2.equals("%")) {
                        n %= k;
                        t.setText("");
                    } 
                    s2=s1;
                }    
                else{
                    s2=s1;
                    n=k;
                    t.setText("");
                }
                    
//                switch(s){
//                    case "+":
//                        t.setText("");
//                        n += k;
////                        t.setText("");
//                        break;
//                    case "-":
//                        n -= k;
//                        t.setText("");
//                        break;
//                    case "*":
//                        n *= k;
//                        t.setText("");
//                        break;
//                    case "/":
//                        n /= k;
//                        break;
//                    case "%":
//                        n %= k;
//                        t.setText("");
//                        break;
//                    case "=":
//                        t.setText(String.valueOf(n));
//                        break;    
//                    default: break;    
//                }
                  
            }
            if (s1.equals("=")) {
                t.setText(String.valueOf(n));
            }
        }
    }    
}
