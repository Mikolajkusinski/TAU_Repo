package PeselTest;

import org.example.PeselValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    private final PeselValidator correctPesel = new PeselValidator("01212688891");
    private final PeselValidator incorrectPesel = new PeselValidator("1208142154");

    @Test
    void getDayShouldReturn26(){
        assertEquals(26,correctPesel.getBirthDay());
    }
    @Test
    void getMonthShouldReturnJan(){
        assertEquals(1,correctPesel.getBirthMonth());
    }
    @Test
    void getYearShouldReturn2001(){
        assertEquals(2001,correctPesel.getBirthYear());
    }

    @Test
    void getSexShouldReturnMan(){
        assertEquals("Man",correctPesel.getSex());
    }
    @Test
    void peselShouldBeValid(){
        assertTrue(correctPesel.isValid());
    }

    @Test
    void getDayShouldNotBeNull(){
        assertNotNull(incorrectPesel.getBirthDay());
    }
    @Test
    void getMonthShouldNotReturnMar(){
        assertNotEquals(3,correctPesel.getBirthMonth());
    }
    @Test
    void getYearShouldNotReturn2021(){
        assertNotEquals(2021,incorrectPesel.getBirthYear());
    }

    @Test
    void getSexShouldNotReturnMan(){
        assertNotEquals("Man",incorrectPesel.getSex());
    }
    @Test
    void peselShouldMotBeValid(){
        assertFalse(incorrectPesel.isValid());
    }
}
