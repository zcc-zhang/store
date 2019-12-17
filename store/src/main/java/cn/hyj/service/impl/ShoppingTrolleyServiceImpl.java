package cn.hyj.service.impl;

import cn.hyj.mapper.ShoppingTrolleyMapper;
import cn.hyj.service.ShoppingTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * 购物车业务逻辑实现层
 *
 * @author Administrator
 *
 */
public class ShoppingTrolleyServiceImpl implements ShoppingTrolleyService {

    @Autowired
    private ShoppingTrolleyMapper shoppingTrolleyMapper;
}
