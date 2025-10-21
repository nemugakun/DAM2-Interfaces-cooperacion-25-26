package es.vallecidacos.dam2interfacescooperacion2526.phaber;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class crearUsuario extends Application {


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Crear Usuario");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblNombre = new Label("Nombre:");
        TextField tfNombre = new TextField();
        grid.add(lblNombre, 0, 0);
        grid.add(tfNombre, 1, 0);

        Label lblApellidos = new Label("Apellidos:");
        TextField tfApellidos = new TextField();
        grid.add(lblApellidos, 0, 1);
        grid.add(tfApellidos, 1, 1);

        Label lblUsuario = new Label("usuario:");
        TextField tfUsuario = new TextField();
        grid.add(lblUsuario, 0, 2);
        grid.add(tfUsuario, 1, 2);

        Label lblContrasena = new Label("Contraseña:");
        PasswordField pfContrasena = new PasswordField();
        grid.add(lblContrasena, 0, 3);
        grid.add(pfContrasena, 1, 3);

        Label lblDireccion = new Label("Dirección:");
        TextField tfDireccion = new TextField();
        grid.add(lblDireccion, 0, 4);
        grid.add(tfDireccion, 1, 4);

        Label lblTelefono = new Label("Teléfono:");
        TextField tfTelefono = new TextField();
        grid.add(lblTelefono, 0, 5);
        grid.add(tfTelefono, 1, 5);


        Button btnCrear = new Button("Crear Usuario");
        grid.add(btnCrear, 1, 6);


        Scene scene = new Scene(grid, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

