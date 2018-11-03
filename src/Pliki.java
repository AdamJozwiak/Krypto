import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pliki {

    public String readFile(String pathFile) {
        String evr = new String();
        String error = new String();
        Path sciezka = Paths.get(pathFile);

        try {
            byte[] tab = Files.readAllBytes(sciezka);
            evr = new String(tab, "UTF-8");
        } catch (FileNotFoundException var5) {
            error = "Błąd";
            return error;
        } catch (IOException var6) {
            error = "Nie podałeś ścieżki";
            return error;
        }

        return evr;
    }
}