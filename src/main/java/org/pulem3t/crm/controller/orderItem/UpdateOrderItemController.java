/**
 * @author pulem3t
 */
package org.pulem3t.crm.controller.orderItem;

import org.apache.log4j.Logger;
import org.pulem3t.crm.dao.OrderItemDAO;
import org.pulem3t.crm.entry.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderItems")
public class UpdateOrderItemController {
	
	protected static Logger logger = Logger.getLogger("UpdateOrderItemController");

	@Autowired
	private OrderItemDAO orderItemDAO;
	
	@RequestMapping(value="/updateOrderItem", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateOrderItem(@RequestBody OrderItem orderItem) {
		
		logger.info("ORDER_ITEM: Update orderItem with id = " + orderItem.getId());
		
		try {
			orderItemDAO.updateOrderItem(orderItem);
			return "Updated orderItem with id = " + orderItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
