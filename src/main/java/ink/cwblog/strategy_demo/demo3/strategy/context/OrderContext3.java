package ink.cwblog.strategy_demo.demo3.strategy.context;

import ink.cwblog.strategy_demo.demo3.strategy.strategy.OrderStrategy;
import ink.cwblog.strategy_demo.model.Order;
import ink.cwblog.strategy_demo.model.OrderDto;
import ink.cwblog.strategy_demo.model.enummodel.SkuSourceEnum;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author  chenw
 * @date  2020/7/3 11:23
 *
 * 订单策略执行器
 */
@Component
public class OrderContext3 {

    @Resource(name = "JDOrder2")
    private OrderStrategy jdOrderStratey;

    @Resource(name = "MCOrder2")
    private OrderStrategy mcOrderStratey;

    @Resource(name = "ZLOrder2")
    private OrderStrategy zlOrderStratey;
    /**
     *  Function<Order,String> Order是参数类型，String是返回值类型
     */
    private Map<SkuSourceEnum, Function<Order,String>> checkResultDispatcher = new HashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中 key 存放的是分派条件，value 存放的是 lambda表达式
     */
    @PostConstruct
    private void checkResultDispatcherInit(){
        checkResultDispatcher.put(SkuSourceEnum.JD,order ->jdOrderStratey.createOrder(order) );
        checkResultDispatcher.put(SkuSourceEnum.ZL,order ->zlOrderStratey.createOrder(order) );
        checkResultDispatcher.put(SkuSourceEnum.MC,order ->mcOrderStratey.createOrder(order) );
    }

    /**
     * 策略执行器
     *
     * @param orderDto
     * @return  String
     */
    public String execute(OrderDto orderDto){
        Function<Order, String> orderStringFunction = checkResultDispatcher.get(orderDto.getSource());
        return orderStringFunction.apply(orderDto.getOrder());
    }

}
