module co.edu.uniquindio.practice.preparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens co.edu.uniquindio.practice.preparcial to javafx.fxml;
    exports co.edu.uniquindio.practice.preparcial;
    exports co.edu.uniquindio.practice.preparcial.model;
    opens co.edu.uniquindio.practice.preparcial.model to javafx.fxml;
}