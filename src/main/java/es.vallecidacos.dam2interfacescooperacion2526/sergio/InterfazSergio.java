package es.vallecidacos.dam2interfacescooperacion2526.sergio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InterfazSergio extends Application {
    @Override
    public void start(Stage stage) {
        StackPane SP = new StackPane();
        Scene scene = new Scene(SP, 600, 500);
        stage.setTitle("INICIO");

        VBox vBox = new VBox(15);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(20));

        double labelWidth = 100;

        HBox hboxC = new HBox(10);
        hboxC.setAlignment(Pos.CENTER_LEFT);
        Label cliente = new Label("CLIENTE");
        cliente.setMinWidth(labelWidth);
        cliente.setAlignment(Pos.CENTER_LEFT);
        ComboBox<String> cbcliente = new ComboBox<>();
        cbcliente.getItems().addAll("Carlos Coches", "Beni Beamontes", "Flexin Street");
        hboxC.getChildren().addAll(cliente, cbcliente);

        HBox hboxP = new HBox(10);
        hboxP.setAlignment(Pos.CENTER_LEFT);
        Label producto = new Label("PRODUCTO");
        producto.setMinWidth(labelWidth);
        producto.setAlignment(Pos.CENTER_LEFT);
        ComboBox<String> cbcproducto = new ComboBox<>();
        cbcproducto.getItems().addAll("Cajas", "Bidones", "Frascos");
        hboxP.getChildren().addAll(producto, cbcproducto);

        HBox hboxT = new HBox(10);
        hboxT.setAlignment(Pos.CENTER_LEFT);
        Label trabajador = new Label("TRABAJADOR");
        trabajador.setMinWidth(labelWidth);
        trabajador.setAlignment(Pos.CENTER_LEFT);
        ComboBox<String> cbctrabajador = new ComboBox<>();
        cbctrabajador.getItems().addAll("Skiki Fernandez", "Diego Maradona","Juancho Perez");
        hboxT.getChildren().addAll(trabajador, cbctrabajador);

        GridPane gp = new GridPane();
        gp.setHgap(0);
        gp.setVgap(0);
        gp.setPadding(new Insets(10));
        gp.setAlignment(Pos.CENTER);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(150);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(150);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setMinWidth(200);
        gp.getColumnConstraints().addAll(col1, col2, col3);

        gp.add(createCell("CLIENTES", true), 0, 0);
        gp.add(createCell("PRODUCTOS", true), 1, 0);
        gp.add(createCell("TRABAJADORES", true), 2, 0);

        String[] clientes = {"Carlos Coches", "Beni Beamontes", "Flexin Street"};
        String[] productos = {"Cajas", "Bidones", "Frascos"};
        String[] trabajadores = {"Skiki Fernandez", "Diego Maradona","Juancho Perez"};

        int maxFilas = Math.max(clientes.length, Math.max(productos.length, trabajadores.length));

        for (int i = 0; i < maxFilas; i++) {
            Label c = createCell(i < clientes.length ? clientes[i] : "", false);
            Label p = createCell(i < productos.length ? productos[i] : "", false);
            Label t = createCell(i < trabajadores.length ? trabajadores[i] : "", false);
            gp.add(c, 0, i + 1);
            gp.add(p, 1, i + 1);
            gp.add(t, 2, i + 1);
        }

        VBox.setMargin(gp, new Insets(20, 0, 0, 0));
        vBox.getChildren().addAll(hboxC, hboxP, hboxT, gp);

        SP.getChildren().add(vBox);
        StackPane.setAlignment(vBox, Pos.TOP_CENTER);

        stage.setScene(scene);
        stage.show();
    }

    private Label createCell(String text, boolean isHeader) {
        Label label = new Label(text);
        label.setStyle(
                "-fx-border-color: black; " +
                        "-fx-padding: 10; " +
                        "-fx-alignment: center; " +
                        (isHeader ? "-fx-font-weight: bold; -fx-background-color: lightgray;" : "")
        );
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMinHeight(30);
        return label;
    }

}
