package org.example.service;

import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;

public interface TraineeService {

    void addTraineeWithoutDesktop(Trainee t);
    void addTraineeWithDesktop(Trainee t, DesktopEntity desktop);

    void allocateExistingDesktopToExistingTrainee(int traineeId,String desktopId);

    void allocateNewDesktopToTrainee(int id,DesktopEntity d);

    void deallocateDesktop(int traineeId);

    void deleteTraineeOnly(int id);
    void deleteTraineeAndDesktop(int id);

    Trainee getAllocationDetails(int id);

}
