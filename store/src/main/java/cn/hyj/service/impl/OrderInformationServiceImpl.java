package cn.hyj.service.impl;

import cn.hyj.entity.OrderInformation;
import cn.hyj.mapper.OrderInformationMapper;
import cn.hyj.service.OrderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单业务逻辑实现层
 *
 * @author Administrator
 *
 */
@Service("OrderInformationService")
public class OrderInformationServiceImpl implements OrderInformationService {

    @Autowired
    private OrderInformationMapper orderInformationMapper;

    @Override
    public List<OrderInformation> queryOrderInformation(Integer status) {
        return orderInformationMapper.queryOrderInformation(status);
    }
}
