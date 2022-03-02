package ooppractice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ooppractice.domain.category.repository.CategoryRepository;
import ooppractice.domain.category.service.CategoryService;
import ooppractice.domain.category.service.CategoryServiceImpl;
import ooppractice.domain.item.repository.ItemRepository;
import ooppractice.domain.item.service.ItemService;
import ooppractice.domain.item.service.ItemServiceImpl;
import ooppractice.domain.order.repository.OrderRepository;
import ooppractice.domain.order.service.OrderService;
import ooppractice.domain.order.service.OrderServiceImpl;
import ooppractice.domain.orderitem.repository.OrderItemRepository;
import ooppractice.domain.orderitem.service.OrderItemService;
import ooppractice.domain.orderitem.service.OrderItemServiceImpl;
import ooppractice.domain.payment.repository.PaymentRepository;
import ooppractice.domain.payment.service.PaymentService;
import ooppractice.domain.payment.service.PaymentServiceImpl;
import ooppractice.domain.user.repository.UserRepository;
import ooppractice.domain.user.service.UserService;
import ooppractice.domain.user.service.UserServiceImpl;
import ooppractice.global.util.GetLocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConfig {

    //user
    private static UserRepository userRepository;
    private static UserService userService;

    //order
    private static OrderRepository orderRepository;
    private static OrderService orderService;

    //order item
    private static OrderItemRepository orderItemRepository;
    private static OrderItemService orderItemService;

    //item
    private static ItemRepository itemRepository;
    private static ItemService itemService;

    //category
    private static CategoryRepository categoryRepository;
    private static CategoryService categoryService;

    //payment
    private static PaymentRepository paymentRepository;
    private static PaymentService paymentService;

    //util
    private static GetLocalDateTime getLocalDateTime;

    public static void configure() {
        //util
        getLocalDateTime = new GetLocalDateTime();
        //user
        userRepository = new UserRepository();
        userService = new UserServiceImpl(userRepository);
        //category
        categoryRepository = new CategoryRepository();
        categoryService = new CategoryServiceImpl(categoryRepository);
        //item
        itemRepository = new ItemRepository();
        itemService = new ItemServiceImpl(itemRepository, categoryService);
        //order item
        orderItemRepository = new OrderItemRepository();
        orderItemService = new OrderItemServiceImpl(itemService, orderItemRepository);
        //order
        orderRepository = new OrderRepository();
        orderService = new OrderServiceImpl(userService, orderItemService, orderRepository, getLocalDateTime);
        //payment
        paymentRepository = new PaymentRepository();
        paymentService = new PaymentServiceImpl(paymentRepository, orderService, getLocalDateTime);
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public static OrderService getOrderService() {
        return orderService;
    }

    public static OrderItemRepository getOrderItemRepository() {
        return orderItemRepository;
    }

    public static OrderItemService getOrderItemService() {
        return orderItemService;
    }

    public static ItemRepository getItemRepository() {
        return itemRepository;
    }

    public static ItemService getItemService() {
        return itemService;
    }

    public static CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public static CategoryService getCategoryService() {
        return categoryService;
    }

    public static PaymentRepository getPaymentRepository() {
        return paymentRepository;
    }

    public static PaymentService getPaymentService() {
        return paymentService;
    }

    public static GetLocalDateTime getGetLocalDateTime() {
        return getLocalDateTime;
    }
}
