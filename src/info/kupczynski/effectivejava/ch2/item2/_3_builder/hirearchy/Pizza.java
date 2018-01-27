package info.kupczynski.effectivejava.ch2.item2._3_builder.hirearchy;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/*
 * With some trick builders can work with the class hierarchies
 */
public abstract class Pizza {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    final Set<Topping> toppings;

    // recursive type param, item 30
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // self-type idiom
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();  // item 50
    }
}
