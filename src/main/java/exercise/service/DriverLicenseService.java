package exercise.service;

import exercise.entity.DrivingLicense;

public interface DriverLicenseService {
     Integer addRecords(DrivingLicense license);
    DrivingLicense read(Integer licenseNumber);
}
