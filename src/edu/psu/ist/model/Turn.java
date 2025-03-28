package edu.psu.ist.model;

public final class Turn { // we mark the class "final" to preclude extension

    /** Turn direction (L=left, R=right). */
    enum Direction {L, R}

    public Direction dir;
    public int stopDigit;

    public Turn(Direction dir, int stopDigit) {
        this.dir = dir;
        this.stopDigit = stopDigit;
    }

    @Override public String toString() {
        return String.format("%s-%d", dir, stopDigit);
    }
}
