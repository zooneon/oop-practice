package ooppractice.domain.category.service;

import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.category.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    private String categoryName = "categoryName";
    private Category category = Category.builder().categoryName(categoryName).build();

    @Test
    void getCategoryByName() {
        //given
        String wrongName = "wrongName";
        given(categoryRepository.findByCategoryName(categoryName)).willReturn(Optional.of(category));
        //when
        Category foundCategory = categoryService.getCategoryByName(categoryName);
        //then
        assertThat(foundCategory).isEqualTo(category);
        assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategoryByName(wrongName));
    }
}