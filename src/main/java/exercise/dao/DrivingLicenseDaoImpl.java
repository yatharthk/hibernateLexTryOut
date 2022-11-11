package exercise.dao;

import exercise.entity.DrivingLicense;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DrivingLicenseDaoImpl implements DrivingLicenseDao {

    @Override
    public Integer addRecord(DrivingLicense license) {
        try(Session session = HibernateUtil.getSession().openSession()){
            Transaction tx = session.beginTransaction();
            int id = (int)session.save(license);
            tx.commit();
            session.close();
            return id;

        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public DrivingLicense getDetails(Integer licenseNumber) {
        try(Session session = HibernateUtil.getSession().openSession()){
            return  session.get(DrivingLicense.class,licenseNumber);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
