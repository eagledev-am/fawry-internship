package task.dao;

import task.entity.Doctor;
import task.entity.Hospital;
import task.util.DBConnection;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDao implements Dao<Doctor> {
    @Override
    public Optional<Doctor> get(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from doctors where doctor_id = ?");
            statement.setInt(1 , id);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                Doctor doctor = new Doctor();
                doctor.setId(set.getInt(1));
                doctor.setName(set.getString(2));
                doctor.setSpecialty(set.getString(3));
                doctor.setHospital_id(set.getInt(4));
                return Optional.ofNullable(doctor);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  * from doctors");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Doctor doctor = new Doctor();
                doctor.setId(set.getInt(1));
                doctor.setName(set.getString(2));
                doctor.setSpecialty(set.getString(3));
                doctor.setHospital_id(set.getInt(4));

                list.add(doctor);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void save(Doctor doctor) {
        String query = "Insert into doctors (doctor_id , name , specialty , hospital_id ) values (? , ? , ? , ? )";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , doctor.getId());
            statement.setString(2 , doctor.getName());
            statement.setString(3 , doctor.getSpecialty());
            statement.setInt(4 , doctor.getHospital_id());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A new entity was inserted successfully!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Doctor doctor) {

        String query = "UPDATE  doctors set name = ? , specialty = ? , specialty = ? where doctor_id = ?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1 , doctor.getName());
            statement.setString(2 , doctor.getSpecialty());
            statement.setInt(3 , doctor.getHospital_id());
            statement.setInt(4 , doctor.getId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was updated !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Doctor doctor) {
        String query = "DELETE FROM doctors WHERE doctor_id =?";
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1 , doctor.getId());
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("entity was deleted !");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
