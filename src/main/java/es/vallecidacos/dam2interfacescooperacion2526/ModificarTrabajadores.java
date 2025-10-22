package es.vallecidacos.dam2interfacescooperacion2526;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ModificarTrabajadores extends Application {

    @Override
    public void start(Stage stage) {
        // --- Contenedor principal del formulario ---
        VBox formulario = new VBox(12);
        formulario.setPadding(new Insets(20));
        formulario.setAlignment(Pos.TOP_CENTER);
        formulario.setStyle("-fx-background-color: #f5f5f5; -fx-border-radius: 8; -fx-background-radius: 8;");


        formulario.getChildren().addAll(
                crearCampo("Nombre:"),
                crearCampo("Apellidos:"),
                crearCampo("DNI:"),
                crearCampo("SSN:"),
                crearCampo("Fecha de nacimiento:"),
                crearCampo("Número de cuenta:"),
                crearCampo("Fecha de alta:"),
                crearCampo("Fecha de baja:")
        );


        Button editar = new Button("Editar");
        Button guardar = new Button("Guardar");
        Button cancelar = new Button("Cancelar");

        editar.setPrefWidth(100);
        guardar.setPrefWidth(100);
        cancelar.setPrefWidth(100);

        HBox botones = new HBox(15, editar, guardar, cancelar);
        botones.setAlignment(Pos.CENTER);
        botones.setPadding(new Insets(15, 0, 10, 0));


        BorderPane layout = new BorderPane();
        layout.setCenter(formulario);
        layout.setBottom(botones);
        BorderPane.setMargin(formulario, new Insets(10));


        Scene scene = new Scene(layout, 420, 520);
        stage.setTitle("Gestión de trabajadores");
        stage.setScene(scene);
        stage.setResizable(false); //Propiedad para fijar tamaño
        stage.show();
    }

    // Creo un metodo crearCampo hBox para crear los campos que luego se podran interactuar
    private HBox crearCampo(String etiqueta) {
        Label label = new Label(etiqueta);
        label.setPrefWidth(160);
        TextField campo = new TextField();
        campo.setPrefWidth(200);

        HBox fila = new HBox(10, label, campo);
        fila.setAlignment(Pos.CENTER_LEFT);
        return fila;
    }

    public static void main(String[] args) {
        launch();
    }
}
