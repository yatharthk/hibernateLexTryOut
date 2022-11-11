package exercise.service;

import exercise.dao.DrivingLicenseDao;
import exercise.entity.DrivingLicense;

public class DrivingLicenseServiceImpl implements DriverLicenseService {

    private final DrivingLicenseDao drivingLicenseDao;
    public DrivingLicenseServiceImpl(DrivingLicenseDao drivingLicenseDao) {
        this.drivingLicenseDao=drivingLicenseDao;
    }

    @Override
    public Integer addRecords(DrivingLicense license) {
        return this.drivingLicenseDao.addRecord(license);
    }

    @Override
    public DrivingLicense read(Integer licenseNumber) {
        return this.drivingLicenseDao.getDetails(licenseNumber);
    }
}
