package hibernate;

import hibernate.dao.DoctorDao;
import hibernate.dao.HospitalDao;
import hibernate.entity.Doctor;
import hibernate.entity.Drug;
import hibernate.entity.Hospital;
import hibernate.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernate.util.HibernateUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        System.out.println( getDoctorsNamesOfHos(101));
        System.out.println(getPatientNamesOfDocOfHos(101));
        System.out.println(getPatientNamesOfDocById(201));
        System.out.println(getDrugsById(201));
    }

    // names of doctors in the hospital
    public static List<String> getDoctorsNamesOfHos(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        HospitalDao dao = new HospitalDao(session);
        Optional<Hospital> hospital = dao.get(id);
       return hospital.stream()
                .flatMap(hospital1 -> hospital1.getDoctors().stream())
                .map(Doctor::getName)
                .collect(Collectors.toList());
    }

    // doctors in the hospital and their patients
    public static Map<String, List<String>> getPatientNamesOfDocOfHos(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        HospitalDao dao = new HospitalDao(session);
        Optional<Hospital> hospital = dao.get(id);
        return hospital.stream()
                .flatMap(hospital1 -> hospital1.getDoctors().stream())
                .collect(Collectors.toMap(Doctor::getName , getPatientName));
    }

    // patients of a specified doctor
    public static Map<String , List<String>> getPatientNamesOfDocById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Optional<Doctor> doctor = Optional.of(session.get(Doctor.class , id));
        return doctor.stream()
                .collect(Collectors.toMap(Doctor::getName , getPatientName));
    }
    public static Function<Doctor , List<String>>  getPatientName = doctor -> doctor.getPatients()
            .stream().map(Patient::getName).toList();


    // drugs name by doctor id
    public static List<String> getDrugsById(int id){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Optional<Doctor> doctor = Optional.of(session.get(Doctor.class , id));
        return doctor.stream()
                .flatMap(doctor1 -> doctor1.getPatients().stream())
                .flatMap(patient -> patient.getDrugs().stream())
                .map(Drug::getName)
                .toList();
    }
}
