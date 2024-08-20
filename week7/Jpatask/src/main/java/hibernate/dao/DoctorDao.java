package hibernate.dao;

import hibernate.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class DoctorDao implements Dao<Doctor> {
    private Session session;

    public DoctorDao(Session session){
       this.session = session;
    }
    @Override
    public Optional<Doctor> get(int id) {
        Optional<Doctor> optional =  Optional.ofNullable(session.get(Doctor.class , id));
        session.close();
        return optional;
    }

    @Override
    public List<Doctor> getAll() {
        Query<Doctor> query = session.createQuery("from Doctor ");
        List<Doctor> list= query.list();
        return list;
    }

    @Override
    public void save(Doctor doctor) {
        Transaction transaction = session.beginTransaction();
        session.save(doctor);
        transaction.commit();
    }

    @Override
    public void update(Doctor doctor) {
        Transaction transaction = session.beginTransaction();
        session.update(doctor);
        transaction.commit();
    }

    @Override
    public void delete(Doctor doctor) {
        Transaction transaction = session.beginTransaction();
        session.delete(doctor);
        transaction.commit();
    }
}
