package cn.hyj.service;

import cn.hyj.entity.OrderInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 订单信息业务逻辑层
 *
 * @author Administrator
 *
 */
public interface OrderInformationService {

    List<OrderInformation> queryOrderInformation(@Param("status") Integer status);


}
