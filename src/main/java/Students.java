import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Students {

    private static int id=1000;
    private String studentId;
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String courses="";
    private static final int costOfCourse =600;
    private int tuitionBalance;

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
                tuitionBalance += costOfCourse;
            }else {
                break;
            }
            scan.close();
        }while (true);
        System.out.println("You enrolled in: " + courses);

    }

    public void payTuition(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Your balance: $" + tuitionBalance);
        System.out.println("How much do you want to pay?");
        int payment = scan.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thanks for payment of $" + payment);
        System.out.println("Your new tuition balance $" + tuitionBalance);
        scan.close();
    }

    @Override
    public String toString() {
        return
                "Student Id: '" + studentId + '\'' +
                ", Student Name: '" + firstName + " " +lastName +'\'' +
                ", Grade Level: " + gradeYear +
                ", Courses Enrolled: '" + courses + '\'' +
                ", Remaining Balance= " + tuitionBalance +
                '}';
    }

    static Map<String, String> studentInfo = new HashMap<>();

    public static void addStudentsMap(){
        Scanner scan = new Scanner(System.in);
        String stop = "";
        while (!stop.equalsIgnoreCase("s")){
            Students s = new Students();
            s.enroll();
            s.payTuition();
            studentInfo.put(s.studentId, s.toString());
            System.out.println("Press 'S' to stop entrance");
            System.out.println("Press Enter to go on entrance");
            stop = scan.nextLine();
        }
        scan.close();
    }

    public static void getStudentInformation(){
        Scanner scan = new Scanner(System.in);
        String idOfStudent;
        String result;
        do {
            System.out.println("Enter student id to get information");
            System.out.println("Enter x to end the program");
            idOfStudent=scan.nextLine();
            result = studentInfo.get(idOfStudent);
            if (!idOfStudent.equalsIgnoreCase("X")){
                System.out.println(result);
            }

        }while (!idOfStudent.equalsIgnoreCase("X"));
    }

    public static void removerStudent(){
        Scanner scan = new Scanner(System.in);
        String idOfStudent;
        String result;
        do {
            System.out.println("Enter student id to remove");
            System.out.println("Press 'X' to end the program");
            idOfStudent = scan.nextLine();
            result = studentInfo.remove(idOfStudent);
            if (idOfStudent.equalsIgnoreCase("x")){
                System.out.println(result);
                System.out.println("The student above is removed from the list");
            }

        }while (!idOfStudent.equalsIgnoreCase("x"));
    }
    public static void selectOptions(){
        System.out.println("""
                Select the options:
                1 - Add students:
                2 - Get the student's information by id:
                3 - Remove student by id:\s""");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();

        switch (option){
            case 1:
                addStudentsMap();
                break;
            case 2:
                getStudentInformation();
                break;
            case 3:
                removerStudent();
                break;
            default:
                System.out.println("valid option between 1 - 3");
        }
    }
}
