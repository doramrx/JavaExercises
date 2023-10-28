package ProductStreamExcercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StreamSystem {

    private List<Product> products = new ArrayList<>();
    private String filePath = "C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\StreamExcercise\\in.csv";

    public void init() throws FileNotFoundException {
        this.addProductsToList(filePath);

        double average = this.getAverage(this.products);

        Collections.sort(products, (p1, p2) -> (p2.getName().compareTo(p1.getName())));
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getPrice() < average)
                .toList();

        System.out.printf("Average price: " + String.format("%.2f%n", average));
        filteredProducts.forEach(e -> System.out.println(e.getName()));
    }

    private double getAverage(List<Product> products){
        return products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
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
