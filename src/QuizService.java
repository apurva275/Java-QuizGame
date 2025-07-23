import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class QuizService {

    public List<Question> fetchQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            URL url = new URL("https://opentdb.com/api.php?amount=5&type=multiple");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json.toString());
            JSONArray results = (JSONArray) jsonObject.get("results");

            for (Object obj : results) {
                JSONObject questionJSON = (JSONObject) obj;

                String question = htmlDecode((String) questionJSON.get("question"));
                String correct = htmlDecode((String) questionJSON.get("correct_answer"));
                JSONArray incorrect = (JSONArray) questionJSON.get("incorrect_answers");

                List<String> options = new ArrayList<>();
                options.add(correct);
                for (Object wrong : incorrect) {
                    options.add(htmlDecode((String) wrong));
                }

                Collections.shuffle(options);
                questions.add(new Question(question, correct, options));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    // ✅ HTML Entity Decoder
    public static String htmlDecode(String input) {
        return input.replace("&quot;", "\"")
                    .replace("&amp;", "&")
                    .replace("&#039;", "'")
                    .replace("&rsquo;", "’")
                    .replace("&uuml;", "ü")
                    .replace("&lt;", "<")
                    .replace("&gt;", ">")
                    .replace("&eacute;", "é")
                    .replace("&ldquo;", "“")
                    .replace("&rdquo;", "”")
                    .replace("&hellip;", "…")
                    .replace("&shy;", "")
                    .replace("&ndash;", "–");
    }
}
