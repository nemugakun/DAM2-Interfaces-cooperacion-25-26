module es.vallecidacos.dam2interfacescooperacion2526 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports es_vallecidacos_dam2interfacescooperacion2526_tasks.alvaro;
    opens es_vallecidacos_dam2interfacescooperacion2526_tasks.alvaro to javafx.fxml;
    opens es.vallecidacos.dam2interfacescooperacion2526 to javafx.fxml;
    exports es.vallecidacos.dam2interfacescooperacion2526;
}