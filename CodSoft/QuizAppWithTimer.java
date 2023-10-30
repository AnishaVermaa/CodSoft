import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class QuizQuestion {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public QuizQuestion(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

public class QuizAppWithTimer {
    private static int score = 0;
    private static int questionNumber = 0;
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Program!");
        System.out.println("You have " + TIME_LIMIT + " seconds to answer each question.");

        List<QuizQuestion> quizQuestions = new ArrayList<>();

        // Add quiz questions, options, and correct answers to the list
        quizQuestions.add(new QuizQuestion("Number of primitive data types in Java are?",
                List.of("A) 6", "B) 7", "C) 8", "D) 9"), "C"));

        quizQuestions.add(new QuizQuestion("Automatic type conversion is possible in which of the possible cases?",
                List.of("A) Byte to Int", "B) Int to Long", "C) Long to Int", "D) Short to Int"), "B"));

        quizQuestions.add(new QuizQuestion("Select the valid statement.",
                List.of("A) char [] ch = new char();", "B) char [] ch = new char[5];", "C) char [] ch = new char(5);",
                        "D) char [] ch = new char[];"),
                "B"));

        quizQuestions.add(new QuizQuestion("When an array is passed to a method, what does the method receive?",
                List.of("A) The reference of the array", "B) Length of the array", "C) Copy of the array",
                        "D) Copy of the first element"),
                "A"));
        quizQuestions.add(new QuizQuestion("Arrays in java are-",
                List.of("A) Object reference", "B) objects", "C) Primitive data type", "D) none"), "B"));

        Timer timer = new Timer();

        for (QuizQuestion question : quizQuestions) {
            questionNumber++;
            System.out.println("Question " + questionNumber + ": " + question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            AnswerSubmissionTask submissionTask = new AnswerSubmissionTask(scanner, question.getCorrectAnswer());
            timer.schedule(submissionTask, TIME_LIMIT * 1000);

            System.out.print("Your choice (A/B/C/D): ");
            String userAnswer = scanner.next().toUpperCase();

            submissionTask.cancel(); // Stop the timer for answer submission

            if (userAnswer.equals(question.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.getCorrectAnswer());
            }

            System.out.println("Current Score: " + score + "/" + questionNumber);
        }

        System.out.println("Quiz completed!");
        System.out.println("Final Score: " + score + "/" + questionNumber);

        scanner.close();
        timer.cancel(); // Stop the timer
    }

    static class AnswerSubmissionTask extends TimerTask {
        private Scanner scanner;
        private String correctAnswer;

        public AnswerSubmissionTask(Scanner scanner, String correctAnswer) {
            this.scanner = scanner;
            this.correctAnswer = correctAnswer;
        }

        @Override
        public void run() {
            System.out.println("Time's up! You didn't answer in time.");
            System.out.println("The correct answer is " + correctAnswer);
            scanner.nextLine(); // Consume any input
        }
    }
}
