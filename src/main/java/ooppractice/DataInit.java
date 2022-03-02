package ooppractice;

import ooppractice.domain.category.domain.Category;
import ooppractice.domain.category.repository.CategoryRepository;
import ooppractice.domain.item.domain.Item;
import ooppractice.domain.item.repository.ItemRepository;
import ooppractice.domain.user.domain.User;
import ooppractice.domain.user.repository.UserRepository;

public class DataInit {

    private static UserRepository userRepository = AppConfig.getUserRepository();
    private static ItemRepository itemRepository = AppConfig.getItemRepository();
    private static CategoryRepository categoryRepository = AppConfig.getCategoryRepository();

    private static final String USER_USERNAME = "tester";
    private static final String USER_PASSWORD = "1234";
    private static final String ITEM_CHICKEN_NAME = "치킨";
    private static final int ITEM_CHICKEN_PRICE = 15000;
    private static final int ITEM_CHICKEN_QUANTITY = 500;
    private static final String ITEM_JEAN_NAME = "청바지";
    private static final int ITEM_JEAN_PRICE = 35000;
    private static final int ITEM_JEAN_QUANTITY = 10;
    private static final String ITEM_NOVEL_NAME = "소설";
    private static final int ITEM_NOVEL_PRICE = 10000;
    private static final int ITEM_NOVEL_QUANTITY = 100;
    private static final String CATEGORY_FOOD = "음식";
    private static final String CATEGORY_CLOTHES = "옷";
    private static final String CATEGORY_BOOK = "책";

    public static void init() {
        saveUser();
        saveItems();
    }

    public static void saveUser() {
        User user = User.builder().username(USER_USERNAME).password(USER_PASSWORD).build();
        userRepository.save(user);
    }

    public static void saveItems() {
        Item chicken = Item.builder().itemName(ITEM_CHICKEN_NAME).price(ITEM_CHICKEN_PRICE).stockQuantity(ITEM_CHICKEN_QUANTITY).build();
        Item jean = Item.builder().itemName(ITEM_JEAN_NAME).price(ITEM_JEAN_PRICE).stockQuantity(ITEM_JEAN_QUANTITY).build();
        Item novel = Item.builder().itemName(ITEM_NOVEL_NAME).price(ITEM_NOVEL_PRICE).stockQuantity(ITEM_NOVEL_QUANTITY).build();
        Category food = Category.builder().categoryName(CATEGORY_FOOD).build();
        Category clothes = Category.builder().categoryName(CATEGORY_CLOTHES).build();
        Category book = Category.builder().categoryName(CATEGORY_BOOK).build();

        chicken.addCategory(food);
        food.addItem(chicken);
        jean.addCategory(clothes);
        clothes.addItem(jean);
        novel.addCategory(book);
        book.addItem(novel);

        itemRepository.save(chicken);
        itemRepository.save(jean);
        itemRepository.save(novel);
        categoryRepository.save(food);
        categoryRepository.save(clothes);
        categoryRepository.save(book);
    }
}
