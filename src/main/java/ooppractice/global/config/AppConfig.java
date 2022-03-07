package ooppractice.global.config;

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
import ooppractice.view.LoginView;
import ooppractice.view.MainView;
import ooppractice.view.mypage.MyPageDepositView;
import ooppractice.view.mypage.MyPageInfoView;
import ooppractice.view.mypage.MyPageMainView;
import ooppractice.view.order.OrderCancelView;
import ooppractice.view.order.OrderInfoView;
import ooppractice.view.order.OrderMainView;
import ooppractice.view.order.OrderView;
import ooppractice.view.payment.PaymentCancelView;
import ooppractice.view.payment.PaymentInfoView;
import ooppractice.view.payment.PaymentMainView;
import ooppractice.view.payment.PaymentView;
import ooppractice.view.search.CategoryNameSearchView;
import ooppractice.view.search.ItemNameSearchView;
import ooppractice.view.search.SearchMainView;

import java.util.Scanner;

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
    private static Scanner scanner;

    //view
    private static LoginView loginView;
    private static MainView mainView;

    //mypage view
    private static MyPageMainView myPageMainView;
    private static MyPageInfoView myPageInfoView;
    private static MyPageDepositView myPageDepositView;

    //order view
    private static OrderMainView orderMainView;
    private static OrderView orderView;
    private static OrderInfoView orderInfoView;
    private static OrderCancelView orderCancelView;

    //payment view
    private static PaymentMainView paymentMainView;
    private static PaymentView paymentView;
    private static PaymentInfoView paymentInfoView;
    private static PaymentCancelView paymentCancelView;

    //search view
    private static SearchMainView searchMainView;
    private static ItemNameSearchView itemNameSearchView;
    private static CategoryNameSearchView categoryNameSearchView;

    public static void configure() {
        //util
        getLocalDateTime = new GetLocalDateTime();
        scanner = new Scanner(System.in);
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
        //view
        loginView = new LoginView(scanner, userService);
        mainView = new MainView(scanner);
        //mypage view
        myPageMainView = new MyPageMainView(scanner);
        myPageInfoView = new MyPageInfoView(scanner, userService);
        myPageDepositView = new MyPageDepositView(scanner, userService);
        //order view
        orderMainView = new OrderMainView(scanner);
        orderView = new OrderView(scanner, orderService);
        orderInfoView = new OrderInfoView(scanner, orderService);
        orderCancelView = new OrderCancelView(scanner, orderService);
        //payment view
        paymentMainView = new PaymentMainView(scanner);
        paymentView = new PaymentView(scanner, paymentService);
        paymentInfoView = new PaymentInfoView(scanner, paymentService);
        paymentCancelView = new PaymentCancelView(scanner, paymentService);
        //search view
        searchMainView = new SearchMainView(scanner);
        itemNameSearchView = new ItemNameSearchView(scanner);
        categoryNameSearchView = new CategoryNameSearchView(scanner);
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

    public static Scanner getScanner() {
        return scanner;
    }

    public static LoginView getLoginView() {
        return loginView;
    }

    public static MainView getMainView() {
        return mainView;
    }

    public static MyPageMainView getMyPageMainView() {
        return myPageMainView;
    }

    public static MyPageInfoView getMyPageInfoView() {
        return myPageInfoView;
    }

    public static MyPageDepositView getMyPageDepositView() {
        return myPageDepositView;
    }

    public static OrderMainView getOrderMainView() {
        return orderMainView;
    }

    public static OrderView getOrderView() {
        return orderView;
    }

    public static OrderInfoView getOrderInfoView() {
        return orderInfoView;
    }

    public static OrderCancelView getOrderCancelView() {
        return orderCancelView;
    }

    public static PaymentMainView getPaymentMainView() {
        return paymentMainView;
    }

    public static PaymentView getPaymentView() {
        return paymentView;
    }

    public static PaymentInfoView getPaymentInfoView() {
        return paymentInfoView;
    }

    public static PaymentCancelView getPaymentCancelView() {
        return paymentCancelView;
    }

    public static SearchMainView getSearchMainView() {
        return searchMainView;
    }

    public static ItemNameSearchView getItemNameSearchView() {
        return itemNameSearchView;
    }

    public static CategoryNameSearchView getCategoryNameSearchView() {
        return categoryNameSearchView;
    }
}
