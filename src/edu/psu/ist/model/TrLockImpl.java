package edu.psu.ist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class controls the lock and the actions of all the methods.
 */

public class TrLockImpl implements IDialLock{

    private int maxTicks;
    private int s1;
    private int s2;
    private int s3;
    private int currentTick;
    private List<Turn> moves = new ArrayList<>();
    // constructor
    public TrLockImpl(int s1, int s2, int s3, int mTicks) {
        if (s1 < 0 || s2 < 0 || s3 < 0 || mTicks < 0) {
            throw new IllegalArgumentException("Secret digits cannot be negative");
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.maxTicks = mTicks + 1;
    }
    // to string method
    @Override
    public String toString(){
        return String.format("Secret digits: %s, %s, %s", this.s1, this.s2, this.s3);
    }
    // resets the lock
    @Override
    public void reset() {
        this.currentTick = 0;
        moves.clear();

    }
    // left method
    @Override
    public void left(int t) {
        if (currentTick - t < 0) {
            currentTick = maxTicks + (currentTick - t);
        }
        else {
            currentTick = currentTick - t;
        }

        Turn lt = new Turn(Turn.Direction.L, currentTick);
        moves.add(lt);
    }
    // right method
    @Override
    public void right(int t) {
        currentTick = (currentTick + t) % maxTicks;
        Turn rt = new Turn(Turn.Direction.R, currentTick);
        moves.add(rt);
    }
    // gets the current tick of the lock
    @Override
    public int currentTick() {
        return this.currentTick;
    }

    /**
     *
     * @return true or false based on if the lock is opened or not.
     */
    @Override
    public boolean pull() {
        int x = 0;
        List<Turn> firstRightTurn = new ArrayList<>();
        while (x < moves.size() && moves.get(x).dir == Turn.Direction.R) {
            firstRightTurn.add(moves.get(x));
            x++;
        }

        List<Turn> secondLeftTurn = new ArrayList<>();
        while (x < moves.size() && moves.get(x).dir == Turn.Direction.L) {
            secondLeftTurn.add(moves.get(x));
            x++;
        }

        List<Turn> thirdRightTurn = new ArrayList<>();
        while (x < moves.size() && moves.get(x).dir == Turn.Direction.R) {
            thirdRightTurn.add(moves.get(x));
            x++;
        }

        if (firstRightTurn.get(firstRightTurn.size() - 1).stopDigit == s1
                && secondLeftTurn.get(secondLeftTurn.size() - 1).stopDigit == s2
                && thirdRightTurn.get(thirdRightTurn.size() - 1).stopDigit == s3) {
            return true;
        }

        if (firstRightTurn.size() + secondLeftTurn.size() + thirdRightTurn.size() != moves.size()) {
            return false; // all three lists must add up to the original length of the moves sequence
        }

        return false;
    }
}
