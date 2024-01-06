package items;

public class ItemStack {
    private Item item;
    private int amount;

    public ItemStack(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) throws RuntimeException {
        if (amount > item.getMaxAmount()) throw new RuntimeException("Amount exceeds max amount");
        if (amount < 0) throw new RuntimeException("Amount cant be less than 0");

        this.amount = amount;
    }
}
