import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("One Time Pad");

        //Ustawianie parametrów Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(5);

        //Tworzenie pól w Grid
        Label nazwaSzyfr = new Label("Podaj szyfr:");
        GridPane.setConstraints(nazwaSzyfr, 0, 0);

        TextField tekstSzyfr = new TextField();
        tekstSzyfr.setPromptText("Twój szyfr");
        GridPane.setConstraints(tekstSzyfr, 1, 0);

        Label nazwaPlik = new Label("Podaj ścieżkę do pliku:");
        GridPane.setConstraints(nazwaPlik, 0, 1);

        TextField tekstPlik = new TextField();
        tekstSzyfr.setPromptText("Twój szyfr");
        GridPane.setConstraints(tekstPlik, 1, 1);

        Label nazwaZaszyfr = new Label("Zaszyfrowany:");
        GridPane.setConstraints(nazwaZaszyfr, 0, 2);

        TextField tekstZaszyfr = new TextField();
        GridPane.setConstraints(tekstZaszyfr, 1, 2);

        Label nazwaOdszyfr = new Label("Odszyfrowany:");
        GridPane.setConstraints(nazwaOdszyfr, 0, 3);

        TextField tekstOdszyfr = new TextField();
        GridPane.setConstraints(tekstOdszyfr, 1, 3);

        //Przyciski
        Button button_szyfr = new Button("Szyfruj");
        GridPane.setConstraints(button_szyfr, 3, 0);

        button_szyfr.setOnAction(e -> {
            String txt_from = tekstSzyfr.getText();
            byte [] byteArr = txt_from.getBytes();
            Szyfruj slowo = new Szyfruj(byteArr);
            String wyswZaszyfr = new String(slowo.szyfruj());
            String wyswOdszyfr = new String (slowo.deszyfruj(slowo.szyfruj()));
            tekstZaszyfr.setText(wyswZaszyfr);
            tekstOdszyfr.setText(wyswOdszyfr);
        });

        Button button_szyfrplik = new Button("Szyfruj z pliku");
        GridPane.setConstraints(button_szyfrplik, 3, 1);

        button_szyfrplik.setOnAction(e -> {
            String filePath = tekstPlik.getText();
            Pliki pliki = new Pliki();
            Szyfruj slowo = new Szyfruj(pliki.readFile(filePath));
            String wyswZaszyfr = new String(slowo.szyfruj());
            String wyswOdszyfr = new String (slowo.deszyfruj(slowo.szyfruj()));
            tekstZaszyfr.setText(wyswZaszyfr);
            tekstOdszyfr.setText(wyswOdszyfr);
            try {
                pliki.writeFile(pliki.pathBox("Sciezka do zapisu zaszyfrowanego pliku"), slowo.szyfruj());
                pliki.writeFile(pliki.pathBox("Sciezka do zapisu klucza"), slowo.getKlucz());
                pliki.writeFile(pliki.pathBox("Sciezka do zapisu odszyfrowanego pliku"), slowo.deszyfruj(slowo.szyfruj()));

            }
            catch (IOException el) {
                el.printStackTrace();
            }
        });

        Button button_szyfrklucz = new Button("Odszyfruj z kluczem");
        GridPane.setConstraints(button_szyfrklucz, 3, 2);

        button_szyfrklucz.setOnAction(e -> {
            String filePath = tekstPlik.getText();
            Pliki pliki = new Pliki();

                Szyfruj slowo = new Szyfruj(pliki.readFile(Pliki.pathBox("Podaj sciezkie do klucza")), pliki.readFile(filePath));

            String wyswZaszyfr = new String(slowo.getTekstJawny());
            String wyswOdszyfr = new String (slowo.deszyfruj(slowo.getTekstJawny()));
            tekstZaszyfr.setText(wyswZaszyfr);
            tekstOdszyfr.setText(wyswOdszyfr);
            try {
                pliki.writeFile(pliki.pathBox("Sciezka do zapisu odszyfrowanego pliku"), slowo.deszyfruj(slowo.getTekstJawny()));
            }
            catch (IOException el) {
                el.printStackTrace();
            }


        });

        //Dodawanie do Grid
        grid.getChildren().addAll(nazwaSzyfr, tekstSzyfr, nazwaPlik, tekstPlik, nazwaZaszyfr, tekstZaszyfr, nazwaOdszyfr, tekstOdszyfr, button_szyfr, button_szyfrplik, button_szyfrklucz);


        Scene scene = new Scene(grid, 440, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}