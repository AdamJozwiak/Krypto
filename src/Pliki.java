import java.io.*;
public class Pliki {
    public String readFile (String pathFile)
    {
        FileReader fileReader = new FileReader(pathFile);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String stringFile = "";
        while(cośtam)
        {
            stringFile+=bufferedReader.readLine();
        }
        return stringFile;
    }
}
