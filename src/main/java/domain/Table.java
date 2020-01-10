package domain;

public class Table {
    private final int number;
    private final Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isNumber(final int number) {
        return this.number == number;
    }

    public void addOrder(Menu menu, Quantity quantity) {
        orders.add(menu, quantity);
    }
}
