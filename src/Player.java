public class Player {

    protected Integer fives;
    protected Integer chance;
    protected Integer onePair;

    public boolean thereAreEmptyScoreBoxes(){
        return fives == null || chance == null || onePair == null;
    }

    public int getTotalScore(){
        return fives + chance + onePair;
    }
}
