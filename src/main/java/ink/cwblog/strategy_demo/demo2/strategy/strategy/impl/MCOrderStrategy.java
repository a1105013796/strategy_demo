package ink.cwblog.strategy_demo.demo2.strategy.strategy.impl;

import ink.cwblog.strategy_demo.demo2.strategy.strategy.OrderStrategy;
import ink.cwblog.strategy_demo.model.Order;
import org.springframework.stereotype.Component;

/**
 * @author chenw
 * @date 2020/6/2 10:10
 */
@Component("MCOrder")
public class MCOrderStrategy implements OrderStrategy {
    @Override
    public String createOrder(Order order) {
        return "执行自营订单创建策略";
    }
}
