package es.vallecidacos.dam2interfacescooperacion2526.guillermo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;

public class HelloApplication extends Application {

    private Label messageLabel = new Label();
    private VBox listaLugaresVBox = new VBox(10);
    private Lugar[] lugares = new Lugar[0]; // Array inicial vacío

    @Override
    public void start(Stage stage) {

        // Layout principal
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        // Título
        Label title = new Label("Registrar Lugar");
        title.setFont(new Font("Arial", 24));

        // GridPane para campos
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre del lugar");

        Label paisLabel = new Label("País:");
        TextField paisField = new TextField();
        paisField.setPromptText("País del lugar");

        grid.add(nombreLabel, 0, 0);
        grid.add(nombreField, 1, 0);
        grid.add(paisLabel, 0, 1);
        grid.add(paisField, 1, 1);

        // Botón Guardar
        Button guardarButton = new Button("Guardar Lugar");

        // Mensaje de estado
        messageLabel.setText("");
        messageLabel.setTextFill(Color.RED);

        // VBox para la lista de tarjetas
        listaLugaresVBox.setPadding(new Insets(10));
        listaLugaresVBox.setAlignment(Pos.TOP_LEFT);

        // Acción botón guardar
        guardarButton.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            String pais = paisField.getText().trim();

            if (nombre.isEmpty() || pais.isEmpty()) {
                showMessage("Rellena todos los campos", Color.RED);
                return;
            }

            Lugar nuevo = new Lugar(nombre, pais);
            // Añadir al array usando Arrays.copyOf
            lugares = Arrays.copyOf(lugares, lugares.length + 1);
            lugares[lugares.length - 1] = nuevo;

            // Actualizar interfaz
            actualizarLista();

            showMessage("Lugar añadido correctamente", Color.GREEN);
            nombreField.clear();
            paisField.clear();
        });

        // Separador entre formulario y lista
        Separator separator = new Separator();

        // Agregar todo al root
        root.getChildren().addAll(title, grid, guardarButton, messageLabel, separator, listaLugaresVBox);

        // Configurar escena y stage
        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Gestión de Lugares");
        stage.setScene(scene);
        stage.show();
    }

    // Método para actualizar la lista de tarjetas
    private void actualizarLista() {
        listaLugaresVBox.getChildren().clear();
        for (Lugar l : lugares) {
            VBox tarjeta = new VBox(4);
            tarjeta.setPadding(new Insets(8));
            tarjeta.setStyle("-fx-background-color: white; -fx-border-color: #888; -fx-border-radius: 6; -fx-background-radius: 6;");

            Label lblNombre = new Label("Nombre: " + l.nombre);
            lblNombre.setFont(new Font(14));
            Label lblPais = new Label("País: " + l.pais);
            lblPais.setFont(new Font(12));
            lblPais.setTextFill(Color.DARKGRAY);

            tarjeta.getChildren().addAll(lblNombre, lblPais);
            listaLugaresVBox.getChildren().add(tarjeta);
        }
    }

    // Método auxiliar para mostrar mensaje
    private void showMessage(String mensaje, Color color) {
        messageLabel.setTextFill(color);
        messageLabel.setText(mensaje);
    }

    // Clase interna Lugar
    private static class Lugar {
        String nombre;
        String pais;

        Lugar(String nombre, String pais) {
            this.nombre = nombre;
            this.pais = pais;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

