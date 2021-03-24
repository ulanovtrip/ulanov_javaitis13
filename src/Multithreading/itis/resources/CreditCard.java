package Multithreading.itis.resources;

public class CreditCard {
    private int amount;

    public CreditCard(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean buy(int cost) {
        if (cost <= amount) {
            this.amount -= cost;
            return true;
        } else {
            System.out.println("No money");
            return false;
        }
    }
}
