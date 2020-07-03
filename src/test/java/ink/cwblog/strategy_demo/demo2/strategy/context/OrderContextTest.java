package ink.cwblog.strategy_demo.demo2.strategy.context;

import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.model.OrderDto;
import ink.cwblog.strategy_demo.model.enummodel.SkuSourceEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author  chenw
 * @date  2020/7/3 13:23
 */
@SpringBootTest
class OrderContextTest {

    @Autowired
    OrderContext2 orderContext2;

    @Test
    void execute() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrder(new Order());
        orderDto.setSource(SkuSourceEnum.ZL);
        String execute = orderContext2.execute(orderDto);
        System.out.println("打印:"+execute);

    }
}