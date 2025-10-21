package es_vallecidacos_dam2interfacescooperacion2526_tasks.alvaro;

import javafx.beans.property.*;

public class Product {
    private final StringProperty name;
    private final StringProperty category;
    private final IntegerProperty units;
    private final DoubleProperty price;
    private final StringProperty photoPath;

    public Product(String name, String category, int units, double price, String photoPath) {
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.units = new SimpleIntegerProperty(units);
        this.price = new SimpleDoubleProperty(price);
        this.photoPath = new SimpleStringProperty(photoPath);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public int getUnits() {
        return units.get();
    }

    public void setUnits(int units) {
        this.units.set(units);
    }

    public IntegerProperty unitsProperty() {
        return units;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public String getPhotoPath() {
        return photoPath.get();
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath.set(photoPath);
    }

    public StringProperty photoPathProperty() {
        return photoPath;
    }
}
