package com.materializedview.service.data;


import com.github.javafaker.Faker;
import com.materializedview.model.Product;
import com.materializedview.model.PurchaseOrder;
import com.materializedview.model.User;
import com.materializedview.repository.ProductRepository;
import com.materializedview.repository.PurchaseOrderRepository;
import com.materializedview.service.ProductService;
import com.materializedview.service.PurchaseOrderService;
import com.materializedview.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class GeneratorDataInitialization {

    private final PurchaseOrderService purchaseOrderService;

    private final PurchaseOrderRepository purchaseOrderRepository;

    private final UserService userService;

    private final ProductService productService;

    private static final int COUNT_USERS = 10_000;

    private static final int COUNT_PURCHASE_ORDERS = 500_000;

    private static final int COUNT_PRODUCTS = 1000;


    /**
     * В момент загрузки приложения, будет сделана проверка,
     * заполнена ли база данных оплаченными заказами.
     * Если нет, тогда будет запущен ряд методов, которые заполнят базу
     * данных.
     */
    public void run() {

        long count = purchaseOrderRepository.count();

        int limitCountProduct = 1000_000;

        if (count < limitCountProduct) {
            runGenerateData();
        }

        log.info(" ->  In the DataGenerator was created users for db. ");
    }

    /**
     * Данный метод запускает генерацию данных.
     * Сначала создаются пользователи.
     * Затем создаются продукты.
     * Затем запускается цикл, чтобы сделать вызов метода,
     * который создает заказы.
     * После цикла, снова вызывается метод для создания заказа.
     */
    private void runGenerateData() {
        Faker faker = new Faker();

        this.createUsers(faker);
        this.createProducts(faker);

        IntStream.range(0, 10)
                .forEach(i -> this.createOrder(faker));

        this.createOrder(faker);
    }

    /**
     * происходит создание заказов в цикле.
     * Перед этим запрашивается список пользователей и
     * список продуктов. Из этих данных будут случайным образом
     * выбираться Ids и добавляются при создании заказа покупок (PurchaseOrder).
     */
    private void createOrder(Faker faker) {

        List<Product> products = this.productService.getListProduct();
        List<User> users = this.userService.getListUser();

        List<PurchaseOrder> purchaseOrders = IntStream
                .range(0, COUNT_PURCHASE_ORDERS)
                .mapToObj(i -> {
                    int userIndex = faker
                            .number()
                            .numberBetween(0, COUNT_USERS);

                    int prodIndex = faker
                            .number()
                            .numberBetween(0, COUNT_PRODUCTS);

                    PurchaseOrder purchaseOrder = new PurchaseOrder();

                    User user = users.get(userIndex);
                    Long userId = user.getId();

                    purchaseOrder.setUserId(userId);

                    Product product = products.get(prodIndex);
                    Long productId = product.getId();

                    purchaseOrder.setProductId(productId);
                    return purchaseOrder;
                })
                .toList();

        this.purchaseOrderService.saveListPurchaseOrder(purchaseOrders);
    }

    /**
     * метод генерирует в цикле данные
     * пользователей.
     */
    private void createUsers(Faker faker) {

        List<User> users = IntStream.range(0, COUNT_USERS)
                .mapToObj(i -> {
                    User user = new User();

                    String firstName = faker.name().firstName();
                    user.setFirstName(firstName);

                    String lastName = faker.name().lastName();
                    user.setLastName(lastName);

                    String stateAbbr = faker.address().stateAbbr();
                    user.setState(stateAbbr);

                    return user;
                })
                .toList();
        this.userService.saveListUser(users);
    }

    /**
     * метод генерирует запросы на создания продуктов в базу данных.
     */
    private void createProducts(Faker faker) {

        List<Product> products = IntStream.range(0, COUNT_PRODUCTS)
                .mapToObj(i -> {
                    Product product = new Product();

                    String title = faker.book().title();
                    product.setDescription(title);

                    int price = faker.number().numberBetween(1, 200);
                    product.setPrice(price);

                    return product;
                })
                .toList();

        this.productService.saveListProduct(products);
    }
}
