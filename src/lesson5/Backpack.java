package lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    public List<Item> bestItems = null;
    public int maxWeight;
    public int bestPrice;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, 50, "item1"));
        items.add(new Item(3, 15, "item2"));
        items.add(new Item(5, 25, "item3"));
        items.add(new Item(2, 35, "item4"));
        items.add(new Item(6, 95, "item5"));

        Backpack bp = new Backpack(10);
        bp.allSets(items);
        System.out.println(bp.getBestSet());

    }

    public int allWeight(List<Item> items) {
        int sumW = 0;
        for (Item i : items) {
            sumW = sumW + i.weight;
        }
        return sumW;
    }

    public int allPrice(List<Item> items) {
        int sumP = 0;
        for (Item i : items) {
            sumP = sumP + i.price;
        }
        return sumP;
    }

    public void checkSet(List<Item> items) {
        if (bestItems == null) {
            if (allWeight(items) <= maxWeight) {
                bestItems = items;
                bestPrice = allPrice(items);
            }
        } else {
            if(allWeight(items) <= maxWeight && allPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = allPrice(items);
            }
        }
    }

    public void allSets(List<Item> items) {
        if (items.size() > 0)
            checkSet(items);
        for (int i = 0; i < items.size(); i++) {
            List<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            allSets(newSet);
        }
    }

    public  List<Item> getBestSet() {
        return bestItems;
    }

    static class Item {
        public int weight;
        public int price;
        public String name;

        public Item(int weight, int price, String name) {
            this.weight = weight;
            this.price = price;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
