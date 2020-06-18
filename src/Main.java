import java.util.Scanner;

public class Main {

    private static Player player = new Player();
    private static int sumOfFives;
    private static int sumOfChance;
    private static int sumOfOnePair;

    public static void main(String[] args) {
        Die[] dice = new Die[5];
        System.out.println("Welcome!");
        for(int i = 0; i < 5; i++){
            dice[i] = new Die();
        }
        while(player.thereAreEmptyScoreBoxes()){
            System.out.println("Roll dice: ");
            rollDice(dice);
            System.out.println("Do you want to roll dice one more time? (You have 2 throws left) 0 - no, 1 - yes");
            Scanner input = new Scanner(System.in);
            if (input.nextInt() == 1){
                System.out.println("Write the numbers of dice that you want to rethrow:");
                rethrowDice(dice);
                System.out.println("Do you want to roll dice one more time? (You have 1 throws left) 0 - no, 1 - yes");
                if (input.nextInt() == 1){
                    System.out.println("Write the numbers of dice that you want to rethrow:");
                    rethrowDice(dice);
                    fillInScoreBox(dice);
                } else {
                    fillInScoreBox(dice);
                }
            } else {
                fillInScoreBox(dice);
            }
        }
        System.out.println("The game ended. Your total score: " + player.getTotalScore());
    }

    public static void rollDice(Die[] dice){
        for(Die aDie: dice){
            aDie.rollDie();
        }
        printNumbers(dice);
    }

    public static void rollSpecificDice(int[] numbersOfDice, Die[] dice){
        for(int i = 0; i < dice.length; i++){
            for (int i1 : numbersOfDice) {
                if (i == i1) {
                    dice[i].rollDie();
                }
            }
        }
        printNumbers(dice);
    }

    public static void printNumbers(Die[] dice){
        for(Die aDie: dice){
            System.out.print(aDie.number + " ");
        }
        System.out.print("\n");
    }

    public static void rethrowDice(Die[] dice){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] elements = line.split(" ");
        int[] numbers = new int[elements.length];
        for(int i = 0; i < elements.length; i++){
            numbers[i] = Integer.parseInt(elements[i]) - 1;
        }
        rollSpecificDice(numbers, dice);
    }

    public static int calculateFives(Die[] dice){
        int sum = 0;
        for(Die aDie: dice){
            if(aDie.number == 5){
                sum = sum + aDie.number;
            }
        }
        return sum;
    }

    public static int calculateChance(Die[] dice){
        int sum = 0;
        for(Die aDie: dice){
            sum = sum + aDie.number;
        }
        return sum;
    }

    public static int calculateOnePair(Die[] dice){
        int[] sum = new int[6];
        int[] count = new int[6];
        int result = 0;
        for(int i = 0;i < sum.length; i++){
            sum[i] = 0;
            count[i] = 0;
        }
        for(Die aDie: dice){
            if(count[aDie.number-1] < 2){
                count[aDie.number-1]++;
                sum[aDie.number-1] = sum[aDie.number-1] + aDie.number;
            }
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == 2 && sum[i] > result){
                result = sum[i];
            }
        }
        return result;
    }

    public static void fillInScoreBox(Die[] dice){
        Scanner in = new Scanner(System.in);
        sumOfFives = calculateFives(dice);
        sumOfChance = calculateChance(dice);
        sumOfOnePair = calculateOnePair(dice);
        System.out.println("Choose the score box which you want to fill:");
        if(player.fives == null) {
            System.out.println("1. Fives: " + sumOfFives);
        }
        if(player.chance == null) {
            System.out.println("2. Chance: " + sumOfChance);
        }
        if(player.onePair == null) {
            System.out.println("3. One Pair: " + sumOfOnePair);
        }
        System.out.println("Your choice:");
        int choice = in.nextInt();
        if(choice == 1 && player.fives == null){
            player.fives = sumOfFives;
        }
        if(choice == 2 && player.chance == null){
            player.chance = sumOfChance;
        }
        if(choice == 3 && player.onePair == null){
            player.onePair = sumOfOnePair;
        }
    }
}
