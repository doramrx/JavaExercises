package WebSiteLogSystem;

import java.util.HashSet;
import java.util.Set;

public class LogSystem {
    private Set<LogEntry> users = new HashSet<>();
    private DataCollector dataCollector;

    public LogSystem() {
        this.dataCollector = new DataCollector();
    }

    void init() {
       this.users = dataCollector.collectData();

       System.out.println("Total users: " + countUsers());
    }

    public Integer countUsers(){
        return this.users.size();
    }

    protected void setDataCollector(DataCollector dataCollector) {
        this.dataCollector = dataCollector;
    }
}
