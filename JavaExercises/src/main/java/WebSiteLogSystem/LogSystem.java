package WebSiteLogSystem;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LogSystem {
    Set<LogEntry> users = new HashSet<>();

    void init() {

       DataCollector dataCollector = new DataCollector();
       dataCollector.collectData();

       System.out.println("Total users: " + countUsers(dataCollector.getFilePath()));

    }

    public Integer countUsers(String filePath){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();
            while (line != null) {

                String[] fields =  line.split(" ");
                String username = fields[0];
                String stringDate = fields[1];
                LocalDateTime date = LocalDateTime.parse(stringDate, formatter);

                this.users.add(new LogEntry(username, date));

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return this.users.size();
    }
}
