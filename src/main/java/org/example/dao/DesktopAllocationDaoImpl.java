package org.example.dao;

import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DesktopAllocationDaoImpl implements DesktopAllocationDao {

    @Override
    public void addTraineeWithoutDesktop(Trainee t) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(t);
            tx.commit();

            System.out.println("Trainee added to db.");
        } catch (HibernateException ex) {
            System.out.println("Error saving trainee to db:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred:" + ex.getMessage());
        }

    }

    @Override
    public void addTraineeWithDesktop(Trainee t, DesktopEntity desktop) {
        t.setDesktop(desktop);
        addTraineeWithoutDesktop(t);
    }

    @Override
    public void allocateExistingDesktopToExistingTrainee(int traineeId, String desktopId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            DesktopEntity d = session.get(DesktopEntity.class, desktopId);
            if (d == null) {
                System.out.println("the desktop id provided does not exist in db");
                return;
            }
            Transaction tx = session.beginTransaction();

            List<Trainee> trainees = session.createQuery("FROM Trainee", Trainee.class).list();
            for (Trainee t : trainees) {
                if (t.getDesktop() != null && t.getDesktop().getMachineEntity().equalsIgnoreCase(desktopId)) {
                    System.out.println("Desktop already allocated to trainee with id " + t.getId());
                    return;
                }
            }


            Trainee temp = session.get(Trainee.class, traineeId);

            temp.setDesktop(d);
            session.merge(temp);


            tx.commit();

            System.out.println("Desktop with id " + desktopId + "allocated to Trainee: " + traineeId + ".Db updated");
        } catch (HibernateException ex) {
            System.out.println("Error allocating desktop to trainee:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred while allocating desktop:" + ex.getMessage());
        }

    }

    @Override
    public void allocateDesktopToNewTrainee(int traineeId, DesktopEntity d) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Trainee t = session.get(Trainee.class, traineeId);
            if (t == null) {
                System.out.println("Sorry traiee with id: " + traineeId + " not present/found.");
                return;

            }
            t.setDesktop(d);
            session.merge(t);
            tx.commit();

            System.out.println("Desktop allocated to Trainee.Db updated");
        } catch (HibernateException ex) {
            System.out.println("Error allocating desktop to trainee:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred while allocating desktop:" + ex.getMessage());
        }
    }

    @Override
    public void deallocateDesktop(int traineeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Trainee temp = session.get(Trainee.class, traineeId);
            String desktopId = temp.getDesktop().getMachineEntity();
            temp.setDesktop(null);
            session.persist(temp);
            tx.commit();
            System.out.println("Desktop with id :" + desktopId + " deallocated for Trainee.Db updated");
        } catch (HibernateException ex) {
            System.out.println("Error de-allocating desktop from trainee:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred while allocating desktop:" + ex.getMessage());
        }
    }

    @Override
    public void deleteTraineeOnly(int traineeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Trainee temp = session.get(Trainee.class, traineeId);
            session.remove(temp);
            tx.commit();
            System.out.println("Trainee with id:" + traineeId + " removed .Db updated");
        } catch (HibernateException ex) {
            System.out.println("Error removing trainee:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred while removing trainee : " + ex.getMessage());
        }
    }

    @Override
    public void deleteTraineeAndDesktop(int traineeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Trainee temp = session.get(Trainee.class, traineeId);
            DesktopEntity desktop = temp.getDesktop();

            session.remove(temp);
            session.remove(desktop);
            tx.commit();
            System.out.println("Desktop " + desktop.getMachineEntity() + " associated with id" + traineeId + "removed.");
            System.out.println("Trainee with id:" + traineeId + " removed.  Db updated");
        } catch (HibernateException ex) {
            System.out.println("Error removing desktop or trainee:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Some exception occurred while removing asset or  trainee " + ex.getMessage());
        }
    }

    @Override
    public Trainee getAllocationDetails(int traineeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Trainee temp = session.get(Trainee.class, traineeId);
            if(temp==null) {
                System.out.println("Trainee with id:"+traineeId+ " not found");
            }
            return temp;
        } catch (Exception ex) {
            System.out.println("Some exception occurred while retrieving trainee " + ex.getMessage());
            return null;
        }

    }

    @Override
    public void getDetailsUsingMultiSelect(List<Integer> ids) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            MultiIdentifierLoadAccess<Trainee> multi =  session.byMultipleIds(Trainee.class);
            List<Trainee> list = multi.multiLoad(ids);
            System.out.println("Printing details of 3 ids provided");
            list.forEach(System.out::println);
        }
    }
}
