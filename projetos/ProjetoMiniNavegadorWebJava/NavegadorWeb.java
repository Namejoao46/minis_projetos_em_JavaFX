//javac --module-path "C:\Program Files\Java\openjfx-22.0.1_windows-x64_bin-sdk\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.web NavegadorWeb.java

import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NavegadorWeb extends Application{

    @Override
    public void start(Stage palco){
        TextField url = new TextField();
        WebView navegador = new WebView();
        WebEngine motor = navegador.getEngine();

        //carregar uma pag web ao usuario precionar enter
        url.setOnAction(evento -> motor.load(formataUrl(url.getText())));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(url, navegador);
        Scene cena = new Scene(vbox);

        palco.setTitle("Meu Browser java");
        palco.setScene(cena);
        palco.show();
    }
    public static void main(String[] args){
        launch(args);
    }

    public String formataUrl (String url){
        if (!url.startsWith("http://") && !url.startsWith("http://")) {
            url = "http://" + url;
        }
        return url;
    }
}