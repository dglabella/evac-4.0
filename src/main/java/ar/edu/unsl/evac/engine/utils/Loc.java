package ar.edu.unsl.evac.engine.utils;

import java.io.Serializable;

public class Loc {

    private int i;
    private int j;

    public Loc(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return this.j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
