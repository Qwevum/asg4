package edu.psu.ist.view;

import javax.swing.*;

/**
 * This class is the hub for all the fields for the GUI along with the methods to get all of the fields
 */

public class LockForm {
    private JPanel myPanel;
    private JLabel lockStatusValueLabel;
    private JLabel currentTickValueLabel;
    private JButton rightButton;
    private JButton leftButton;
    private JButton pullButton;
    private JButton resetButton;
    // get panel method
    public JPanel getMyPanel() {
        return myPanel;
    }
    // get lock status value label method
    public JLabel getLockStatusValueLabel() {
        return lockStatusValueLabel;
    }
    // get current tick value label
    public JLabel getCurrentTickValueLabel() {
        return currentTickValueLabel;
    }
    // get right button label
    public JButton getRightButton() {
        return rightButton;
    }
    // get left button method
    public JButton getLeftButton() {
        return leftButton;
    }
    // get pull button label
    public JButton getPullButton() {
        return pullButton;
    }
    //get reset button method
    public JButton getResetButton() {
        return resetButton;
    }
}
