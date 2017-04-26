package generatorpseudolosowy;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class GeneratorPseudolosowy 
{
    public static void main(String[] args)  throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.print("proszę podać nazwę pliku: ");
        String nazwa = in.nextLine();
        System.out.print("proszę podać ilość liczb do wylosowania: ");
        int ile = in.nextInt();
        System.out.print("proszę podać maksymalną wartość wylosowaną: ");
        int max = in.nextInt();
        System.out.print("proszę podać minimalną wartość wylosowaną: ");
        int min = in.nextInt();
        Path output = Paths.get(".\\"+nazwa+".txt");
        Random generator = new Random();
        String wynik="";
        for(int i=0; i<ile; i++)
        {
            int tymczasowy=0;
            while(true)
            {
                tymczasowy= generator.nextInt(max);
                if(tymczasowy<min)continue;
                else break;
            }
            wynik += tymczasowy +System.getProperty("line.separator");
        }
        Files.write(output, wynik.getBytes(), StandardOpenOption.CREATE);
    }
}
