package es.vallecidacos.dam2interfacescooperacion2526;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {//throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        GridPane p = new GridPane();
        ContenedorDeOpciones cdoUsuarios = new ContenedorDeOpciones("Usuarios");
        ContenedorDeOpciones cdoProductos = new ContenedorDeOpciones("Productos");
        ContenedorDeOpciones cdoTrabajadores = new ContenedorDeOpciones("Trabajadores");
        VBox miscelanea = new VBox();
        Button mostrarLugares = new Button("Mostrar lugares");
        Button mostrarTodo = new Button("Mostrar todo");
        miscelanea.getChildren().add(mostrarLugares);
        miscelanea.getChildren().add(mostrarTodo);

        p.setHgap(10);
        p.setVgap(10);
        p.setPadding(new Insets(10));
        p.add(cdoUsuarios, 0,0);
        p.add(cdoProductos, 0,1);
        p.add(cdoTrabajadores, 1,0);
        p.add(miscelanea, 1,1);

        Scene scene = new Scene(p);
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Cooperación DAM2");
        stage.setScene(scene);
        stage.show();
    }
}
