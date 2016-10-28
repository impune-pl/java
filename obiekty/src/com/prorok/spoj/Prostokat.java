package com.prorok.spoj;

/**
 * Created by mail-_000 on 2016-10-28.
 */
public class Prostokat
{
    Punkt[] rogi = new Punkt[4];
    public Prostokat(Punkt[] punkty)
    {
        if(punkty[0].compareTo(punkty[1])==10 && punkty[0].compareTo(punkty[2])==1 && punkty[1].compareTo(punkty[3])==1 && punkty[2].compareTo(punkty[3])==10)
        {
            int x=0;
            for(Punkt a : punkty)
            {
                rogi[x]=a;
                x++;
            }
        }
    }
    public void drawProstokat ()
    {
        int w=rogi[0].getWidth()-rogi[1].getWidth();
        int h=rogi[0].getHeight()-rogi[2].getHeight();
        if(h<0)h*=-1;
        if(w<0)w*=-1;
        if(w>=2)
        {
            String a="+";
            for (int x = 2; x<=w;x++)
            {
                a+="-";
            }
            System.out.println(a+"+");
            String b="";
            if(h>=2)
            {
                for (int x = 2; x < h; x++)
                {
                    b += "|";
                    for (int y = 0; y < w - 1; y++) b += " ";
                    b += "|\n";
                }
                System.out.print(b);
                System.out.println(a+"+");
            }
            else System.out.print("Ten prostokąt jest za mały");
        }
        else System.out.print("Ten prostokąt jest za mały");
    }
}
