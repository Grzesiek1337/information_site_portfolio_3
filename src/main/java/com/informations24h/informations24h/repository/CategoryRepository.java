package com.informations24h.informations24h.repository;

import com.informations24h.informations24h.model.Category;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class CategoryRepository {

    private List<Category> categories;

    public CategoryRepository() {
        this.categories = new ArrayList<>();
        categories.add(new Category("sport"));
        categories.add(new Category("history"));
        categories.add(new Category("military"));
        categories.add(new Category("country"));
    }
}
