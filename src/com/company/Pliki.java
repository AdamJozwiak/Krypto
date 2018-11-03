package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pliki {
   public String readFile (String pathFile)
    {
        String evr= new String();
        Path sciezka = Paths.get(pathFile);
        try{
        byte[] tab = Files.readAllBytes(sciezka);
        evr = new String(tab,"UTF-8");
        }catch (FileNotFoundException e){
            System.out.print("blad kurwa");
        }
        catch (IOException e){
            System.out.print("tez chujowo");
        }
        return evr;
    }
}
