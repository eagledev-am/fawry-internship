package task.dao;

import task.entity.Hospital;
import task.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HospitalDao implements Dao<Hospital>{


    @Override
    public Optional<Hospital> get(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from hospital where hospital_id = ?");
            statement.setInt(1 , id);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                Hospital hospital = new Hospital();
                hospital.setId(set.getInt("hospital_id"));
                hospital.setName(set.getString("name"));
                hospital.setAddress(set.getString("address"));
                hospital.setPhone(set.getString("phone"));
                return Optional.ofNullable(hospital);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Hospital> getAll() {
        List<Hospital> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from hospital");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Hospital hospital = new Hospital();
                hospital.setId(set.getInt("hospital_id"));
                hospital.setName(set.getString("name"));
                hospital.setAddress(set.getString("address"));
                hospital.setPhone(set.getString("phone"));

                list.add(hospital);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void save(Hospital hospital) {
        String query = "Insert into hospital (hospital_id , name , address , phone ) values (? , ? , ? , ? )";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , hospital.getId());
            statement.setString(2 , hospital.getName());
            statement.setString(3 , hospital.getAddress());
            statement.setString(4 , hospital.getPhone());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new entity was inserted successfully!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Hospital hospital) {
        String query = "UPDATE  hospital set name = ? , address = ? , phone = ? where hospital_id = ?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1 , hospital.getName());
            statement.setString(2 , hospital.getAddress());
            statement.setString(3 , hospital.getPhone());
            statement.setInt(4 , hospital.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was updated !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Hospital hospital) {
        String query = "DELETE FROM hospital WHERE hospital_id =?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , hospital.getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was deleted !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
