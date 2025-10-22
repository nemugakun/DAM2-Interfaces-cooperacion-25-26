package es.vallecidacos.dam2interfacescooperacion2526.abderrazak;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ModificarProductos extends Parent {
    public void mostrarFormulario (Stage stage){
        // Crear los controles

        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label precioLabel = new Label("€/KG:");
        TextField precioField = new TextField();

        Label stockLabel = new Label("Stock:");
        TextField stockField = new TextField();

        Label categoriaLabel = new Label("Categoría:");
        ComboBox<String> categoriaCombo = new ComboBox<>();
        categoriaCombo.getItems().addAll("Frutas", "Verduras", "Carnes", "Lácteos", "Otros");

        Button guardarButton = new Button("Guardar");
        guardarButton.setOnAction(e -> {
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());
            String categoria = categoriaCombo.getValue();

            // Aquí podrías guardar los datos en una base de datos o mostrar un resumen
            System.out.println("Producto modificado:");
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio/kg: " + precio);
            System.out.println("Stock: " + stock);
            System.out.println("Categoría: " + categoria);
        });
        // Crear el layout
        GridPane grid = new GridPane();//
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Añadir controles al layout
        grid.add(nombreLabel, 0, 0);
        grid.add(nombreField, 1, 0);

        grid.add(precioLabel, 0, 1);
        grid.add(precioField, 1, 1);

        grid.add(stockLabel, 0, 2);
        grid.add(stockField, 1, 2);

        grid.add(categoriaLabel, 0, 3);
        grid.add(categoriaCombo, 1, 3);

        grid.add(guardarButton, 1, 4);

        // Mostrar la escena
        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Modificar Productos");
        stage.show();
    }
}
//aokjfhaiufiugwaf