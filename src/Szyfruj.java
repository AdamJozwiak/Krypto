import java.util.Random;


public class Szyfruj {

    private byte[] klucz;
    private byte[] tekstJawny;

    public Szyfruj(byte[] tekstJawny)
    {
        this.tekstJawny=tekstJawny;
        klucz=new byte[this.tekstJawny.length];
        Random rnd = new Random();
        rnd.nextBytes(klucz);
    }
    public Szyfruj (byte[] klucz, byte[] tekstJawny)
    {
        this.klucz=klucz;
        this.tekstJawny=tekstJawny;
    }

    public byte[] szyfruj()
    {
        byte[] cipher = new byte [tekstJawny.length];

        for(int i=0; i<tekstJawny.length; i++)
        {
            cipher[i] = (byte) (tekstJawny[i]^klucz[i]);
        }

        return cipher;
    }

    public byte[] deszyfruj(byte[] cipher)
    {
        byte[] nocipher = new byte [cipher.length];
        for(int i=0; i<cipher.length; i++)
        {
            nocipher[i] = (byte) (cipher[i]^klucz[i]);
        }

        return nocipher;
    }
    public byte[] getKlucz()
    {
        return klucz;
    }
    public byte[] getTekstJawny()
    {
        return tekstJawny;
    }


}