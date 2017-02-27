package javaapplication1;

//import java.io.IOException;
//import java.util.Scanner;
//import java.nio.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Collections;
import java.util.*;
public class JavaApplication1 {
    public static void main(String[] args) 
    {
//        Charset utf = StandardCharsets.UTF_8;
//        try
//        {
//        List<String> fContents = Files.readAllLines(Paths.get("C:\\java\\NetBeansProjects\\JavaApplication1\\dist\\new.txt"),utf);
//        String[] fContent = fContents.toArray(new String[fContents.size()]);
//        int a=0;
//        for(String x : fContent)
//        {
//            if(!x.equals(""))
//            {
//                Files.write(Paths.get("C:\\java\\NetBeansProjects\\JavaApplication1\\dist\\"+a+".txt"), x.getBytes(), StandardOpenOption.CREATE);
//                a++;
//            }
//        }
//       }
//       catch(IOException ex)
//       {
//           ex.printStackTrace();
//       }
        Scanner in = new Scanner(System.in);
        //Na system binarny
        /*
        int a = in.nextInt();
        String a2 = "";
        while(a>=1)
        {
            a2 = (a%2) + a2;
            if(a==1)break;
            a /= 2;
        }
        System.out.println(a2);
        */
        //Z systemu binarnego -- przkomplikowana, używać Integer.getInteger(STRING, L.SYSTEMU (dla binarnego == 2 ))
        /*String x = in.next();
        int a = 0;
        char[] n = x.toCharArray();
        int i = x.length()-1;
        for(char z: n)
        {
            if(z == '1')
            {
                a+= dwaDoPot(i);
            }
            i--;
        }
        System.out.println(a);
    }
    public static int dwaDoPot(int pot)
    {
        int x=1;
        while(pot>0)
        {
            x*=2;
            pot--;
        }
        return x;
    }*/
        
    }
}
