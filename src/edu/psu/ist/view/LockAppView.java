package edu.psu.ist.view;

import javax.swing.*;
import java.awt.*;

public class LockAppView extends JFrame {

    private LockForm form;
    // lock app view constructor
    public LockAppView (){
        this.form = new LockForm();
        JPanel content = form.getMyPanel();
        this.setContentPane(content);
        this.setPreferredSize(new Dimension(300, 300));
        this.pack();

        this.setTitle("Lock Dial App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // form method
    public LockForm form(){
        return form;
    }

}
