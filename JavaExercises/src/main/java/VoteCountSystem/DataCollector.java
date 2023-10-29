package VoteCountSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataCollector {
    Scanner sc = new Scanner(System.in);
    public String filePath;

    public Map<String, Integer> collectData() {
        System.out.print("Enter file full path: ");
        this.filePath = this.sc.nextLine();

        return this.readVotesOfPeople();
    }

    private Map<String, Integer> readVotesOfPeople() {
        Map<String, Integer> votesByPeopleList = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))){
            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(",");
                String name = fields[0];
                int count = Integer.parseInt(fields[1]);

                if(votesByPeopleList.containsKey(name)){
                    int votes = votesByPeopleList.get(name);
                    votesByPeopleList.put(name, count + votes);
                } else {
                    votesByPeopleList.put(name, count);
                }

                line = br.readLine();
            }

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        return votesByPeopleList;
    }

}

//C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\VoteCountSystem\\in.csv

