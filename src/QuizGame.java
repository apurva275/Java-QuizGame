import java.util.List;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        QuizService service = new QuizService();
        List<Question> questions = service.fetchQuestions();
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());

            List<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (1-4): ");
            int choice = scanner.nextInt();
            String selected = options.get(choice - 1);

            if (selected.equals(q.getCorrectAnswer())) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct: " + q.getCorrectAnswer());
            }
        }

        System.out.println("\n🎉 Game Over! Your Score: " + score + "/" + questions.size());
        scanner.close();
    }
}