import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static String[][] questions = {
        {"What is the capital of India?", "1) Maharashtra", "2)New Delhi", "3) Bengaluru", "4) Rajasthan"},
        {"Which planet is known as the Red Planet?", "1) Mars", "2) Jupitar", "3)Venus ", "4) Mercury"},
        {"What is the Chemical symbol for gold?", "1) Fe", "2) He", "3) Au", "4) Ag"}
    };
    private static int[] correctAnswers = {2, 1, 3}; 
    private static int[] userAnswers = new int[questions.length];
    private static int score = 0;
    private static int questionIndex = 0;
    private static Timer timer;
    private static final int TIME_LIMIT = 5; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
            displayQuestion(questionIndex);
            startTimer(scanner);
        }

        displayResults();
        scanner.close();
    }

    private static void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ": " + questions[index][0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(questions[index][i]);
        }
    }

    private static void startTimer(Scanner scanner) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                userAnswers[questionIndex] = 0; 
                checkAnswer(0);
            }
        }, TIME_LIMIT * 1000);

        System.out.print("Your answer (1-4): ");
        if (scanner.hasNextInt()) {
            int answer = scanner.nextInt();
            timer.cancel();
            userAnswers[questionIndex] = answer;
            checkAnswer(answer);
        } 
        else
         {
            scanner.next(); 
            timer.cancel();
            System.out.println("Invalid input! Moving to next question.");
        }
    }

    private static void checkAnswer(int answer) {
        if (answer == correctAnswers[questionIndex]) {
            score++;
        }
    }

    private static void displayResults() {
        System.out.println("\nQuiz Over!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        System.out.println("Summary:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            System.out.println("Your answer: " + (userAnswers[i] == 0 ? "No answer" : questions[i][userAnswers[i]]));
            System.out.println("Correct answer: " + questions[i][correctAnswers[i]]);
        }
    }
}