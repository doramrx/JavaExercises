package ProductStreamExercise;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamSystemTest {
    static StreamSystem streamSystem = new StreamSystem();
    static List<Product> list;

    @BeforeAll
    static void setUp() {
        streamSystem.setupSystem();
        list = new ArrayList<>(5);
        list.add(new Product("Tv", 800.0));
        list.add(new Product("Mouse", 20.0));
        list.add(new Product("Notebook", 750.0));
        list.add(new Product("HD", 370.0));
        list.add(new Product("Monitor", 140.0));
    }

    @Test
    @DisplayName("Should calculate average of prices correctly.")
    void testAverageCalc(){
        double avg = streamSystem.getAverage(list);
        avg = Double.parseDouble(String.format("%.2f", avg));
        assertEquals(avg, 416.00);
    }

    @Test
    @DisplayName("Should filter product names which prices are lesser than average of prices.")
    void testFilterProductsName(){
        List<String> filterNames = streamSystem.filterNames(list, streamSystem.getAverage(list));

        assertEquals(filterNames.size(), 3);
        assertEquals(filterNames.get(0), "Mouse");
        assertEquals(filterNames.get(1), "Monitor");
        assertEquals(filterNames.get(2), "HD");
    }
}
