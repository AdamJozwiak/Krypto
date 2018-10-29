package com.company;

import java.awt.*;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {


    public static class Okno extends JFrame     //Stworzenie okna
    {
        public Okno(){
            super("Szyfrowanie One Time Pad");          //Tytuł okna

            JPanel przycisk = new Przycisk();       //Dodaje nasze przyciski do okna
            add(przycisk);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Żeby 'x' mogło zamykać okno
            setSize(300,100);       //Rozmiar okna
            setLocation(850,400);     //Położenie okna

            setVisible(true);
        }
    }

    public static class Przycisk extends JPanel implements ActionListener{
        private JButton szyfr;
        private JButton deszyfr;

        public Przycisk(){
            szyfr = new JButton("Szyfruj");     //Deklarujemy przyciski
            deszyfr = new JButton("Deszyfruj");

            szyfr.addActionListener(this);      //Ustawia słuchacza, czyli jeśli przycisk 'szyfr'
            deszyfr.addActionListener(this);    //zostanie naciśnięty, to słuchacz rejestruje ten fakt

            setLayout(new GridLayout());       //Sposób wyświetlania przycisków
            add(szyfr);                         //Tworzymy przyciski
            add(deszyfr);
        }


        @Override
        public void actionPerformed(ActionEvent p)
        {
            Object source = p.getSource();      //program wie jakie jest źródło,
                                                //bo słuchacz ma te informacje

            if(source == szyfr) {

                //Pobiera dane z pól tekstowych i SZYFRUJE





            }
            if(source == deszyfr){


                //DESZYFRUJE



            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Podaj tekst jawny ");
        Scanner wpisz = new Scanner(System.in);

        String tekst;
        tekst = wpisz.nextLine();


        System.out.println("Podaj klucz: ");

        String klucz=wpisz.nextLine();

        int ascii[]=new int [tekst.length()];
        int kluczyk[]=new int [klucz.length()];
        int ksor[]=new int [klucz.length()];
        char c[]=new char [tekst.length()];
        for(int i=0; i<klucz.length(); i++)
        {
            ascii[i] = tekst.charAt(i);
            kluczyk[i] = klucz.charAt(i);
            ksor[i]= ascii[i]^kluczyk[i];
            System.out.print(ksor[i]);
        }
        System.out.println();
        for(int i=0; i<klucz.length(); i++)
        {
            ascii[i]= ksor[i]^kluczyk[i];
            c[i]=(char)ascii[i];
            System.out.print(c[i]);
        }

        EventQueue.invokeLater(new Runnable() {  //Klasa uruchamiająca program
            @Override
            public void run() {
                new Okno();
            }
        });
    }
}
