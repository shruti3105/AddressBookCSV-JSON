import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonFile {
    private static Path jsonFilePath = Path.of("C://Users//tanya//Desktop//AddressBoook//AddressBook.json");
    public static void main(String []args) throws IOException {
        List<AddressBook>addressBooks = new ArrayList<>();
        readDataFromJSONFile(addressBooks);
        writeDataInJSONFile(addressBooks);
    }

    public static void writeDataInJSONFile(List<AddressBook> addressBook) throws IOException {

        try (Writer writer = Files.newBufferedWriter(jsonFilePath)) {
            Gson gson = new Gson();
            String json = gson.toJson(addressBook);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AddressBook> readDataFromJSONFile(List<AddressBook>addressBooks) throws IOException {

        try (Reader reader = Files.newBufferedReader(jsonFilePath)) {
            Gson gson = new Gson();
            AddressBook[] contactObject = gson.fromJson(reader, AddressBook[].class);
            List<AddressBook> addressBook = Arrays.asList(contactObject);
            return addressBook;
        }
    }
}
