package es.vallecidacos.dam2interfacescooperacion2526.jorge;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AnadirProducto extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Añadir Producto");


        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label cantidadLabel = new Label("Cantidad:");
        TextField cantidadField = new TextField();

        Label precioLabel = new Label("Precio:");
        TextField precioField = new TextField();

        Label tipoLabel = new Label("Tipo:");
        ComboBox<String> tipoCombo = new ComboBox<>();
        tipoCombo.getItems().addAll("Hortalizas", "Frutas", "Legumbres", "Hierbas aromáticas", "Tubérculos");


        Button guardarButton = new Button("Guardar");


        guardarButton.setOnAction(e -> {
            String nombre = nombreField.getText();
            String cantidad = cantidadField.getText();
            String precio = precioField.getText();
            String tipo = tipoCombo.getValue();


            System.out.println("Producto añadido:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio: " + precio);
            System.out.println("Tipo: " + tipo);
        });


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nombreLabel, 0, 0);
        grid.add(nombreField, 1, 0);
        grid.add(cantidadLabel, 0, 1);
        grid.add(cantidadField, 1, 1);
        grid.add(precioLabel, 0, 2);
        grid.add(precioField, 1, 2);
        grid.add(tipoLabel, 0, 3);
        grid.add(tipoCombo, 1, 3);
        grid.add(guardarButton, 1, 4);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
