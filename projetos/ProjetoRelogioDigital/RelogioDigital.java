import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelogioDigital extends Application {
    final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    public void start(Stage palco) {
        Label rotuloTempo = new Label();
        rotuloTempo.setStyle("-fx-font-size: 24pt; -fx-text-fill: yellow;");

        //Criação de um keyframe
        KeyFrame keyFrameAtualizado = new KeyFrame(Duration.ZERO, e -> {
            rotuloTempo.setText(LocalDateTime.now().format(FORMATADOR));
        });

        KeyFrame keyFrameIntervalo = new KeyFrame(Duration.seconds(1));

        Timeline relogio = new Timeline();
        relogio.getKeyFrames().addAll(keyFrameAtualizado, keyFrameIntervalo);


        relogio.setCycleCount(Animation.INDEFINITE);
        relogio.play();

        VBox VBoxLayout = new VBox(rotuloTempo);
        VBoxLayout.setAlignment(Pos.CENTER);
        VBoxLayout.setStyle("-fx-background-color: black;");

        Scene cena = new Scene(VBoxLayout, 210, 100);

        palco.setTitle("Relogio Digital");
        palco.setScene(cena);
        palco.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}