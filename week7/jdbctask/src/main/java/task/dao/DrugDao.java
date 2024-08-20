package task.dao;

import task.entity.Drug;
import task.entity.Hospital;
import task.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DrugDao implements Dao<Drug> {
    @Override
    public Optional<Drug> get(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from drugs where drug_id = ?");
            statement.setInt(1 , id);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                Drug drug = new Drug();
                drug.setId(id);
                drug.setName(set.getString("name"));
                return Optional.ofNullable(drug);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Drug> getAll() {
        List<Drug> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from drugs");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Drug drug = new Drug();
                drug.setId(set.getInt(1));
                drug.setName(set.getString("name"));

                list.add(drug);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void save(Drug drug) {

        String query = "Insert into drugs (drug_id , name) values (? , ?)";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , drug.getId());
            statement.setString(2 , drug.getName());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new entity was inserted successfully!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Drug drug) {
        String query = "UPDATE  drugs set name = ?  where drug_id = ?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2 , drug.getId());
            statement.setString(1 , drug.getName());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was updated !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Drug drug) {
        String query = "DELETE FROM drugs WHERE drug_id =?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , drug.getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was deleted !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
