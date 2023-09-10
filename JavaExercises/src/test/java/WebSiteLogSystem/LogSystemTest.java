package WebSiteLogSystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogSystemTest {

    @Test
    @DisplayName("Should count total users without repetition.")
    void testCountTotalUsersWithoutRepetition() {
        //Arrange
        String filePath = "C:\\Users\\Acer\\Desktop\\ProgramaçãoJava\\Workspace\\JavaExercises\\src\\main\\java\\WebSiteLogSystem\\in.txt";
        LogSystem logSystem = new LogSystem();

        //Act
        int totalUsers = logSystem.countUsers(filePath);

        //Assert
        assertEquals(4, totalUsers);
    }
}


