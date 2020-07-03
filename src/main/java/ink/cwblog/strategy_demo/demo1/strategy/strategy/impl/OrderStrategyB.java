package ink.cwblog.strategy_demo.demo1.strategy.strategy.impl;

import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.demo1.strategy.strategy.OrderStrategy;
import org.springframework.stereotype.Component;

/**
 * @author  chenw
 * @date  2020/6/2 10:10
 */
@Component("OrderStrategyB")
public class OrderStrategyB implements OrderStrategy {
    @Override
    public String createOrder(Order order) {
        return "策略B";
    }
}
