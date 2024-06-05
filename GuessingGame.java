import java.util.Random;
import java.util.Scanner;
public class GuessingGame{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        boolean playAgain=true;
        int roundsWon=0;
        int totalAttempts=0;
        System.out.println("Welcome to the number guessing game!");
        while(playAgain){
            int targetNumber=random.nextInt(100)+1;
            int attempts=0;
            boolean hasGuessedCorrectly=false;
            System.out.println("i have generated a number between 1 and 100.try to guess it !");
            while(!hasGuessedCorrectly && attempts<10){
                System.out.print("enter your guess:");
		int userGuess=scanner.nextInt();
attempts++;
totalAttempts++;
if(userGuess<targetNumber)
{
System.out.println("Too low! try again.");
            }
            else if (userGuess>targetNumber) {
                System.out.println("too high! try again.");
                
            }
else
{
System.out.println("congratulations!you've guessed the number.");
hasGuessedCorrectly=true;
roundsWon++;
        }
if(attempts==10&&!hasGuessedCorrectly)
{
System.out.println("sorry,you've used all 10 attempts.the number was"+targetNumber+".");
}
}
System.out.print("do you want to play again?(yes/no):");
String response=scanner.next();
playAgain=response.equalsIgnoreCase("yes");
 }
System.out.println("thanks for playing!");
System.out.println("rounds won:"+roundsWon);
System.out.println("total attempts:"+totalAttempts);
scanner.close();
}
}