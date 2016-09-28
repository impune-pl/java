package com.prorok.spoj;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Podaj numer zadania");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        switch (x)
        {
            case 1:
                new z1_1();
                break;
            case 2:
                new z1_2();
                break;
            case 3:
                if(args.length==3)
                {
                    new z1_3(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
                }
                break;
        }
    }
}
