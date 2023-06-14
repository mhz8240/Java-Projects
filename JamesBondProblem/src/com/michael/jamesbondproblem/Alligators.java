package com.michael.jamesbondproblem;

public class Alligators {
    public double x;
    public double y;
    public boolean visited;
    public boolean escape;
    public boolean firstJump;
    public Alligators(double x, double y, double d) {
        this.x = x;
        this.y = y;
        this.visited = false;
        if (Math.sqrt(x*x+y*y) <= d) {
            firstJump = true;
        }
        if (Math.abs(x) > 10 - d || Math.abs(y) > 10 - d) {
            escape = true;
        }
    }
}
