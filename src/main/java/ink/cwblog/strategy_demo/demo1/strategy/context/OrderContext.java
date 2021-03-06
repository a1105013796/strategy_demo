package ink.cwblog.strategy_demo.demo1.strategy.context;


import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.demo1.strategy.strategy.OrderStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @author chenw
 * @date 2020/6/2 10:09
 * 订单策略上下文
 */
@Component
public class OrderContext {


    private Order order;

    @Resource(name = "OrderStrategyA")
    private OrderStrategy orderStrategyA;
    @Resource(name = "OrderStrategyB")
    private OrderStrategy orderStrategyB;

    private OrderContext() {
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String execute() {
        String result = null;
        if (ObjectUtils.isEmpty(this.order.getFixedPrice())) {
            result = orderStrategyA.createOrder(order);
        } else {
            result = orderStrategyB.createOrder(order);
        }
        return result;
    }
}
