package cn.hyj.controller;

import cn.hyj.entity.OrderInformation;
import cn.hyj.service.OrderInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderformationController {

    @Autowired
    private OrderInformationService orderInformationService;

    @RequestMapping("/queryOredrform")
    public String queryOredrform(@RequestParam("status") Integer status, Map map, HttpServletRequest request){

       List<OrderInformation> list = orderInformationService.queryOrderInformation(status);

        Integer daiPrice = 0;// 待付款为1
        Integer daiFaH = 0;// 待发货为2
        Integer daiShouH = 0;// 待收货为3
        Integer accomplish = 0;// 买卖结束为0
        for (int i=0;i<list.size();i++){
            Integer count=list.get(i).getStatus();
            if (count==1){
                daiPrice++;
            }else if (count==2){
                daiFaH++;
            }else if (count==3){
                daiShouH++;
            }else if (count==0){
                accomplish++;
            }
        }
        map.put("daiPrice",daiPrice);
        map.put("daiFaH",daiFaH);
        map.put("daiShouH",daiShouH);
        map.put("accomplish",accomplish);


        // 获取当前时间
        Date date = new Date();
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateDay = day.format(date);

        request.getSession().setAttribute("list",list);
        request.getSession().setAttribute("map",map);
        request.getSession().setAttribute("dateDay",dateDay);
        return "forward:/WEB-INF/jsp/User_Orderform.jsp";
    }
}
