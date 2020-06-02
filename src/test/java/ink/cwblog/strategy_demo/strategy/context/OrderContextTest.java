package ink.cwblog.strategy_demo.strategy.context;

import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.strategy.strategy.impl.OrderStrategyA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  chenw
 * @date  2020/6/2 10:22
 */
@SpringBootTest
class OrderContextTest {

    @Autowired
    OrderContext orderContext;

    @Test
    void execute() {
        Order order = new Order();
        order.setFixedPrice(new BigDecimal(0));
        orderContext.setOrder(order);
        String execute = orderContext.execute();
        System.out.println("打印:"+execute);

    }
}