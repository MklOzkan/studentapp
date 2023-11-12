import java.util.Scanner;

public class Students {

    private static int id=1000;
    private String studentId;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String courses="";
    private static final int costOfCourse = 600;
    private int tutionBalance;

    public void setStudentId() {
        id++;
        this.studentId =gradeYear+""+id;// according to grade year and id, student id will be set
    }

    public Students(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student's first name:");
        this.firstName= scan.nextLine();
        System.out.println("Enter student's last name:");
        this.lastName = scan.nextLine();
        System.out.println("Enter student's class level: ");
        System.out.println("1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior");
        this.gradeYear = scan.nextInt();
        setStudentId();

        scan.close();
    }

    public void enroll(){
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter course to enroll (Q to quit)");
            String course = scan.nextLine();
            if (!course.equalsIgnoreCase("q")){
                courses =courses +"\n" + course ;
                tutionBalance += costOfCourse;
            }else {
                break;
            }
        }while (true);
        System.out.println("You enrolled in: " + courses);
    }

    public void payTution(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Your balance: $" + tutionBalance);
        System.out.println("How much do you want to pay?");
        int payment = scan.nextInt();
        tutionBalance = tutionBalance - payment;
        System.out.println("Thanks for payment of $" + payment);
        System.out.println("Your new tuition balance $" + tutionBalance);
    }
}
