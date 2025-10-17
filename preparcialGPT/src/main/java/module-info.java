module co.edu.uniquindio.practice.preparcialgpt {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.practice.preparcialgpt to javafx.fxml;
    exports co.edu.uniquindio.practice.preparcialgpt;
    
    opens co.edu.uniquindio.practice.preparcialgpt.controller to javafx.fxml;
    exports co.edu.uniquindio.practice.preparcialgpt.controller;
    
    opens co.edu.uniquindio.practice.preparcialgpt.model to javafx.fxml;
    exports co.edu.uniquindio.practice.preparcialgpt.model;
    
    // Exportar subpaquetes de model
    exports co.edu.uniquindio.practice.preparcialgpt.model.adapter;
    exports co.edu.uniquindio.practice.preparcialgpt.model.bridge;
    exports co.edu.uniquindio.practice.preparcialgpt.model.builder;
    exports co.edu.uniquindio.practice.preparcialgpt.model.composite;
    exports co.edu.uniquindio.practice.preparcialgpt.model.decorator;
    exports co.edu.uniquindio.practice.preparcialgpt.model.dto;
    exports co.edu.uniquindio.practice.preparcialgpt.model.facade;
    exports co.edu.uniquindio.practice.preparcialgpt.model.singleton;
    
    // Abrir para FXML
    opens co.edu.uniquindio.practice.preparcialgpt.model.dto to javafx.fxml;
    opens co.edu.uniquindio.practice.preparcialgpt.model.composite to javafx.fxml;
}