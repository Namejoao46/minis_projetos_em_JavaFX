import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;

import java.io.PrintWriter;
// como se fosse o cabesalho
import javafx.scene.control.ToolBar;
// mini painel de salvamento de arquivos
import javafx.stage.FileChooser;

public class EditorDeTexto extends Application{

    @Override
    public void start(Stage palco){

        //criacão do TextArea para o editor de texto
        TextArea areaEditavel = new TextArea();

        Button salvarTexto = new Button("salvar");
        salvarTexto.setOnAction(e -> salvarTexto(areaEditavel));

        //Barra de ferramentas com buttao de salvar
        ToolBar barraDeFerramentas = new ToolBar(salvarTexto);

        //configuracão do layout principal
        BorderPane bordePane = new BorderPane();
        bordePane.setTop(barraDeFerramentas);
        bordePane.setCenter(areaEditavel);

        Scene cena = new Scene(bordePane, 800, 600);
        palco.setTitle("Editor de Texto Basico");
        palco.setScene(cena);
        palco.show();
    }

    private void salvarTexto(TextArea textArea){
        FileChooser fileChoose = new FileChooser();
        fileChoose.setTitle("Salvar Arquivo de Texto");
        File file = fileChoose.showSaveDialog(null);
        if(file != null){
            try (PrintWriter writer = new PrintWriter(file)){
                writer.println(textArea.getText());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}