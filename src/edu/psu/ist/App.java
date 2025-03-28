package edu.psu.ist;

import edu.psu.ist.controller.LockAppController;
import edu.psu.ist.model.IDialLock;
import edu.psu.ist.model.TrLockImpl;
import edu.psu.ist.view.LockAppView;

/**
 * This program runs a lock through a user interface. Simply click the right button until
 * you get to the firs secret number, then click left until you get to the second secret number.
 * Finally, click right again to go to the third secret number. When you are ready to unlock the
 * lock click the pull button and you will find out if you entered the correct combination.
 */

public class App {
    // main method
    public static void main(String[] args) {
        IDialLock model = new TrLockImpl(3, 1, 5, 7);
        LockAppView view = new LockAppView();

        LockAppController controller = new LockAppController(view, model);
        view.setVisible(true);
    }

}
