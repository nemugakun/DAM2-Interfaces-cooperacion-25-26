package es.vallecidacos.dam2interfacescooperacion2526;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class listarUsuarios extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        VBox topLeftBox = new VBox(5);
        topLeftBox.setPadding(new Insets(10));
        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();//La manera correcta no es usando TextArea?
        Label apellidoLabel = new Label("Apellido:");
        TextField apellidoField = new TextField();
        topLeftBox.getChildren().addAll(nombreLabel, nombreField, apellidoLabel, apellidoField);

        Button topRightButton = new Button("Buscar Usuario");

        BorderPane topPane = new BorderPane();
        topPane.setLeft(topLeftBox);
        topPane.setRight(topRightButton);
        topPane.setPadding(new Insets(5));

        VBox vBoxCenter = new VBox(10);
        vBoxCenter.setPadding(new Insets(10));
        vBoxCenter.setAlignment(Pos.CENTER_LEFT);
        Label passLabel = new Label("Contraseña:");
        TextField passField = new TextField();
        Label correoLabel = new Label("Correo:");
        TextField correoField = new TextField();
        Label direccionLabel = new Label("Dirección:");
        TextField direccionField = new TextField();
        Label telefonoLabel = new Label("Teléfono:");
        TextField telefonoField = new TextField();
        vBoxCenter.getChildren().addAll(passLabel, passField, correoLabel, correoField, direccionLabel, direccionField, telefonoLabel, telefonoField);

        Button bottomLeftButton = new Button("Anterior Usuario");
        Button bottomRightButton = new Button("Siguiente Usuario");
        HBox bottomBox = new HBox(5, bottomLeftButton, bottomRightButton);
        bottomBox.setPadding(new Insets(5));

        root.setTop(topPane);
        root.setCenter(vBoxCenter);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Listar Usuarios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
