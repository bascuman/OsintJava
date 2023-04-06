package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import controller.*;
import model.*;

public class View extends JFrame implements ActionListener{
    //Clase que sirve de vista para el proyecto
    Controller c;
    Model model;
    JButton button;
    JTextArea textArea;

    Thread thread;

    public JTextArea getOutArea() {
        return outArea;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    JTextArea outArea;

    public View(Controller c, Model model){
        this.model = model;
        this.c = c;
        c.setView(this);

        CrearMiventana();


    }
    public void CrearMiventana(){
        setTitle("Java Osint");
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));
        Componentes();
        getContentPane().setBackground(Color.cyan);
        this.setVisible(true);

    }
    public void Componentes(){
        JPanel user = new JPanel();
        JPanel show = new JPanel();

        show.setLayout(new BorderLayout());
        button = new JButton("Submit");
        button.addActionListener(this);

        user.add(button,BorderLayout.CENTER);
        textArea = new JTextArea("username here",1,5);
        outArea = new JTextArea(10,40);
        user.add(textArea,BorderLayout.SOUTH);
        user.add(outArea,BorderLayout.SOUTH);
        show.add(user);

        this.getContentPane().add(show);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            getOutArea().setText("");
           new Thread(model).start();


        }
    }


}
