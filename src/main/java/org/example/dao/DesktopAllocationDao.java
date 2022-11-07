package org.example.dao;

import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;

public interface DesktopAllocationDao {
    void addTraineeWithoutDesktop(Trainee t);

    void addTraineeWithDesktop(Trainee t, DesktopEntity desktop);

    void allocateExistingDesktopToExistingTrainee(int traineeId, String deskTopId);

    void allocateDesktopToNewTrainee(int trainee_id, DesktopEntity d);

    void deallocateDesktop(int traineeId);

    void deleteTraineeOnly(int traineeId);

    void deleteTraineeAndDesktop(int traineeId);

    Trainee getAllocationDetails(int id);
}
