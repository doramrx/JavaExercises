package WebSiteLogSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

public class DataCollector {
    Scanner sc = new Scanner(System.in);
    private String filePath;

    public void collectData(Set<LogEntry> logEntries) {
        System.out.print("Enter file full path: ");
        this.filePath = this.sc.nextLine();
        this.readLogsToSetList(logEntries);
    }

    public String getFilePath(){
        return this.filePath;
    }

    private void readLogsToSetList(Set<LogEntry> logEntries) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {

                String[] fields =  line.split(" ");
                String username = fields[0];
                String stringDate = fields[1];
                LocalDateTime date = LocalDateTime.parse(stringDate, formatter);

                logEntries.add(new LogEntry(username, date));

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

//C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\WebSiteLogSystem\\in.txt

