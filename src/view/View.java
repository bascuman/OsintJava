package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;
import model.*;

public class View extends JFrame implements ActionListener {
    private  Controller controller;
    private  Model model;
    private  JButton submitButton;
    private  JTextField usernameField;
    private  JTextArea outputArea;
    private JLabel title;


    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextArea getOutputArea() {
        return outputArea;
    }


    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        this.controller.setView(this);
        this.submitButton = new JButton("Submit");
        this.submitButton.addActionListener(this);
        this.usernameField = new JTextField(20);
        usernameField.setToolTipText("username here");
        this.outputArea = new JTextArea(10, 40);
        this.outputArea.setEditable(false);
        createWindow();
    }

    private void createWindow() {
        setTitle("Java Osint");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/resources/35885.jpg");
        setIconImage(icon.getImage());
        setPreferredSize(new Dimension(700, 700));
        setContentPane(createMainPanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        mainPanel.add(createUserPanel(), BorderLayout.NORTH);
        mainPanel.add(createOutputPanel(), BorderLayout.SOUTH);

        return mainPanel;
    }
    private JPanel createUserPanel() {
        JPanel userPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        userPanel.add(usernameField);
        userPanel.add(submitButton);
        return userPanel;
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputArea.setRows(30);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        return outputPanel;
    }

    public void appendOutputText(String text) {
        outputArea.setText(text);
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            appendOutputText("");
            new Thread(model).start();
        }
    }

}
