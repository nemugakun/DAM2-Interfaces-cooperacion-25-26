package es_vallecidacos_dam2interfacescooperacion2526_tasks.alvaro;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

public class ProductListingApp extends Application {

    private TableView<Product> productTable;
    private ObservableList<Product> productData;
    private TextField nameField;
    private TextField categoryField;
    private TextField unitsField;
    private TextField priceField;
    private TextField photoPathField;
    private ImageView photoPreview;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Product Management");

        // sample data
        productData = FXCollections.observableArrayList(
                new Product("Manzana Pink Lady", "Fruta", 15, 2.99, ""),
                new Product("Zanahoria", "Verdura", 30, 1.50, ""),
                new Product("Lomo", "Carne", 8, 6.99, ""),
                new Product("Leche Entera", "Lácteos", 50, 2.99, ""),
                new Product("Lámpara de Escritorio", "Otros", 25, 39.99, "")
        );

        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(15));

        Label titleLabel = new Label("Product Management");
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 24));
        titleLabel.setPadding(new Insets(0, 0, 15, 0));

        VBox topBox = new VBox(titleLabel);
        topBox.setAlignment(Pos.CENTER);
        mainLayout.setTop(topBox);

        productTable = createProductTable();
        mainLayout.setCenter(productTable);

        VBox formPanel = createFormPanel();
        mainLayout.setRight(formPanel);

        HBox buttonBox = createButtonBox();
        mainLayout.setBottom(buttonBox);

        Scene scene = new Scene(mainLayout, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Product> createProductTable() {
        TableView<Product> table = new TableView<>();
        table.setItems(productData);
        table.setPrefWidth(700);

        TableColumn<Product, String> nameCol = new TableColumn<>("Product Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setPrefWidth(200);

        TableColumn<Product, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        categoryCol.setPrefWidth(150);

        TableColumn<Product, Integer> unitsCol = new TableColumn<>("Units");
        unitsCol.setCellValueFactory(new PropertyValueFactory<>("units"));
        unitsCol.setPrefWidth(100);
        unitsCol.setStyle("-fx-alignment: CENTER;");

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price (€)");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setPrefWidth(120);
        priceCol.setStyle("-fx-alignment: CENTER-RIGHT;");
        priceCol.setCellFactory(column -> new TableCell<Product, Double>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if (empty || price == null) {
                    setText(null);
                } else {
                    setText(String.format("%.2f €", price));
                }
            }
        });

        TableColumn<Product, String> photoCol = new TableColumn<>("Photo");
        photoCol.setCellValueFactory(new PropertyValueFactory<>("photoPath"));
        photoCol.setPrefWidth(100);
        photoCol.setCellFactory(column -> new TableCell<Product, String>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String photoPath, boolean empty) {
                super.updateItem(photoPath, empty);
                if (empty || photoPath == null || photoPath.isEmpty()) {
                    setGraphic(null);
                } else {
                    try {
                        File file = new File(photoPath);
                        if (file.exists()) {
                            Image image = new Image(file.toURI().toString(), 50, 50, true, true);
                            imageView.setImage(image);
                            setGraphic(imageView);
                        } else {
                            setGraphic(new Label("No Image"));
                        }
                    } catch (Exception e) {
                        setGraphic(new Label("No Image"));
                    }
                }
            }
        });

        table.getColumns().addAll(nameCol, categoryCol, unitsCol, priceCol, photoCol);
        return table;
    }

    private VBox createFormPanel() {
        VBox formPanel = new VBox(10);
        formPanel.setPadding(new Insets(0, 0, 0, 15));
        formPanel.setPrefWidth(350);

        Label formTitle = new Label("Product Details");
        formTitle.setFont(Font.font("System", FontWeight.BOLD, 18));

        Label nameLabel = new Label("Name:");
        nameLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 12));
        nameField = new TextField();
        nameField.setPromptText("Enter product name");
        nameField.setEditable(false);

        Label categoryLabel = new Label("Category:");
        categoryLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 12));
        categoryField = new TextField();
        categoryField.setPromptText("Enter category");
        categoryField.setEditable(false);

        Label unitsLabel = new Label("Units:");
        unitsLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 12));
        unitsField = new TextField();
        unitsField.setPromptText("Enter number of units");
        unitsField.setEditable(false);

        Label priceLabel = new Label("Price (€):");
        priceLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 12));
        priceField = new TextField();
        priceField.setPromptText("Enter price");
        priceField.setEditable(false);

        Label photoLabel = new Label("Photo:");
        photoLabel.setFont(Font.font("System", FontWeight.SEMI_BOLD, 12));

        HBox photoBox = new HBox(5);
        photoPathField = new TextField();
        photoPathField.setPromptText("Select photo");
        photoPathField.setPrefWidth(260);
        photoPathField.setEditable(false);

        Button browseButton = new Button("Browse...");
        browseButton.setDisable(false);

        photoBox.getChildren().addAll(photoPathField, browseButton);

        photoPreview = new ImageView();
        photoPreview.setFitWidth(150);
        photoPreview.setFitHeight(150);
        photoPreview.setPreserveRatio(true);
        photoPreview.setStyle("-fx-border-color: #cccccc; -fx-border-width: 1;");

        StackPane previewPane = new StackPane();
        previewPane.setPrefHeight(160);
        previewPane.setPrefWidth(160);
        previewPane.setStyle("-fx-background-color: #f5f5f5;");
        previewPane.getChildren().add(photoPreview);

        formPanel.getChildren().addAll(
                formTitle,
                new Separator(),
                nameLabel, nameField,
                categoryLabel, categoryField,
                unitsLabel, unitsField,
                priceLabel, priceField,
                photoLabel, photoBox,
                new Label("Preview:"),
                previewPane
        );

        return formPanel;
    }

    private HBox createButtonBox() {
        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(15, 0, 0, 0));
        buttonBox.setAlignment(Pos.CENTER);

        Button addButton = new Button("Add Product");
        addButton.setPrefWidth(135);
        addButton.setDisable(false);
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        Button updateButton = new Button("Update Product");
        updateButton.setPrefWidth(135);
        updateButton.setDisable(false);
        updateButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        Button deleteButton = new Button("Delete Product");
        deleteButton.setPrefWidth(135);
        deleteButton.setDisable(false);
        deleteButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        Button clearButton = new Button("Clear Form");
        clearButton.setPrefWidth(135);
        clearButton.setDisable(false);
        clearButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        buttonBox.getChildren().addAll(addButton, updateButton, deleteButton, clearButton);

        return buttonBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
