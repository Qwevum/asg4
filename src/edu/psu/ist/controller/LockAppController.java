package edu.psu.ist.controller;

import edu.psu.ist.model.IDialLock;
import edu.psu.ist.view.LockAppView;

/**
 * This class controls the buttons on the interface. Each lambda expression controls each button.
 */

public class LockAppController {

    private LockAppView view;
    private IDialLock model;
    // constructor
    public LockAppController(LockAppView lockView, IDialLock lockModel) {
        this.view = lockView;
        this.model = lockModel;

        view.form().getLockStatusValueLabel().setText("Locked! " + model.toString());

        view.form().getCurrentTickValueLabel().setText(model.currentTick() + "");
        // lambda expression for left button
        view.form().getLeftButton().addActionListener(e -> {
            model.left(1);
            view.form().getCurrentTickValueLabel().setText(model.currentTick() + "");
        });
        // lambda expression for right button
        view.form().getRightButton().addActionListener(e -> {
            model.right(1);
            view.form().getCurrentTickValueLabel().setText(model.currentTick() + "");
        });
        // lambda expression for reset button
        view.form().getResetButton().addActionListener(e -> {
            model.reset();
            view.form().getCurrentTickValueLabel().setText(0 + "");
            view.form().getLockStatusValueLabel().setText("Locked! " + model.toString());
        });
        // lambda expression for pull button
        view.form().getPullButton().addActionListener(e -> {
            if (model.pull()) {
                view.form().getLockStatusValueLabel().setText("Unlocked! " + model.toString());
            }
        });
    }

}
