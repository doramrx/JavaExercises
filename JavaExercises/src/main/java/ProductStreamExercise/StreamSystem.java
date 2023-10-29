package ProductStreamExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class StreamSystem {

    private final List<Product> products = new ArrayList<>();

    public void setupSystem() {
        Locale.setDefault(Locale.US);
    }

    public void init() throws FileNotFoundException {
        this.setupSystem();

        Path filePath = Paths.get("JavaExercises", "src", "main", "java", "ProductStreamExercise").resolve("in.csv");
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
        return Comparator.comparing(String::toUpperCase);
    }

    private void addProductsToList(Path filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath.toFile()))){
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
