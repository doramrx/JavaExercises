package WebSiteLogSystem;

import java.util.HashSet;
import java.util.Set;

public class LogSystem {
    private Set<LogEntry> users = new HashSet<>();

    void init() {
       DataCollector dataCollector = new DataCollector();
       dataCollector.collectData(users);

       System.out.println("Total users: " + countUsers(dataCollector.getFilePath()));
    }

    public Integer countUsers(String filePath){
        return this.users.size();
    }
}
