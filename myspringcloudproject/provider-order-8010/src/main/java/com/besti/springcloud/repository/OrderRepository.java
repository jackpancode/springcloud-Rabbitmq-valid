package com.besti.springcloud.repository;

import com.besti.springcloud.entity.Order;
import com.besti.springcloud.entity.OrderHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Jack Pan
 * @version 1.0 2020/10/21
 */
public interface OrderRepository {

    public void save(Order order);

    public List<Order> findAllByUid(int index,int limit,long uid);

    public int countByUid(long uid);

    public List<Order> findAllByState(int index, int limit);

    public void updateState(long id);

    public int count();

}
