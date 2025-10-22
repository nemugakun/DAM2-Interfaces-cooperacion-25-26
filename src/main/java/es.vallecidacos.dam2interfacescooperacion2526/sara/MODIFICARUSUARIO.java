package es.vallecidacos.dam2interfacescooperacion2526.sara;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MODIFICARUSUARIO extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField nombreField = new TextField();
        TextField apellidosField = new TextField();
        TextField correoField = new TextField();
        PasswordField contraseñaField = new PasswordField();
        TextField direccionField = new TextField();
        TextField telefonoField = new TextField();

        Button btnGuardar = new Button("Actualizar");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Nombre:"), 0, 1);
        grid.add(nombreField, 1, 1);

        grid.add(new Label("Apellidos:"), 0, 2);
        grid.add(apellidosField, 1, 2);

        grid.add(new Label("Correo electrónico:"), 0, 3);
        grid.add(correoField, 1, 3);

        grid.add(new Label("Contraseña:"), 0, 4);
        grid.add(contraseñaField, 1, 4);

        grid.add(new Label("Dirección:"), 0, 5);
        grid.add(direccionField, 1, 5);

        grid.add(new Label("Teléfono:"), 0, 6);
        grid.add(telefonoField, 1, 6);

        grid.add(btnGuardar, 1, 7);

        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Modificar Usuario");
        stage.setScene(scene);
        stage.show();

    }
}
