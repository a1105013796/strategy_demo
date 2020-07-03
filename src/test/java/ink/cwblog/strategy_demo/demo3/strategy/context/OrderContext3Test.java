package ink.cwblog.strategy_demo.demo3.strategy.context;

import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.model.OrderDto;
import ink.cwblog.strategy_demo.model.enummodel.SkuSourceEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  chenw
 * @date  2020/7/3 11:30
 */
@SpringBootTest
class OrderContext3Test {

    @Autowired
    OrderContext3 orderContext3;

    @Test
    void execute() {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrder(new Order());
        orderDto.setSource(SkuSourceEnum.JD);
        String execute = orderContext3.execute(orderDto);
        System.out.println("打印:"+execute);
    }
}