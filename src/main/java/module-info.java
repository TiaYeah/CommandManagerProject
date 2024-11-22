module ru.tiayeah.commandmanagerproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.tiayeah.commandmanagerproject to javafx.fxml;
    exports ru.tiayeah.commandmanagerproject;
}