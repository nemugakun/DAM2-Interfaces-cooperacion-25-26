package es.vallecidacos.dam2interfacescooperacion2526.jhon;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class RegistrarEmpleado extends StackPane {

    private final GridPane formGrid;

    public RegistrarEmpleado() {
        // Crear GridPane con estructura adaptable
        formGrid = new GridPane();
        formGrid.setPadding(new Insets(20));
        formGrid.setHgap(15);
        formGrid.setVgap(10);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70);
        formGrid.getColumnConstraints().addAll(col1, col2);

        // Campos
        TextField tfNombre = new TextField();
        TextField tfApellidos = new TextField();
        DatePicker dpFechaNacimiento = new DatePicker();
        TextField tfDNI = new TextField();
        TextField tfCuentaBancaria = new TextField();
        TextField tfNumSS = new TextField();
        DatePicker dpFechaAlta = new DatePicker();
        DatePicker dpFechaBaja = new DatePicker();

        // Agregar elementos al grid
        formGrid.add(new Label("Nombre:"), 0, 0);
        formGrid.add(tfNombre, 1, 0);

        formGrid.add(new Label("Apellidos:"), 0, 1);
        formGrid.add(tfApellidos, 1, 1);

        formGrid.add(new Label("Fecha de Nacimiento:"), 0, 2);
        formGrid.add(dpFechaNacimiento, 1, 2);

        formGrid.add(new Label("DNI o NIF:"), 0, 3);
        formGrid.add(tfDNI, 1, 3);

        formGrid.add(new Label("Cuenta Bancaria:"), 0, 4);
        formGrid.add(tfCuentaBancaria, 1, 4);

        formGrid.add(new Label("Nº Seguridad Social:"), 0, 5);
        formGrid.add(tfNumSS, 1, 5);

        formGrid.add(new Label("Fecha de Alta:"), 0, 6);
        formGrid.add(dpFechaAlta, 1, 6);

        formGrid.add(new Label("Fecha de Baja:"), 0, 7);
        formGrid.add(dpFechaBaja, 1, 7);

        // Botón de ejemplo
        Button btnRegistrar = new Button("Registrar");
        Button btnCancelar = new Button("Cancelar");
        HBox Botones = new HBox(btnRegistrar, btnCancelar);
        StackPane buttonBox = new StackPane(Botones);
        Botones.setPadding(new Insets(20, 200, 0, 0));

        // Título centrado
        Label titleLabel = new Label("Registro de Empleado");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        HBox titleBox = new HBox(titleLabel);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10, 0, 10, 0));

        // Crear el StackPane y agregar el contenido
        this.setPadding(new Insets(20));

        // Usar StackPane para que todo se mantenga centrado
        VBox mainContent = new VBox();
        mainContent.setPadding(new Insets(20));
        mainContent.setSpacing(10);
        mainContent.getChildren().addAll(titleBox, formGrid, buttonBox);

        // Agregar el VBox al StackPane
        this.getChildren().add(mainContent);

        // Aseguramos que el formulario crezca al redimensionar
        VBox.setVgrow(formGrid, Priority.ALWAYS);
    }
}