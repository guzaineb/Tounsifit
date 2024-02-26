package services;

import models.InformationEducatif;

import java.sql.SQLException;
import java.util.List;

public interface InfoService <InformationEducatif >{

    void ajouterInformation(models.InformationEducatif information) throws SQLException;

    void modifierInformation(InformationEducatif  information) throws SQLException;
    void supprimerInformation(int idInformation) throws SQLException;
    List<InformationEducatif> afficherInformation() throws SQLException;
}
