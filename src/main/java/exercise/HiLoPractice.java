package exercise;

import exercise.dao.DrivingLicenseDao;
import exercise.dao.DrivingLicenseDaoImpl;
import exercise.entity.DrivingLicense;
import exercise.service.DriverLicenseService;
import exercise.service.DrivingLicenseServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HiLoPractice {
    public static void main(String[] args) {
        System.out.println("HI-LO Gen-Strategy Exercise");
        DrivingLicenseDao drivingLicenseDao = new DrivingLicenseDaoImpl();
        DriverLicenseService service = new DrivingLicenseServiceImpl(drivingLicenseDao);
        List<Integer> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add Licenses");
        System.out.println("CREATING  DUMMY LICENSES");
        DrivingLicense license = new DrivingLicense(100111, "yk", 26, "M", "BLR", LocalDate.now(), LocalDate.now(), "blr");
        int id;
        for (int i = 0; i < 14; i++){
            System.out.println("Enter the name to print on license");
            String name = sc.nextLine();
            license.setName(name);
            id = service.addRecords(license);
            System.out.println("ADDED WITH ID "+id);
            if(id>0) {l.add(id);}
        }
        System.out.println("All details in db");
        l.forEach(x-> System.out.println(service.read(x)));

    }
}
