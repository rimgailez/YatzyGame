import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DieTest {

    @Test
    public void testRollDie() {
        Die die = new Die();
        die.rollDie();
        assertTrue(die.number >= 1);
        assertTrue(die.number <= 6);
    }
}