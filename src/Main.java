import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args)
    {
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

        Label nazwaZaszyfr = new Label("Zaszyfrowany:");
        GridPane.setConstraints(nazwaZaszyfr, 0, 1);

        TextField tekstZaszyfr = new TextField();
        GridPane.setConstraints(tekstZaszyfr, 1, 1);

        Label nazwaOdszyfr = new Label("Odszyfrowany:");
        GridPane.setConstraints(nazwaOdszyfr, 0, 3);

        TextField tekstOdszyfr = new TextField();
        GridPane.setConstraints(tekstOdszyfr, 1, 3);

        //Przyciski
        Button button_szyfr = new Button("Szyfruj");
        GridPane.setConstraints(button_szyfr, 3, 0);

        button_szyfr.setOnAction(e -> {
             String txt_from = tekstSzyfr.getText();
             Szyfruj slowo=new Szyfruj(txt_from);
             String wysw=new String(slowo.szyfruj());

             tekstZaszyfr.setText(wysw);
             String txt_to=tekstZaszyfr.getText();
             tekstOdszyfr.setText(slowo.deszyfruj(slowo.szyfruj()));

        });


        Button button_deszyfr = new Button("Deszyfruj");
        GridPane.setConstraints(button_deszyfr, 3, 1);             //Pesko jest zjebany

        /*button_deszyfr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x=12;
                //System.out.pri+ntln(slowo.szyfruj());
            String txt_to=tekstZaszyfr.getText();
            slowo=new Szyfruj(txt_to);
            tekstOdszyfr.setText(slowo.deszyfruj(txt_to));
            }
        });*/

        //Dodawanie do Grid
        grid.getChildren().addAll(nazwaSzyfr, tekstSzyfr, nazwaZaszyfr, tekstZaszyfr, nazwaOdszyfr, tekstOdszyfr, button_szyfr, button_deszyfr);


        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

/*
    private void deszyfruj(String klucz){

        char c[] = new char[tekstInput.length()];

        for(int i=0; i<klucz.length(); i++)
        {
            ascii[i]= ksor[i]^kluczyk[i];
            c[i]=(char)ascii[i];
            System.out.print(c[i]);
        }
    }*/
}