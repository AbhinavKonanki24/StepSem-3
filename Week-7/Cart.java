public class Cart {
    private final String cartId;
    private final int[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[Math.max(0, maxItems)];
        this.count = 0;
    }

    public Cart(int maxItems) {
        this("CART-DEFAULT", maxItems);
    }

    public void addItem(int price) {
        if (price < 0) {
            System.out.println("Price cannot be negative");
            return;
        }
        if (count < prices.length) {
            prices[count++] = price;
        } else {
            System.out.println("Cart is full");
        }
    }

    public void addItem(double price) {
        addItem((int) Math.round(price));
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public String getId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
        System.out.println("cart.getId() -> " + cart.getId());
    }
}
