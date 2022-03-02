package ooppractice.domain.category.service;

import lombok.RequiredArgsConstructor;
import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.exception.CategoryNotFoundException;
import ooppractice.domain.category.repository.CategoryRepository;
import ooppractice.global.exception.ErrorCode;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryByName(String categoryName) {
        Category foundCategory = categoryRepository.findByCategoryName(categoryName).orElseThrow(() -> new CategoryNotFoundException(ErrorCode.CATEGORY_NOT_FOUND));
        return foundCategory;
    }
}
