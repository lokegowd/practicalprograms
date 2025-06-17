import java.util.Scanner;

class Question {
    String question, optionA, optionB, optionC, optionD;
    char correctOption;

    public Question(String question, String optionA, String optionB, String optionC, String optionD, char correctOption) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = Character.toUpperCase(correctOption);
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
        System.out.print("Your answer (A/B/C/D): ");
        char answer = Character.toUpperCase(sc.next().charAt(0));
        return answer == correctOption;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        Question[] questions = {
            new Question("What is the capital of India?", "Mumbai", "Delhi", "Chennai", "Kolkata", 'B'),
            new Question("Which language runs in a web browser?", "Java", "C", "Python", "JavaScript", 'D'),
            new Question("Which company developed Java?", "Apple", "Microsoft", "Sun Microsystems", "Oracle", 'C'),
            new Question("What is the value of Pi?", "3.14", "2.17", "1.61", "4.44", 'A'),
            new Question("Who is the founder of Microsoft?", "Larry Page", "Elon Musk", "Steve Jobs", "Bill Gates", 'D')
        };

        System.out.println("Welcome to the Quiz!\n");

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong.");
            }
        }

        System.out.println("\n🎯 Quiz Over! You scored " + score + " out of " + questions.length);
        sc.close();
    }
}
