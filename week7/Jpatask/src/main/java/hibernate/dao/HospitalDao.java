package hibernate.dao;

import hibernate.entity.Hospital;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class HospitalDao implements Dao<Hospital> {

    private Session session;

    public HospitalDao(Session session){
       this.session = session;
    }
    @Override
    public Optional<Hospital> get(int id) {
        Optional<Hospital> optional =  Optional.ofNullable(session.get(Hospital.class , id));
        return optional;
    }

    @Override
    public List<Hospital> getAll() {
        Query query = session.createQuery("from Hospital ");
        List<Hospital> list = query.list();
        return list;
    }

    @Override
    public void save(Hospital hospital) {
        Transaction transaction = session.beginTransaction();
        session.save(hospital);
        transaction.commit();
    }

    @Override
    public void update(Hospital hospital) {
        Transaction transaction = session.beginTransaction();
        session.update(hospital);
        transaction.commit();
    }

    @Override
    public void delete(Hospital hospital) {
        Transaction transaction = session.beginTransaction();
        session.delete(hospital);
        transaction.commit();
    }

}
