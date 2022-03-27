package level3.lesson3p1.thirdEx;

import java.util.ArrayList;

public class Box<T extends Fruit>{

    private int fruitsInBox;
    private float weightOfBox;
    private ArrayList<T> listFruits;

    public Box() {
        this.fruitsInBox = 0;
        this.weightOfBox = 0.0f;
        this.listFruits = new ArrayList<>();
    }

    @Override
    public String toString() {
        String fruitName = getListFruits().get(1).getNameFruit();
        return "Box with " + fruitName +
                " {" +
                "Вес = " + weightOfBox +
                ", кол-во фруктов = " + listFruits.size() +
                '}';
    }

    public void  addFruitInBox(T fruit, int n) {
        for (int i = 0; i < n; i++) {
            this.listFruits.add(fruit);
        }
        this.fruitsInBox = listFruits.size();
    }

    protected float getWeightBox() {
        if (!this.listFruits.isEmpty()){
            weightOfBox = this.getListFruits().size() *
                    listFruits.get(0).getWeightOfFruit();
            return this.weightOfBox;
        }
        else {
         return weightOfBox = 0;
        }
    }

    protected int getHowManyFruitsInBox() {
        this.fruitsInBox = listFruits.size();
        return fruitsInBox;
    }

    public void showInfoBox(){
        System.out.println("Фруктов в коробке: " + getHowManyFruitsInBox());
        System.out.println("Вес коробки: " + getWeightBox());
    }

    public boolean compareWeight(Box anotherBox) {
        return (Math.abs(this.getWeightBox() - anotherBox.getWeightBox()) < 0.0001f);
    }

    protected ArrayList<T> getListFruits() {
        return listFruits;
    }

    public void turnOutBoxIn(Box<T> b2){
        if (this.equals(b2)){
        }
        else {
            b2.getListFruits().addAll(this.listFruits);
            this.listFruits.clear();
        }
    }
}
