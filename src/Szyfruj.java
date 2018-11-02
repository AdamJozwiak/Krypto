import java.util.Random;
import javafx.scene.control.TextField;
public class Szyfruj {

    private byte[] klucz;
    private String tekstJawny;

    public Szyfruj(String tekstJawny)
    {
        this.tekstJawny=tekstJawny;
        klucz=new byte[tekstJawny.length()];
    }

    public String szyfr()
    {
        Random rnd = new Random();
        rnd.nextBytes(klucz);
        String result;
        byte[] bytes= new byte [tekstJawny.length()];
        byte[] cipher= new byte [tekstJawny.length()];
        for(int i=0; i<tekstJawny.length(); i++)
        {
            bytes[i]=(byte) tekstJawny.charAt(i);
            cipher[i]=(byte) (bytes[i]^klucz[i]);
        }
        result = new String(cipher);

        return result;
    }
}