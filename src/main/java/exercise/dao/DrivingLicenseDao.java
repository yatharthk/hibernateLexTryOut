package exercise.dao;

import exercise.entity.DrivingLicense;

public interface DrivingLicenseDao {
    Integer addRecord(DrivingLicense license);

    DrivingLicense getDetails(Integer licenseNumber);
}
