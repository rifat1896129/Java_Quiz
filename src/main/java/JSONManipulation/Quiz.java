package JSONManipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        JSONParser jsonParser = new JSONParser();

        // Load users
        JSONArray userArray = (JSONArray) jsonParser.parse(new FileReader("./src/main/resources/users.json"));

        System.out.print("System:> Enter your username\nUser:> ");
        String inputUsername = scanner.nextLine();

        System.out.print("System:> Enter password\nUser:> ");
        String inputPassword = scanner.nextLine();

        boolean isAdmin = false;

        for (Object obj : userArray) {
            JSONObject user = (JSONObject) obj;

            String username = user.get("username").toString();
            String password = user.get("password").toString();
            String role = user.get("role").toString();

            if (username.equals(inputUsername) && password.equals(inputPassword)) {
                if (role.equalsIgnoreCase("admin")) {
                    isAdmin = true;
                }
                if (isAdmin) {
                    System.out.println("System:> Welcome admin! Please create new questions in the question bank.");
                    startAdminQuestionInput(scanner);
                } else {
                    System.out.println("System:> Welcome " + username + " to the quiz! We will throw you 10 questions");
                    startStudentQuiz(scanner);
                }

                return;
            }
        }

        System.out.println("System:> Invalid username or password.");
    }

    private static void startAdminQuestionInput(Scanner scanner) throws IOException, ParseException {
        String choice;
        File quizFile = new File("./src/main/resources/quiz.json");

        // Load existing questions if file exists
        JSONArray questionArray;
        if (quizFile.exists()) {
            JSONParser parser = new JSONParser();
            try (FileReader reader = new FileReader(quizFile)) {
                Object obj = parser.parse(reader);
                questionArray = (JSONArray) obj;
            } catch (Exception e) {
                questionArray = new JSONArray(); // if parsing fails, start fresh
            }
        } else {
            questionArray = new JSONArray();
        }

        do {
            JSONObject questionObj = new JSONObject();

            System.out.print("System:> Input your question\nAdmin:> ");
            String question = scanner.nextLine();
            questionObj.put("question", question);

            JSONArray options = new JSONArray();
            for (int i = 1; i <= 4; i++) {
                System.out.print("System:> Input option " + i + ":\nAdmin:> ");
                String option = scanner.nextLine();
                options.add(option);
            }
            questionObj.put("options", options);

            System.out.print("System:> What is the answer key?\nAdmin:> ");
            int answerKey = Integer.parseInt(scanner.nextLine());
            questionObj.put("answer", answerKey);

            // Add to array
            questionArray.add(questionObj);
            System.out.println("System:> Saved successfully!");

            System.out.print("System:> Do you want to add more questions? (press 's' to start, 'q' to quit)\nAdmin:> ");
            choice = scanner.nextLine().toLowerCase();
        } while (!choice.equals("q"));

        // Save all questions to file
        try (FileWriter writer = new FileWriter(quizFile)) {
            writer.write(questionArray.toJSONString());
            writer.flush();
        }
    }

    private static void startStudentQuiz(Scanner scanner) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray questionArray;

        File quizFile = new File("./src/main/resources/quiz.json");

        // Load question bank
        if (!quizFile.exists()) {
            System.out.println("System:> No questions found in the quiz bank.");
            return;
        }

        questionArray = (JSONArray) jsonParser.parse(new FileReader(quizFile));

        if (questionArray.isEmpty()) {
            System.out.println("System:> Quiz question bank is empty.");
            return;
        }

        String playAgain;
        do {
            int score = 0;

            System.out.println("System:> Starting the quiz. Answer 10 questions!");

            for (int i = 1; i <= 10; i++) {
                // Pick a random question
                int index = (int) (Math.random() * questionArray.size());
                JSONObject questionObj = (JSONObject) questionArray.get(index);

                String question = questionObj.get("question").toString();
                JSONArray options = (JSONArray) questionObj.get("options");
                long answerKey = (long) questionObj.get("answer");  // stored as long in JSON

                System.out.println("\nSystem:> [Question " + i + "] " + question);
                for (int j = 0; j < options.size(); j++) {
                    System.out.println((j + 1) + ". " + options.get(j));
                }

                System.out.print("Student:> ");
                String input = scanner.nextLine();

                int studentAnswer;
                try {
                    studentAnswer = Integer.parseInt(input);
                } catch (Exception e) {
                    studentAnswer = -1; // invalid answer
                }

                if (studentAnswer == (int) answerKey) {
                    score++;
                }
            }

            // Show final result
            System.out.println("\n🧾 Your Score: " + score + " out of 10");
            if (score >= 8) {
                System.out.println("System:> Excellent! You have got " + score + " out of 10");
            } else if (score >= 5) {
                System.out.println("System:> Good. You have got " + score + " out of 10");
            } else if (score >= 3) {
                System.out.println("System:> Very poor! You have got " + score + " out of 10");
            } else {
                System.out.println("System:> Very sorry you are failed. You have got " + score + " out of 10");
            }

            System.out.print("\nSystem:> Would you like to start again? Press 's' for start or 'q' for quit\nStudent:> ");
            playAgain = scanner.nextLine().toLowerCase();

        } while (playAgain.equals("s"));
    }

}
