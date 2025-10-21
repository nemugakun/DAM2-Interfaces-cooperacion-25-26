package es.vallecidacos.dam2interfacescooperacion2526;

import es_vallecidacos_dam2interfacescooperacion2526_tasks.alvaro.ProductListingApp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Application");

        VBox mainLayout = new VBox(20);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Welcome to the Main Application");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));

        Button openProductListButton = new Button("Open Product Listing");
        openProductListButton.setPrefWidth(300);
        openProductListButton.setPrefHeight(50);
        openProductListButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px; -fx-cursor: hand;");
        
        openProductListButton.setOnAction(e -> {
            try {
                Stage productStage = new Stage();
                productStage.setWidth(1200);
                productStage.setHeight(700);
                productStage.setMinWidth(1200);
                productStage.setMinHeight(700);
                ProductListingApp productApp = new ProductListingApp();
                productApp.start(productStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        mainLayout.getChildren().addAll(titleLabel, openProductListButton);

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
