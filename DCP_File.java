import java.io.*;
import java.lang.Exception;
public class DCP_File {
    public static void main(String args[]) throws IOException
    {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int character=Integer.valueOf(sc.readLine());
        try{
        FileReader fread=new FileReader("sample.txt");
        int i;
        while(character!=0 && (i=fread.read())!=-1)
        {
            System.out.print((char)i);
            --character;
        }
        fread.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }
    }
}