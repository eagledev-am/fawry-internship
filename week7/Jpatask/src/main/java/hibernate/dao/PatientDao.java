package hibernate.dao;

import hibernate.entity.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PatientDao implements Dao<Patient> {

    private Session session;

    public PatientDao(Session session){
        this.session = session;
    }
    @Override
    public Optional<Patient> get(int id) {
        Optional<Patient> patient = Optional.ofNullable(session.get(Patient.class , id));
        return patient;
    }

    @Override
    public List<Patient> getAll() {
        Query<Patient> query = session.createQuery("from Patient");
        List<Patient> list = query.list();
        return list;
    }

    @Override
    public void save(Patient patient) {
        Transaction transaction = session.beginTransaction();
        session.save(patient);
        transaction.commit();
    }

    @Override
    public void update(Patient patient) {
        Transaction transaction = session.beginTransaction();
        session.update(patient);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Patient patient) {
        Transaction transaction = session.beginTransaction();
        session.delete(patient);
        transaction.commit();
    }
}
