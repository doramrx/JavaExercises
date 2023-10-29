package WebSiteLogSystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LogSystemTest {
    @Spy
    LogSystem logSystem;
    @Mock
    DataCollector dataCollector;

    @Test
    @DisplayName("Should count total users without repetition.")
    void testCountTotalUsersWithoutRepetition() {
        //Arrange
        Set<LogEntry> input = new HashSet<>();
        input.add(new LogEntry("Test 1", LocalDateTime.now()));
        input.add(new LogEntry("Test 2", LocalDateTime.now()));
        input.add(new LogEntry("Test 3", LocalDateTime.now()));
        input.add(new LogEntry("Test 4", LocalDateTime.now()));

        doReturn(input).when(this.dataCollector).collectData();
        this.logSystem = new LogSystem();
        this.logSystem.setDataCollector(this.dataCollector);

        //Act
        logSystem.init();

        //Assert
        assertEquals(4, this.logSystem.countUsers());
        verify(this.dataCollector, atMostOnce()).collectData();
    }
}


