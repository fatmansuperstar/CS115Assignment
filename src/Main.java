import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        getSpecifications(); //Calls the getSpecifications method

        enterScores();
        
    }

    public static void getSpecifications(){
        System.out.println("Hello, and welcome to the grade calculator program.");
        System.out.println("To use this program, enter up to 10 of your quiz scores. ");
        System.out.println("The program will then compute your average quiz score, and assign you a letter grade.");
        System.out.println("The program will only allow up to 10 scores to be entered, but you may type '999' at any time to submit your entered scores.");
    }

    public static double[] enterScores(){
       double exitLoop = 0;
       Scanner scanner = new Scanner(System.in);
       double userInput;
       double[] grades = new double[10];
       
       while(exitLoop != 999){
            for (int i = 1; i <=10; i++){
                System.out.print("Enter a quiz grade: ");
                userInput = scanner.nextDouble();
                exitLoop = userInput;
                if(i == 10 || exitLoop == 999){
                    exitLoop = 999;
                    System.out.println("All grades entered.");
                    break;
                }
            }
       }
       return grades;
    }
}
