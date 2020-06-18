import java.util.Random;

public class Die {

    private Random random = new Random();
    protected int number;

    public void rollDie(){
        number = random.nextInt(6) + 1;
    }

}
