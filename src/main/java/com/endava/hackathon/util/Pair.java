package com.endava.hackathon.util;

public class Pair<L extends Comparable<L>, R> implements Comparable<Pair> {
    private L left;
    private R right;

    public Pair() {
    }

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public void setLeft(L left) {
        this.left = left;
    }

    public R getRight() {
        return right;
    }

    public void setRight(R right) {
        this.right = right;
    }

    @Override
    public int compareTo(Pair o) {
        if (o == null || o.left == null)
            return 1;

        return left == null ? -1 : o.left.compareTo(left);
    }
}
