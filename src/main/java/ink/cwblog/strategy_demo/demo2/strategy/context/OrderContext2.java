package ink.cwblog.strategy_demo.demo2.strategy.context;

import ink.cwblog.strategy_demo.demo2.strategy.strategy.OrderStrategy;
import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.model.OrderDto;
import ink.cwblog.strategy_demo.model.enummodel.SkuSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author  chenw
 * @date  2020/7/3 11:29
 *
 * 订单策略执行器
 */
@Component
public class OrderContext2 {

    @Autowired
    private Map<String,OrderStrategy> map = new HashMap<>();


    public String execute(OrderDto orderDto){
        String order = map.get(orderDto.getSource() + "Order").createOrder(orderDto.getOrder());
        return order;
    }

}
