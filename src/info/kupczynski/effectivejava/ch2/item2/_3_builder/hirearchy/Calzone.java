package info.kupczynski.effectivejava.ch2.item2._3_builder.hirearchy;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // default

        public Builder sauceInside(boolean sauceInside) {
            this.sauceInside = sauceInside;
            return self();
        }

        @Override
        Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
}
