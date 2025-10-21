package es.vallecidacos.dam2interfacescooperacion2526;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ContenedorDeOpciones extends VBox {

    public ContenedorDeOpciones(String nombre){
        Label lblNombre = new Label(nombre);
        this.getChildren().add(lblNombre);

        Button btnListar = new Button("Mostrar " + nombre);
        this.getChildren().add(btnListar);

        Button btnCrear = new Button("Crear " + nombre);
        this.getChildren().add(btnCrear);

        Button btnModificar = new Button("Modificar " + nombre);
        this.getChildren().add(btnModificar);
    }
}
