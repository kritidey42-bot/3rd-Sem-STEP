import java.util.Scanner;

abstract class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer,
                    String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();

    public abstract String getQuestionType();
}

class MCQQuestion extends Question {

    public MCQQuestion(String questionText, String correctAnswer,
                       String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }

    @Override
    public String getQuestionType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {

    public TFQuestion(String questionText, String correctAnswer,
                      String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }
        return 0;
    }

    @Override
    public String getQuestionType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(String questionText, String correctAnswer,
                         String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public double grade() {

        String answer = studentAnswer.toLowerCase();

        String[] keywords = correctAnswer.split(",");

        int matchedKeywords = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } 
        else if (matchedKeywords == 1) {
            return points * 0.50;
        } 
        else {
            return 0;
        }
    }

    @Override
    public String getQuestionType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            double points = Double.parseDouble(parts[6].trim());

            if (type.equals("MCQ")) {
                questions[i] = new MCQQuestion(
                    questionText,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            }
            else if (type.equals("TF")) {
                questions[i] = new TFQuestion(
                    questionText,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            }
            else if (type.equals("ESSAY")) {
                questions[i] = new EssayQuestion(
                    questionText,
                    correctAnswer,
                    studentAnswer,
                    points
                );
            }
        }

        double totalScore = 0;

        for (Question question : questions) {

            double score = question.grade();

            System.out.printf(
                "%s: %.2f%n",
                question.getQuestionType(),
                score
            );

            totalScore += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }
}
