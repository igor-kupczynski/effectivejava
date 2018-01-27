package info.kupczynski.effectivejava.ch2.item2._3_builder.hirearchy;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size { SMALL, MEDIUM, LARGE }
    private final Size size;


    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
