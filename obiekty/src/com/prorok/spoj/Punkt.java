package com.prorok.spoj;
import java.util.Scanner;

class Punkt implements Comparable<Punkt>
{
    private int height;
    private int width;
    Punkt()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj wysokość punktu:");
        height=in.nextInt();
        System.out.println("Podaj szerokość punktu:");
        width=in.nextInt();
    }
    public Punkt(int h, int w)
    {
        width = w;
        height = h;
    }
    int getHeight()
    {
        return height;
    }
    int getWidth()
    {
        return width;
    }
    public int compareTo(Punkt other)
    {
        if(other.getHeight()==height && other.getWidth()==width)return 0;
        else if(other.getHeight()==height && other.getWidth()>width)return 10;
        else if(other.getHeight()==height && other.getWidth()<width)return 10;
        else if(other.getHeight()>height && other.getWidth()==width)return 1;
        else if(other.getHeight()<height && other.getWidth()==width)return 1;
        else if(other.getHeight()>height && other.getWidth()>width || other.getHeight()>height && other.getWidth()<width || other.getHeight()<height && other.getWidth()>width || other.getHeight()<height && other.getWidth()<width)return 2;
        else return 100;
    }
}
