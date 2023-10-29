package VoteCountSystem;

import java.io.IOException;
import java.util.Map;

public class VoteSystem {
    public void init() throws IOException {
        DataCollector dataCollector = new DataCollector();
        Map<String, Integer> collectedData = dataCollector.collectData();

        System.out.println("Total of Votes:");
        for(String key : collectedData.keySet()){
            System.out.println(key + ": " + collectedData.get(key));
        }
    }
}
