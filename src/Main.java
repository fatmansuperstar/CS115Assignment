import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) throws Exception {

        //Declares the variables that will be used to store user information
        double[] userQuizScores = new double[10];
        double avgQuizScores = 0;
        char letterGrade;

        getSpecifications(); //Calls the getSpecifications method

        //Calls the enterScores() method and saves it in the variable userQuizScores
        userQuizScores = enterScores();
        System.out.println("The quiz scores you entered were " + Arrays.toString(userQuizScores));

        //Calls the calculateAvgQuizScore() method and passes userQuizScores as the argument. Saves it to the variable avgQuizScores.
        avgQuizScores = calculateAvgQuizScore(userQuizScores);
        System.out.println("Average quiz score is equal to " + avgQuizScores + "%");

        //Calls the calculateLetterGrade() method and passes avgQuizScores as the argument. Saves letter grade in variable letterGrade.
        letterGrade = calculateLetterGrade(avgQuizScores);
        System.out.println("You letter grade: " + letterGrade);



        
    }

    public static void getSpecifications(){
        System.out.println("Hello, and welcome to the grade calculator program.");
        System.out.println("To use this program, enter up to 10 of your quiz scores. ");
        System.out.println("The program will then compute your average quiz score, and assign you a letter grade.");
        System.out.println("The program will only allow up to 10 scores to be entered, but you may type '999' at any time to submit your entered scores.");
    }

    public static double[] enterScores(){
       double exitLoop = 0; //This variable will be used to test whether or not the loop for entering scores should be exited
       Scanner scanner = new Scanner(System.in);
       double userInput; //Variable to store what the user enters
       double[] grades = new double[10]; //Creates an array of 10 buckets 
       
       
       while(exitLoop != 999){ //While the user does not enter 999, keep asking for quiz scores
            for (int i = 1; i <=10;){ //For loop to ask for a maximum of 10 quiz socres
                try{
                System.out.print("Enter a quiz grade: ");
                userInput = scanner.nextDouble(); //Store what the user enters
                 exitLoop = userInput; //Store what the user enters in the exitLoop variable
                if(i == 10 || exitLoop == 999){ //If 10 scores have been entered or the user entered 999
                    exitLoop = 999; //Breaks out of the while loop
                    System.out.println("All grades entered.");
                    break; //Breaks out of the for loop
                }
                else if(userInput < 0){ //If user enters a grade less than 0%
                    System.out.println("You can not have a negative quiz score. Please try again");
                    scanner.nextLine(); //Clear their answer and ask again
                }
                else{ //If the score they entered is valid
                i++; //Increment the number of quiz that they are entering
                grades[i-1] = userInput; //save the quiz score in the grades Array
                }
                
            }catch(InputMismatchException e){ //Catches the error of the user not entering a number
                System.out.println("You must enter a valid quiz score.");
                scanner.nextLine(); //Clear their answer and ask again
            }
            }
       }
       
       return grades; //Returns their array of grades
    }

    public static double calculateAvgQuizScore(double[] quizScores){
        //local variables declared and initialized
        double averageQuizScore = 0;
        double totalQuizScore = 0;
        int quizCount = 0;

        for(int i = 0; i < quizScores.length; i++){ //For each quiz score
            totalQuizScore += quizScores[i]; //Add the quiz scores up
            if(quizScores[i] != 0){ //Only add quiz attempts for the number of quizzes they actually took
                quizCount++;
            }
        }

        averageQuizScore = totalQuizScore/quizCount; //calculate average quiz score

        
        return averageQuizScore; //return average quiz score
    }

    public static char calculateLetterGrade(double averageQuizScore){
        //Declare and initialize letterGrade
        char letterGrade = 'F';

        //If statements granting a letter grade depending on what the average score is
        if(averageQuizScore > 89 && averageQuizScore <= 100){
            letterGrade = 'A';
        }
        else if(averageQuizScore > 79 && averageQuizScore <= 89){
            letterGrade = 'B';
        }
        else if (averageQuizScore > 69 && averageQuizScore <= 79){
            letterGrade = 'C';
        }
        else if (averageQuizScore > 59 && averageQuizScore <= 69){
            letterGrade = 'D';
        }
        else{
            letterGrade = 'F';
        }

        return letterGrade; //return letter grade
    }
}
