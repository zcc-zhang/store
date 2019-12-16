package cn.hyj.service.impl;

import cn.hyj.entity.ShippingAddress;
import cn.hyj.mapper.ShippingAddressMapper;
import cn.hyj.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收货地址业务逻辑实现层
 *
 * @author Administrator
 *
 */
@Service("shippingAddressService")
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    @Override
    public int insert(ShippingAddress record) {
        return shippingAddressMapper.insert(record);
    }
}
