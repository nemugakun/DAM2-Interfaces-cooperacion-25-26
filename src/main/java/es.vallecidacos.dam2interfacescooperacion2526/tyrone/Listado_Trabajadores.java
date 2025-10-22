package es.vallecidacos.dam2interfacescooperacion2526.tyrone;

import es.vallecidacos.dam2interfacescooperacion2526.HelloApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Listado_Trabajadores extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane gp = new GridPane();
        String listo = "Listo";
        String no_listo = "No Listo";
        ListView<String> listView = new ListView<String>();
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setPrefWidth(100);
        listView.setPrefHeight(30);
        listView.getItems().add(listo);
        listView.getItems().add(no_listo);
        VBox vBox = new VBox(listView);
        Label label1 = new Label("Trabajador 1 : ");
        Label label2 = new Label("Trabajador 2: ");
        TextArea textArea = new TextArea();
        TextArea textArea3 = new TextArea();
        textArea.setPrefHeight(0.5);
        textArea.setPrefWidth(200);
        textArea3.setPrefHeight(0.5);
        textArea3.setPrefWidth(200);
        gp.add(vBox,4,8,1,1);
        gp.add(label1, 0,2,1,1);
        gp.add(textArea,4,2,1,1);
        gp.add(label2, 0,6,1,1);
        gp.add(textArea3,4,6,1,1);
        gp.setVgap(10.00);
        Scene scene = new Scene(gp, 320, 240);
        primaryStage.setTitle("Interfaz");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
