package christhomps.example.christianthompson.mygrocerylist.Model;

/**
 * Created by Christian Thompson on 8/18/2017.
 */

public class Grocery {

    private String name;
    private String groceryQty;
    private String dateItemAdded;
    private int id;

    public Grocery() {
    }

    public Grocery(String name, String groceryQty, String dateItemAdded, int id) {
        this.name = name;
        this.groceryQty = groceryQty;
        this.dateItemAdded = dateItemAdded;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroceryQty() {
        return groceryQty;
    }

    public void setGroceryQty(String groceryQty) {
        this.groceryQty = groceryQty;
    }

    public String getDateItemAdded() {
        return dateItemAdded;
    }

    public void setDateItemAdded(String dateItemAdded) {
        this.dateItemAdded = dateItemAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
