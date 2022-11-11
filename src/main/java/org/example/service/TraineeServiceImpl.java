package org.example.service;

import org.example.dao.DesktopAllocationDao;
import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;

import java.util.List;

public class TraineeServiceImpl implements TraineeService {

    private final DesktopAllocationDao desktopAllocationDao;

    public TraineeServiceImpl(DesktopAllocationDao dao) {
        this.desktopAllocationDao = dao;
    }

    @Override
    public void addTraineeWithoutDesktop(Trainee t) {
        this.desktopAllocationDao.addTraineeWithoutDesktop(t);
    }

    @Override
    public void addTraineeWithDesktop(Trainee t, DesktopEntity desktop) {
        this.desktopAllocationDao.addTraineeWithDesktop(t, desktop);
    }

    @Override
    public void allocateExistingDesktopToExistingTrainee(int traineeId, String desktopId) {
        this.desktopAllocationDao.allocateExistingDesktopToExistingTrainee(traineeId, desktopId);
    }

    @Override
    public void allocateNewDesktopToTrainee(int id, DesktopEntity d) {
        this.desktopAllocationDao.allocateDesktopToNewTrainee(id, d);
    }

    @Override
    public void deallocateDesktop(int traineeId) {
        this.desktopAllocationDao.deallocateDesktop(traineeId);
    }

    @Override
    public void deleteTraineeOnly(int id) {
        this.desktopAllocationDao.deleteTraineeOnly(id);
    }

    @Override
    public void deleteTraineeAndDesktop(int id) {
        this.desktopAllocationDao.deleteTraineeAndDesktop(id);
    }

    @Override
    public Trainee getAllocationDetails(int id) {
        Trainee temp = this.desktopAllocationDao.getAllocationDetails(id);
        if (temp.getDesktop() == null) {
            System.out.println("Asset status is un-assigned for this trainee");
        } else {
            System.out.println("This trainee has an asset");
        }
        return temp;
    }

    @Override
    public void getDetailsUsingMultiSelect(List<Integer> ids) {
        this.desktopAllocationDao.getDetailsUsingMultiSelect(ids);
    }
}
