module es.vallecidacos.dam2interfacescooperacion2526 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens es.vallecidacos.dam2interfacescooperacion2526 to javafx.fxml;
    exports es.vallecidacos.dam2interfacescooperacion2526;
    exports es.vallecidacos.dam2interfacescooperacion2526.jorge;
}