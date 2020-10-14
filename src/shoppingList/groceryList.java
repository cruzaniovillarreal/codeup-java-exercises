
package shoppingList;

import util.Input;

import java.util.ArrayList;
import java.util.HashMap;

public class groceryList {
    private final String[] selectableCats = {"Fruit", "Bread", "Meat", "Vegetables", "Pantry", "Sweet", "Snacks", "Frozen"};
    private ArrayList<groceryItem> itemList;

    public groceryList() {
        this.itemList = new ArrayList<>();
    }

    public  ArrayList<groceryItem> getItems() {
        return this.itemList;
    }

    public void addItem() {
        for (String type : selectableCats) {
            System.out.print("|" + type + "|" + " ");
        }
        String itemCategory = new Input().getString("\nSelect a category from above for your new item: ");
        String itemName = new Input().getString("Name of item: ");
        int itemQty = new Input().getInt("Enter quantity: ");
        this.itemList.add(new groceryItem(itemCategory, itemName, itemQty)) ;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to List and Forget!");
        if (new Input().yesNo("Would you like to start a new list? [y/N]")) {
            groceryList newGroceryList = new groceryList();
            System.out.println("New list started!");
            while (true) {
                if (new Input().yesNo("Would you like enter a new item? [y/N]")) {
                    newGroceryList.addItem();
                    if (new Input().yesNo("Would you like to finalize this list? [y/N]")) {
                            break;
                    }
                }
            }
            for (groceryItem item : newGroceryList.itemList) {
                System.out.println("Name: "+item.getName()+" | Qty: "+item.getQuantity()+" | Category: "+item.getCategory());
            }
        } else {
            System.out.println("See ya!");
        }

    }
}
