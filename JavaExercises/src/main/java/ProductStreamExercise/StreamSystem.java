package ProductStreamExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StreamSystem {

    private final List<Product> products = new ArrayList<>();

    public void setupSystem() {
        Locale.setDefault(Locale.US);
    }

    public void init() throws FileNotFoundException {
        this.setupSystem();

        String filePath = "C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\ProductStreamExercise\\in.csv";
        this.addProductsToList(filePath);

        double average = this.getAverage(this.products);

        List<String> filteredProductNames = this.filterNames(this.products, average);

        System.out.printf("Average price: " + String.format("%.2f%n", average));
        filteredProductNames.forEach(System.out::println);
    }

    protected List<String> filterNames(List<Product> products, double average){
        return products.stream()
                .filter(p -> p.getPrice() < average)
                .map(Product::getName)
                .sorted(sortName().reversed())
                .toList();
    }

    protected double getAverage(List<Product> products){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
    }

    private Comparator<String> sortName(){
        return (p1, p2) -> p1.toUpperCase().compareTo(p2.toUpperCase());
    }

    private void addProductsToList(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                double price = Double.parseDouble(fields[1]);
                products.add(new Product(name, price));

                line = br.readLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
