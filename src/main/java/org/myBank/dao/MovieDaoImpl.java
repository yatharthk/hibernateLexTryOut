package org.myBank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.myBank.entity.Movie;
import org.myBank.util.HibernateUtil;

public class MovieDaoImpl implements  MovieDao{

    @Override
    public void addMovie(Movie movie) {
        Session session = HibernateUtil.getSession().openSession();
        Transaction tx = session.beginTransaction();
//        session.persist(movie);          // throwing error
        session.save(movie);       //this functionality wise  is working fine but deprecated
//      session.merge(movie); // also working fine as it will update the object if id already present.
//        otherwise create new
//        session.update(movie); // this is fine but deprecated too

        tx.commit();
        session.close();
    }
}
