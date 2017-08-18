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
}
