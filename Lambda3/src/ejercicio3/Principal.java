package ejercicio3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal extends Application {

    private boolean detenerTiempo = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Mostrar Fecha y Hora");

        Label lblResultado = new Label();
        actualizarFechaYHora(lblResultado);

        Button btnDetener = new Button("Detener Tiempo");
        btnDetener.setOnAction(e -> detenerTiempo());

        StackPane root = new StackPane();
        root.getChildren().addAll(lblResultado, btnDetener);
        StackPane.setMargin(lblResultado, new Insets(10, 0, 50, 0));
        StackPane.setMargin(btnDetener, new Insets(10, 0, 0, 0));

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();

        // Iniciar un temporizador para actualizar la fecha y la hora cada segundo
        AnimationTimer timer = new AnimationTimer() {
            long ultimoTiempo = 0;

            @Override
            public void handle(long ahora) {
                if (!detenerTiempo && (ahora - ultimoTiempo) >= 1_000_000_000) {
                    actualizarFechaYHora(lblResultado);
                    ultimoTiempo = ahora;
                }
            }
        };
        timer.start();
    }

    private void actualizarFechaYHora(Label label) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("EEE HH:mm 'del' dd 'de' MMMM 'del' yyyy");
        String fechaActual = formatoFecha.format(new Date());

        label.setText("Fecha y Hora actual: " + fechaActual);
    }

    private void detenerTiempo() {
        detenerTiempo = true;
    }
}
