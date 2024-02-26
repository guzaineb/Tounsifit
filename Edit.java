package controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Allergie;

public class Edit {

    @FXML
    private Button Modifier;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextField nomFieled;

    @FXML
    void ModifierAllergie(ActionEvent event) {

    }
    private Allergie allergie;

    public void initData(Allergie allergie) {
        this.allergie = allergie;

        // Initialisez les champs avec les données actuelles de l'allergie
        nomFieled.setText(allergie.getnom());
        descriptionField.setText(allergie.getdescription());
    }

}
