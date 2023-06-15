package com.michael.jamesbondproblem;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static PrintWriter pw;
    static int alligators;
    static double jump;
    public static void main(String[] args) throws IOException {
	// write your code here
        br = new BufferedReader(new FileReader("input.txt"));
        pw = new PrintWriter(new FileWriter("output.txt"));
        alligators = Integer.parseInt(br.readLine());
        jump = Double.parseDouble(br.readLine());
        Alligators[] al = new Alligators[alligators];
        for (int i = 0; i < alligators; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Double x = Double.parseDouble(st.nextToken());
            Double y = Double.parseDouble(st.nextToken());
            al[i] = new Alligators(x,y, jump);
        }
        Queue<Alligators> queue = new LinkedList<>();
        for (Alligators alligator : al) {
            if (alligator.firstJump) {
                queue.add(alligator);
                alligator.visited = true;
            }
        }
        boolean escape = false;
        while (!queue.isEmpty()) {
            Alligators a = queue.poll();
            if (a.escape) {
                escape = true;
                break;
            }
            for (Alligators alligator : al) {
                if (alligator.visited == false && distance(a, alligator) == true) {
                    queue.add(alligator);
                    alligator.visited = true;
                }
            }
        }
        System.out.println(escape);
    }
    public static boolean distance(Alligators al1, Alligators al2) {
        if (Math.sqrt(Math.pow(al1.x - al2.x, 2) + Math.pow(al1.y - al2.y, 2)) <= jump) {
            return true;
        }
        return false;
    }
}
