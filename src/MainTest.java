import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCalculateFives() {
        Main main = new Main();
        Die[] dice = new Die[5];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die();
        }
        dice[0].number = 5;
        dice[1].number = 3;
        dice[2].number = 4;
        dice[3].number = 5;
        dice[4].number = 5;
        assertEquals(15, main.calculateFives(dice));
    }

    @Test
    void testCalculateChance() {
        Main main = new Main();
        Die[] dice = new Die[5];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die();
        }
        dice[0].number = 2;
        dice[1].number = 2;
        dice[2].number = 6;
        dice[3].number = 4;
        dice[4].number = 5;
        assertEquals(19, main.calculateChance(dice));
    }

    @Test
    void testCalculateOnePair() {
        Main main = new Main();
        Die[] dice = new Die[5];
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die();
        }
        dice[0].number = 2;
        dice[1].number = 2;
        dice[2].number = 4;
        dice[3].number = 2;
        dice[4].number = 4;
        assertEquals(8, main.calculateOnePair(dice));
    }
}