package tasks.first;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Order {
    private List<Item> items = new ArrayList<>();

    public Order() {
    }

    public Order(Item...items){
        for (Item item : items) {
           this.addItem(item);
        }
    }

    @Nullable
    public void addItem(Item item){
        if(Optional.ofNullable(item).isPresent()){
            this.items.add(item);
        }
    }

    public void printOrder(){
        for (Item item : items) {
            System.out.println(item.getItemName());
        }
    }
}
