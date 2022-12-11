package com.angelolagreca.agreeworld.entities.agreeworld;

import com.angelolagreca.agreeworld.enum_.Category;


import java.util.concurrent.atomic.AtomicInteger;

public class Card {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final Integer id;
    private final String name;
    private final Category category;
    private final Integer point;
    private final String description;

    public Card(String name, Category category, Integer point, String description) {
        id = count.incrementAndGet();
        this.name = name;
        this.category = category;
        this.point = point;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getPoint() {
        return point;
    }

    public String getDescription() {
        return description;
    }

    public static final class CardBuilder {
        private String name;
        private Category category;
        private Integer point;
        private String description;

        private CardBuilder() {
        }

        public static CardBuilder builder() {
            return new CardBuilder();
        }

        public CardBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CardBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public CardBuilder point(Integer point) {
            this.point = point;
            return this;
        }

        public CardBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Card build() {
            Card card = new Card(name, category, point, description);
            return card;
        }
    }


}
