import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CalculadoraIMC extends Application {

    @Override
    public void start(Stage palco){
        // Etiquetas para os campos de entrada
        Label etiquetaPeso = new Label("Peso");
        Label etiquetaAltura = new Label("Altura");

        //Campos de texto para entrada de dados
        TextField campoPeso = new TextField();
        campoPeso.setPromptText("Peso em kg");
        TextField campoAltura = new TextField();
        campoAltura.setPromptText("Altura em metros");

        // mostra o resultado da calculadora
        Label etiquetaResultado = new Label();

        Button botaoCalcular = new Button("Calcular IMC");
        botaoCalcular.setOnAction(e -> {

            //transforma string em double
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());

            double imc = peso / (altura * altura);
            etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
        });

        //layout vertical
        VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura,
                botaoCalcular, etiquetaResultado);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        //Cena e Palco
        Scene cena = new Scene(layout, 300, 250);
        palco.setTitle("Calculadora de IMC");
        palco.setScene(cena);
        palco.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}