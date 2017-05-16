/**
 * Created by IT on 2017/5/11.
 */
import java.util.*;

public enum Dish {
    PORK("Ingrediant", "pork,cabbage,carrot"),FISH("Ingrediant","fish, green onion"),BEEF("Ingrediant","beef, tomatoes"),SOUP("Ingrediant", "eggs, water");

    private String ingrediant;
    private String food;

    private Dish(String food, String ingrediant){
        this.ingrediant = ingrediant;
        this.food = food;
    }

    public static void  obtainIngrediant(Dish[] dishes){
        for(Dish dish : dishes){
            System.out.println(dish.name());
            System.out.println(dish.ingrediant);

        }
    }

    public static void main(String[] args){
        Dish[] dish = {Dish.PORK,Dish.FISH};
        Dish.obtainIngrediant(dish);
    }
}
