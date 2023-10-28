package VoteCountSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VoteSystem {

    Map<String, Integer> totalVotes = new HashMap<>();

    public void init() throws IOException {
        DataCollector dataCollector = new DataCollector();
        dataCollector.collectData();

        this.countVotes(dataCollector.getFilePath());

        System.out.println("Total of Votes:");
        for(String key : totalVotes.keySet()){
            System.out.println(key + ": " + totalVotes.get(key));
        }
    }

    private void countVotes(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(this.totalVotes.containsKey(name)){
                    int votes = this.totalVotes.get(name);
                    this.totalVotes.put(name, count + votes);
                } else {
                    this.totalVotes.put(name, count);
                }

                line = br.readLine();
            }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
