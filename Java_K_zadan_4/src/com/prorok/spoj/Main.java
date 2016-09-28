package com.prorok.spoj;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        System.out.println("Podaj numer zadania");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        switch (x)
        {
            case 1:
                new z1();
                break;
            case 2:
                new z2();
                break;
            case 3:
                new z3();
                break;
            case 4:
                new z4();
                break;
            case 5:
                new z5();
                break;
            default: System.out.println("error");
        }
    }
}
