package info.kupczynski.effectivejava.ch2.item2._1_telescopic;

/*
 * Item 2: Consider builders when faced with many c-tor parameters
 *
 * Static factory method and constructors do not scale well wrt. optional parameters.
 *
 * Telescopic constructor is a typical solution
 */

public class NutritionFacts {

    private final int servingSize;  // (mL) required
    private final int servings;     // (per container) required
    private final int calories;     // optional
    private final int fat;          // (g) optional
    private final int sodium;       // (mg) optional
    private final int carbohydrate; // (g) optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat,
                          int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat,
                          int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {

        // You use the constructor with the shortest number of params
        // But this is still confusing: (1) which param is what, (2) is fat=0 or fat not provided?

        NutritionFacts cocaCola = new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
}
