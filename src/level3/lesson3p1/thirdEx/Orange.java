package level3.lesson3p1.thirdEx;

public class Orange extends Fruit {

    private float weight;

    public Orange() {
        this.weight = 1.5f;
    }

    @Override
    public float getWeightOfFruit() {
        return this.weight;
    }

    @Override
    public String getNameFruit() {
        String[] parts = getClass().toString().split("\\.");
        String nameFruit = parts[parts.length-1]+"s";
        return nameFruit;
    }
}
