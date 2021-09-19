package ar.edu.unsl.utils;

public class Pair<A, B> {
    protected A a;
    protected B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + this.a.toString() + "," + this.b.toString() + ")";
    }
}
