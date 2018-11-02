import java.util.Random;
import javafx.scene.control.TextField;
public class Szyfruj {

    private byte[] klucz;
    private String tekstJawny;

    public Szyfruj(String tekstJawny)
    {
        this.tekstJawny=tekstJawny;
        klucz=new byte[tekstJawny.length()];
        Random rnd = new Random();
        rnd.nextBytes(klucz);
    }

    public String szyfr()
    {
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

    public String deszyfruj(String result)
    {
        String txt_po;
        byte[] bytes= new byte [result.length()];
        byte[] cipher= new byte [result.length()];
        for(int i=0; i<result.length(); i++)
        {
            bytes[i]=(byte) result.charAt(i);
            cipher[i]=(byte) (klucz[i]^bytes[i]);
        }
        txt_po = new String(cipher);

        return txt_po;
    }
}