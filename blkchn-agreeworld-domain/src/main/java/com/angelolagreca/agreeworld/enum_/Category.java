package com.angelolagreca.agreeworld.enum_;

import lombok.Getter;

@Getter
public enum Category {

    LEGEND("Legend"),
    FOOD("Food");

    public final String label;

    Category(String label) {
        this.label = label;
    }
}
