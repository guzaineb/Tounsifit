package services;

import models.Allergie;
import utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AllergieService implements  IService<Allergie> {
    private Connection connection ;
    public AllergieService () {
        connection = MyDataBase.getInstance().getconnection();

    }
    @Override
     public void ajouter(Allergie allergie) throws SQLException {
        String req = "insert into  allergie (nom, description) " +
                "VALUES ('" + allergie.getnom() + "', '" + allergie.getdescription() + " ')";

        Statement statement =connection.createStatement();
        statement.executeUpdate(req);
    }

    @Override
    public void modifier(Allergie allergie) throws SQLException {

        String sql ="update allergie set id_al = ?, nom =? ,description = ? where id_al = ? ";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);


        preparedStatement.setString(1, allergie.getnom());
        preparedStatement.setString(2, allergie.getdescription());
        preparedStatement.setInt(3, allergie.getid_al());

        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(Allergie id_al) throws SQLException {
        String req = "DELETE FROM `allergie` WHERE allergie.id_al= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1,id_al.getid_al());
        System.out.println("Allergie  suprimée !");
        preparedStatement.executeUpdate();

    }

   /* public void supprimer(int id_al) throws SQLException {
        String req = "DELETE FROM `allergie` WHERE allergie.id_al= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, id_al.getid_al());
           System.out.println("Allergie  suprimée !");
        preparedStatement.executeUpdate();
    }*/

 @Override
    public List<Allergie> afficher() throws SQLException {
        String sql = "select * from allergie ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Allergie> list = new ArrayList<>();
        while (rs.next()) {
            Allergie a = new Allergie();
            a.setId_al(rs.getInt("id_al"));
            a.setNom(rs.getString("nom"));
            a.setDescription(rs.getString("description"));
            list.add(a);

        }
        return  list ;

    }}

