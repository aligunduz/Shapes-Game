/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ag
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alpalpalapalallapala
 */
public class GameScreen extends JFrame implements ActionListener {

        JFrame jf = new JFrame();

    public  GameScreen(int width, int height,String i){
       
        
        
        jf.setTitle(i);
        jf.setSize(width,height);
        jf.setLocation(100,100);
        jf.setResizable(false);
        jf.add(new Contents());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
 
    
    public static void main (String[] args){
       
        Scanner x = new Scanner(System.in);
        System.out.println("Enter width then height of gamescreen: ");
        int width = x.nextInt();
        int height = x.nextInt();
        
       GameScreen gs = new GameScreen(width,height,"selam");
       
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
   
}