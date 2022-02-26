package ooppractice.domain.category.repository;

import ooppractice.domain.category.domain.Category;
import ooppractice.global.common.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class CategoryRepository extends CrudRepository<Category, Long> {

    public Optional<Category> findByCategoryName(String categoryName) {
        List<Category> categoryList = findAll();
        Optional<Category> optionalCategory = categoryList.stream().filter(category -> category.getCategoryName().equals(categoryName)).findFirst();
        return optionalCategory;
    }
}
