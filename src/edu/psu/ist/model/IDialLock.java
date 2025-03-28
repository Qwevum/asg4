package edu.psu.ist.model;

/**
 * This is a simple interface that contains the methods in order for the lock to work.
 * See @Class TrLockImpl
 */

public interface IDialLock {

    void reset();

    void left(int t);

    void right(int t);

    int currentTick();

    boolean pull();

}
