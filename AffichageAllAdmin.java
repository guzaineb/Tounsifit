
    package controles;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Allergie;
import services.AllergieService;
import tests.MainFx;

import javax.management.NotificationBroadcasterSupport;

    public class AffichageAllAdmin {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;









        @FXML
        private Label DesB1;

        @FXML
        private HBox NomB;





        @FXML
        private Label all;

        @FXML
        private Button supprimer;

        @FXML
        private ScrollPane alllayaout;

        @FXML
        private Button edit;


        private Allergie selectedAllergie;

        @FXML
        private VBox vbox;

        private ObservableList<Allergie> observableList = FXCollections.observableArrayList();

        @FXML
        private void initializeAllergies() {

            AllergieService as = new AllergieService();

            try {
                observableList.addAll(as.afficher());
                for (Allergie allergie : observableList) {
                    NomB = new HBox();
                    VBox nomColumn = new VBox();
                    VBox descriptionColumn = new VBox();

                    all = new Label(allergie.getnom());
                    DesB1 = new Label(allergie.getdescription());

                    nomColumn.getChildren().add(all);
                    descriptionColumn.getChildren().add(DesB1);

                    // Create edit and delete buttons for each row
                    edit = new Button("Edit");
                    supprimer.setOnAction(event -> {
                        selectedAllergie = allergie;  // Store the selected Allergie
                        try {
                            handDelet(event);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });


                    HBox buttonsBox = new HBox(edit, supprimer);

                    NomB.getChildren().addAll(nomColumn, descriptionColumn, buttonsBox);

                    vbox.getChildren().add(NomB);

            } }catch (SQLException e) {
                e.printStackTrace(); // Print the exception details for debugging
                throw new RuntimeException(e);}


        }
        @FXML

  void handleEdit(ActionEvent event, Stage primaryStage) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditAllergie.fxml"));
                AnchorPane editLayout = loader.load();

                // Accédez au contrôleur de l'interface d'édition pour initialiser les champs
                Edit editController = loader.getController();
                editController.initData(selectedAllergie);

                // Créez une nouvelle fenêtre ou boîte de dialogue pour l'édition
                Stage editStage = new Stage();
                editStage.setTitle("Édition d'une allergie");
                editStage.initModality(Modality.WINDOW_MODAL);
                editStage.initOwner(primaryStage);

                Scene scene = new Scene(editLayout);
                editStage.setScene(scene);

                editStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }







        @FXML
        void handDelet(ActionEvent event) throws SQLException {
            AllergieService as = new AllergieService();

            Allergie allergieToDelete = new Allergie();
            allergieToDelete.setId_al( selectedAllergie.getid_al());
            as.supprimer(allergieToDelete);


            observableList.remove(selectedAllergie);

            // Find and remove the specific NomB associated with the deleted Allergie
            Iterator<Node> iterator = vbox.getChildren().iterator();
            while (iterator.hasNext()) {
                Node node = iterator.next();
                if (node instanceof HBox && ((HBox) node).getChildren().contains(NomB)) {
                    iterator.remove();
                    break; // Break once you've found and removed the correct NomB


                }

            }
        }



}
