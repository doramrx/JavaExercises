package WebSiteLogSystem;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogSystem {
    void init() {
       DataCollector dataCollector = new DataCollector();
       dataCollector.collectData();

       DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
       Set<LogEntry> users = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(dataCollector.getFilePath()))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields =  line.split(" ");
                String username = fields[0];
                String stringDate = fields[1];
                LocalDateTime date = LocalDateTime.parse(stringDate, formatter);

                users.add(new LogEntry(username, date));

                line = br.readLine();
            }

            System.out.println("Total users: " + users.size());

       } catch (IOException e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
}
