package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private final String name;

    private static final Map<String, Category> categoryCache = new HashMap<>();

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Category of(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Category name can't be null");
        }

        Category cachedCategory = categoryCache.get(name);
        if (cachedCategory != null) {
            return cachedCategory;
        }

        Category newCategory = new Category(capitalizeFirstLetter(name));
        categoryCache.put(name, newCategory);
        return newCategory;
    }

    private static String capitalizeFirstLetter(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    // Equals and hashCode methods to compare Category objects based on name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
