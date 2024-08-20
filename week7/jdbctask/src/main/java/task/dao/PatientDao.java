package task.dao;

import task.entity.Hospital;
import task.entity.Patient;
import task.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDao implements Dao<Patient> {
    @Override
    public Optional<Patient> get(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from patients where patient_id = ?");
            statement.setInt(1 , id);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                Patient patient = new Patient();
                patient.setId(set.getInt("patient_id"));
                patient.setName(set.getString("name"));
                patient.setAge(set.getInt("age"));
                patient.setHospitalId(set.getInt("hospital_id"));
                return Optional.ofNullable(patient);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from patients");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Patient patient = new Patient();
                patient.setId(set.getInt("patient_id"));
                patient.setName(set.getString("name"));
                patient.setAge(set.getInt("age"));
                patient.setHospitalId(set.getInt("hospital_id"));

                list.add(patient);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void save(Patient patient) {
        String query = "Insert into patients (patient_id , name , age , hospital_id ) values (? , ? , ? , ? )";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , patient.getId());
            statement.setString(2 , patient.getName());
            statement.setInt(3 , patient.getAge());
            statement.setInt(4 , patient.getHospitalId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new entity was inserted successfully!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Patient patient) {
        String query = "UPDATE  patients set name = ? , age = ? , hospital_id = ? where patient_id = ?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1 , patient.getName());
            statement.setInt(2 , patient.getAge());
            statement.setInt(3 , patient.getHospitalId());
            statement.setInt(4 , patient.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was updated !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Patient patient) {
        String query = "DELETE FROM patients WHERE patient_id =?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , patient.getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was deleted !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
