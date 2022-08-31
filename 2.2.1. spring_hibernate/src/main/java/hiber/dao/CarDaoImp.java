package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarByModelSeries(String model, int series) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Car where model = ?1 and series = ?2");
        query.setParameter(1, model);
        query.setParameter(2, series);
        return (Car) query.getSingleResult();
    }
}
