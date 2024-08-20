package task;

import task.entity.Doctor;
import task.entity.Patient;
import task.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getDoctors(101).forEach(System.out::println);
        System.out.println("-----------------");
        getPatientByDoc(201).forEach(System.out::println);
        System.out.println("-----------------");
        getDrugsByDoc(201).forEach(System.out::println);
    }

    // get all doctors in hospital
    private static final String DOCTORS_WORK_IN_HOSPITAL = "select * from doctors where hospital_id = ?";
    public static List<Doctor> getDoctors(int id){

        List<Doctor> doctors = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DOCTORS_WORK_IN_HOSPITAL);
            preparedStatement.setInt(1 , id);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                Doctor doctor = new Doctor();
                doctor.setId(set.getInt(1));
                doctor.setName(set.getString(2));
                doctor.setSpecialty(set.getNString(3));
                doctor.setHospital_id(set.getInt(4));
                doctors.add(doctor);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return doctors;
    }

    private static final String PATIENT_OF_DOCTOR = "SELECT p.patient_id , p.name , p.age , p.hospital_id FROM patients p \n" +
            "LEFT JOIN doctors_patients pd\n" +
            "on p.patient_id = pd.patient_id\n" +
            "JOIN doctors d\n" +
            "on d.doctor_id = pd.doctor_id\n" +
            "WHERE d.doctor_id = ?";
    public static List<Patient> getPatientByDoc(int id){
        List<Patient> patients = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(PATIENT_OF_DOCTOR);
            preparedStatement.setInt(1 , id);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                Patient patient = new Patient();
                patient.setId(set.getInt(1));
                patient.setName(set.getString(2));
                patient.setAge(set.getInt(3));
                patient.setHospitalId(set.getInt(4));
                patients.add(patient);
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return patients;
    }

    private final static String DRUG_PATIENT_DOCTOR = "SELECT d.name FROM drugs d\n" +
            "JOIN patients_drugs pd\n" +
            "ON pd.drug_id = d.drug_id\n" +
            "JOIN patients p\n" +
            "on pd.patient_id = p.patient_id\n" +
            "JOIN doctors_patients dp\n" +
            "on dp.patient_id = p.patient_id\n" +
            "JOIN doctors doc \n" +
            "on dp.doctor_id = doc.doctor_id\n" +
            "WHERE doc.doctor_id = ?;";

    public static List<String> getDrugsByDoc(int id){
        List<String> drugs = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DRUG_PATIENT_DOCTOR);
            preparedStatement.setInt(1 , id);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                drugs.add(set.getString(1));
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return drugs;
    }

}