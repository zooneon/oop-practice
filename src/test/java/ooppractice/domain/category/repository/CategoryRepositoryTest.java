package ooppractice.domain.category.repository;

import ooppractice.domain.category.domain.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryRepositoryTest {

    private CategoryRepository categoryRepository = new CategoryRepository();
    private String categoryName = "categoryName";
    private Category category = Category.builder().categoryName(categoryName).build();

    @BeforeEach
    void setUp() {
        categoryRepository.save(category);
    }

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAll();
    }

    @Test
    void save() {
        //given
        Long savedId = 1L;
        //when
        //then
        assertThat(category.getId()).isEqualTo(savedId);
    }

    @Test
    void findByCategoryName() {
        //given
        String wrongName = "wrongName";
        //when
        Optional<Category> validCategory = categoryRepository.findByCategoryName(categoryName);
        Optional<Category> invalidCategory = categoryRepository.findByCategoryName(wrongName);
        //then
        assertThat(validCategory.get()).isEqualTo(category);
        assertThat(invalidCategory).isEmpty();
    }
}