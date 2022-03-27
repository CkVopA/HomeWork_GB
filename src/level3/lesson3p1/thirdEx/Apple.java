package level3.lesson3p1.thirdEx;

public class Apple extends Fruit {

    private float weight;

    public Apple() {
        this.weight = 1.0f;
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
