package shoppingList;

public class groceryItem {
    private String name;
    private String category;
    private int quantity;

    public groceryItem(String category, String name, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category.toLowerCase();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getCategory() {
        return this.category;
    }

}
