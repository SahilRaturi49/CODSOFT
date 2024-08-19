import java.util.Scanner;

public class Task2_StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int numberOfSubjects = sc.nextInt();
        if(numberOfSubjects == 0){
            System.out.println("Enter valid number of subjects");
            return;
        }

        int totalMarksObtained = 0;
        int maxMarks = 100;
        for (int i = 1; i <= numberOfSubjects; i++) {
            int marksObtained;

            while (true) {
                System.out.print("Marks obtained in Subject " + i + " (Out of 100): ");
                marksObtained = sc.nextInt();

                if (marksObtained >= 0 && marksObtained <= maxMarks) {
                    break;
                } else {
                    System.out.println("Please enter valid marks obtained (0-100).");
                }
            }

            totalMarksObtained += marksObtained;
        }



        System.out.println("Total marks obtained: " + totalMarksObtained);
        double averageMarksObtained = (double) totalMarksObtained/numberOfSubjects;
        System.out.println("Average percentage obtained: " + averageMarksObtained);


        String  grade;
        if(averageMarksObtained >=90){
            grade = "A+";
        } else if (averageMarksObtained >=80) {
            grade = "A";
        }else if (averageMarksObtained >=70) {
            grade = "B+";
        }else if (averageMarksObtained >=60){
            grade = "B";
        }else if (averageMarksObtained >=50) {
            grade = "C+";
        }else if (averageMarksObtained >=40 ) {
            grade = "C";
        }else if (averageMarksObtained >=33 ) {
            grade = "D";
        }else{
            grade = "F";
        }

        System.out.println("Grade: " + grade);

    }
}
