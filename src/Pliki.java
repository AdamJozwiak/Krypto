import java.io.*;
import java.nio.file.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pliki {

    public byte[] readFile (String pathFile)
    {
        File file = new File(pathFile);
        byte[] fileContent = new byte[(int) file.length()];
        FileInputStream fin;
        try{
            fin = new FileInputStream(file);
            fin.read(fileContent);
        }catch (FileNotFoundException e){
            System.out.print("Błąd, nie znaleziono pliku");
        }
        catch (IOException e){
            System.out.print("Błąd odczytu pliku");
        }

        return fileContent;
    }
    public void writeFile(String pathfile, byte[] cipher) throws IOException{
        Path path = Paths.get(pathfile);
        Files.write(path, cipher);
    }
}