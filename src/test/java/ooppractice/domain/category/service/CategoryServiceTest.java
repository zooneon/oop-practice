package ooppractice.domain.category.service;

import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.category.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    private CategoryRepository categoryRepository = new CategoryRepository();
    private CategoryService categoryService = new CategoryServiceImpl(categoryRepository);
    private Category category = Category.builder().categoryName("categoryName").build();

    @BeforeEach
    void setUp() {
        categoryRepository.save(category);
    }

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAll();
    }

    @Test
    void getCategoryByName() {
        //given
        String categoryName = "categoryName";
        String wrongName = "wrongName";
        //when
        Category foundCategory = categoryService.getCategoryByName(categoryName);
        //then
        assertThat(foundCategory).isEqualTo(category);
        assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategoryByName(wrongName));
    }
}