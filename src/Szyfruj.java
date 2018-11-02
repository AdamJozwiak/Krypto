import java.util.Random;
public class Szyfruj {

    private byte[] klucz;
    private String tekstJawny;

    public Szyfruj(String tekstJawny)
    {
        this.tekstJawny=tekstJawny;
        klucz=new byte[tekstJawny.length()];
    }

    public byte[] szyfr()
    {
        Random rnd = new Random();
        rnd.nextBytes(klucz);
        byte[] bytes= new byte [tekstJawny.length()];
        byte[] cipher= new byte [tekstJawny.length()];
        for(int i=0; i<tekstJawny.length();i++)
        {
            bytes[i]=(byte) tekstJawny.charAt(i);
            cipher[i]=(byte) (bytes[i]^klucz[i]);
        }

        return cipher;
    }
}