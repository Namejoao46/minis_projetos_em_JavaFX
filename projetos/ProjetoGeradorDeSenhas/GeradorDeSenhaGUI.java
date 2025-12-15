import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class GeradorDeSenhaGUI extends Application{

    @Override
    public void start(Stage palco) {

        palco.setTitle("Gerador de senhas");

        Label labelTamanhoSenha = new Label("Tamanho da Senha");
        TextField tamanhoSenha = new TextField();

        Label labelSenhaGerada = new Label("Senha Gerada");
        TextField senhaGerada = new TextField();
        senhaGerada.setEditable(false);
        senhaGerada.setStyle("-fx-text-fill: cyan; -fx-background-color: black;");

        Button gerarSenha = new Button("Gerar Senha");
        gerarSenha.setOnAction(e -> {

            try {
                int comprimento = Integer.parseInt(tamanhoSenha.getText()); // Pego o tamanho desejado
                String senha = GeradorDeSenha.gerarSenha(comprimento); //gero a senha
                senhaGerada.setText(senha); //mostro a senha gerada para o usuario
            }catch (NumberFormatException ex){
                senhaGerada.setText("Por favor, digite Numeros validos para ser gerado");
            }

        });

        VBox vbox = new VBox(labelTamanhoSenha, tamanhoSenha, gerarSenha, labelSenhaGerada, senhaGerada);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        Scene cena = new Scene(vbox, 300, 200);
        palco.setScene(cena);
        palco.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}