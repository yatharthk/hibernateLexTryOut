package org.example;

import org.example.dao.DesktopAllocationDao;
import org.example.dao.DesktopAllocationDaoImpl;
import org.example.entity.DesktopEntity;
import org.example.entity.Trainee;
import org.example.service.TraineeService;
import org.example.service.TraineeServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

        DesktopAllocationDao dao = new DesktopAllocationDaoImpl();
        TraineeService traineeService = new TraineeServiceImpl(dao);

        while (true) {
            System.out.println("Enter the choice from below");
            System.out.println(" 1. Add Trainee\n 2.Add trainee and Desktop\n 3.Allocate Existing Desktop");
            System.out.println(" 4. Allocate new Desktop to existing trainee");
            System.out.println(" 5. Deallocate Desktop");
            System.out.println(" 6. Delete Trainee only\n 7. Delete Trainee and Desktop");
            System.out.println(" 8. Get Allocation Details\n 9. Exit");
            System.out.println("\nEnter your choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Add a trainee");
//                    Trainee t = new Trainee(1, "yk", null);
//                      if Entity doesn't have auto_increment pass the id
//                      else either use setter getter or pass id as null
                    Trainee t = new Trainee(null, "yk", null);
//                    Trainee t = new Trainee();
//                    t.setName("yk");
//                    t.setDesktop(null);
                    traineeService.addTraineeWithoutDesktop(t);
                    break;

                case 2:
                    System.out.println("Add a trainee and desktop");
//                    Trainee t2 = new Trainee(4, "yk", null);
                    Trainee t2 = new Trainee(null, "yk", null);
                    DesktopEntity d = new DesktopEntity("dell102", 2021);
                    traineeService.addTraineeWithDesktop(t2, d);
                    break;

                case 3:
                    System.out.println("Allocate Existing Desktop to Existing Trainee");
                    System.out.println("Enter the trainee id");
                    int traineeId = sc.nextInt();
                    System.out.println("enter the desktop id to be allocated");
                    String desktopId = sc.next();
                    traineeService.allocateExistingDesktopToExistingTrainee(traineeId, desktopId);
                    break;

                case 4:
                    System.out.println("Allocate new Desktop to existing trainee");
                    System.out.println("Enter the trainee id");
                    int id = sc.nextInt();
                    DesktopEntity entity = new DesktopEntity("HP102", 2021);
                    traineeService.allocateNewDesktopToTrainee(id, entity);
                    break;
                case 5:
                    System.out.println("Deallocate Desktop");
                    System.out.println("Enter the trainee id");
                    int tId = sc.nextInt();
                    traineeService.deallocateDesktop(tId);
                    break;
                case 6:
                    System.out.println("Delete Trainee only");
                    System.out.println("Enter the trainee id");
                    tId = sc.nextInt();
                    traineeService.deleteTraineeOnly(tId);
                    break;
                case 7:
                    System.out.println("Delete Trainee and Desktop");
                    System.out.println("Enter the trainee id");
                    tId = sc.nextInt();
                    traineeService.deleteTraineeAndDesktop(tId);
                    break;
                case 8:
                    System.out.println("Get Allocation Details");
                    System.out.println("Enter the trainee id");
                    tId = sc.nextInt();
                    System.out.println(traineeService.getAllocationDetails(tId));
                    break;
                case 9:
                    System.out.println("Exit the program");
                    System.exit(1);
                    break;
                default:
                    System.out.println("invalid choice");
                    break;

            }
        }
    }
}