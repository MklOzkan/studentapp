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
}
