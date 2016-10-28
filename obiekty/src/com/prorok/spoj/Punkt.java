package com.prorok.spoj;
import java.util.Scanner;
/**
 * Created by mail-_000 on 2016-10-28.
 */
public class Punkt implements Comparable<Punkt>
{
    private int height;
    private int width;
    public Punkt()
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
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
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
