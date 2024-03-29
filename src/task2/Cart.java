package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    //endregion

    /**
     * Балансировка корзины
     */
    public void cardBalancing(){
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);

        market.getThings(clazz).stream()
                .filter(a -> !a.getProteins() || !a.getFats() || !a.getCarbohydrates())
                .forEach(thing -> {
                    if(!foodstuffs.contains(thing))
                        foodstuffs.add(thing);
                });

        foodstuffs.stream()
                .filter(a -> !a.getProteins() || !a.getFats() || !a.getCarbohydrates())
                .forEach(food -> {
                    if(food.getProteins())
                        proteins.set(true);
                    else if(food.getFats())
                        fats.set(true);
                    else
                        carbohydrates.set(true);
                        });

        if (proteins.get() && fats.get() && carbohydrates.get())
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

//        for (var food : foodstuffs)
//        {
//            if (!proteins.get() && food.getProteins())
//                proteins.set(true);
//            else
//            if (!fats.get() && food.getFats())
//                fats.set(true);
//            else
//            if (!carbohydrates.get() && food.getCarbohydrates())
//                carbohydrates.set(true);
//            if (proteins.get() && fats.get() && carbohydrates.get())
//                break;
//        }








//        for (var thing : market.getThings(clazz))
//        {
//            if (!proteins.get() && thing.getProteins())
//            {
//                proteins.set(true);
//                foodstuffs.add(thing);
//            }
//            else if (!fats.get() && thing.getFats())
//            {
//                fats.set(true);
//                foodstuffs.add(thing);
//            }
//            else if (!carbohydrates.get() && thing.getCarbohydrates())
//            {
//                carbohydrates.set(true);
//                foodstuffs.add(thing);
//            }
//            if (proteins.get() && fats.get() && carbohydrates.get())
//                break;
//        }

//        if (proteins.get() && fats.get() && carbohydrates.get())
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        else
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs()
    {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));

    }


}
