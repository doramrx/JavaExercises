package VoteCountSystem;

import java.util.Scanner;

public class DataCollector {
    Scanner sc = new Scanner(System.in);
    public String filePath;

    public void collectData() {
        System.out.print("Enter file full path: ");
        this.filePath = this.sc.nextLine();
    }

    public String getFilePath(){
        return this.filePath;
    }
}

//C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\VoteCountSystem\\in.csv

