import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JSONParserExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("books.json"));

            for (JsonNode book : rootNode.get("books")) {
                System.out.println("Title: " + book.get("title").asText());
                System.out.println("Author: " + book.get("author").asText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
