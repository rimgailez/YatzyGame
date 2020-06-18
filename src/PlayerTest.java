import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void TestThereAreEmptyScoreBoxes() {
        Player player = new Player();
        assertTrue(player.thereAreEmptyScoreBoxes());
        player.fives = 10;
        assertTrue(player.thereAreEmptyScoreBoxes());
        player.chance = 20;
        assertTrue(player.thereAreEmptyScoreBoxes());
        player.onePair = 12;
        assertFalse(player.thereAreEmptyScoreBoxes());
    }
}