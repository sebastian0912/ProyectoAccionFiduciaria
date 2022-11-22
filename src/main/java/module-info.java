module com {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com to javafx.fxml;
    exports com;
}

