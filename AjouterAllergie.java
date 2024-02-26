
package controles;

        import java.io.IOException;
        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;


        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Alert;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;
        import javafx.stage.StageStyle;
        import javafx.stage.Window;
        import models.Allergie;
        import services.AllergieService;

public class AjouterAllergie {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField nomtextFieled;

    @FXML
    void AjouterAllergie(ActionEvent event) {
            // Check if the required field is empty
            if (nomtextFieled.getText().isEmpty()||descriptionTextField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("champs est obligatoire !");
                alert.show();
                return; // Stop further execution if the required field is empty
            }
          else {

                Allergie allergie = new Allergie(nomtextFieled.getText(), descriptionTextField.getText());
                AllergieService allergieService = new AllergieService();

                try {
                    allergieService.ajouter(allergie);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/AffichageAllAdmin.fxml"));
                    try {
                        Parent root = loader.load();
                        AffichageAllAdmin afiicherAdmin = loader.getController();
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        // Close the current stage if needed
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (SQLException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.show();
                }


            }

    }

@FXML
    public void initialize(URL location, ResourceBundle resources) {
        // Initialization logic
    }

}
