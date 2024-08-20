package hibernate.dao;

import hibernate.entity.Drug;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class DrugDao implements Dao<Drug> {
    private Session session;

    public DrugDao(Session session){
        this.session = session;
    }
    @Override
    public Optional<Drug> get(int id) {
        Optional<Drug> drug = Optional.ofNullable(session.get(Drug.class , id));
        return drug;
    }

    @Override
    public List<Drug> getAll() {
        Query<Drug> query = session.createQuery("from Drug ");
        List<Drug> list = query.list();
        return list;
    }

    @Override
    public void save(Drug drug) {
        Transaction transaction = session.beginTransaction();
        session.save(drug);
        transaction.commit();
    }

    @Override
    public void update(Drug drug) {
        Transaction transaction = session.beginTransaction();
        session.refresh(drug);
        transaction.commit();
    }

    @Override
    public void delete(Drug drug) {
        Transaction transaction = session.beginTransaction();
        session.remove(drug);
        transaction.commit();
    }
}
