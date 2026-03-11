import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

// Define Java classes corresponding to XML structure
@XmlRootElement(name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
class Books {
    @XmlElement(name = "book")
    private List<Book> books;

    // Getters and setters
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
class Book {
    // @XmlAttribute
    private int id;
    private String title;
    private String author;

    // Constructors
    public Book() {}

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

public class JAXBExample {
    public static void main(String[] args) throws Exception {
        // Sample XML file
        String xmlFile = "books.xml";

        // Create sample data
        Books books = new Books();
        books.setBooks(List.of(
            new Book(1, "Effective Java", "Joshua Bloch"),
            new Book(2, "Clean Code", "Robert C. Martin")
        ));

        // Writing XML using JAXB
        writeXML(books, xmlFile);

        // Reading XML using JAXB
        Books readBooks = readXML(xmlFile);
	readBooks.getBooks()
	    .stream()
	    .forEach(book -> System.out.printf("Book ID: %d%nTitle: %s%nAuthor:%s%n",
					       book.getId(),
					       book.getTitle(),
					       book.getAuthor()));
    }

    private static void writeXML(Books books, String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Books.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            marshaller.marshal(books, fileWriter);
        }

        System.out.println("XML written to " + fileName);
    }

    private static Books readXML(String fileName) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Books.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try (FileReader fileReader = new FileReader(fileName)) {
            return (Books) unmarshaller.unmarshal(fileReader);
        }
    }
}
