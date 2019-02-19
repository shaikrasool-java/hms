package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderVaidator;

@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService shTypeService;
	@Autowired
	private IWhUserTypeService whUserService;
	@Autowired
	private PurchaseOrderVaidator validator;

	@RequestMapping("/register")
	public String showPage(ModelMap map) {

		List<ShipmentType> shipments = shTypeService.getShipmentsByEnabled("Yes");
		map.addAttribute("shipments", shipments);
		List<WhUserType> venUsers = whUserService.getWhUserTypeByType("vendor");
		map.addAttribute("venUsers", venUsers);
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Errors errors, ModelMap map) {
		validator.validate(purchaseOrder, errors);
		if(!errors.hasErrors()) {
		int pId = service.savePurchaseOrder(purchaseOrder);
		map.addAttribute("message", "Purchase Order Saved with " + pId + " Id");
		List<ShipmentType> shipments = shTypeService.getShipmentsByEnabled("Yes");
		map.addAttribute("shipments", shipments);
		List<WhUserType> vendors = whUserService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegister";
			}
		else
		{
		List<ShipmentType> shipments = shTypeService.getShipmentsByEnabled("Yes");
		map.addAttribute("shipments", shipments);
		List<WhUserType> vendors = whUserService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegister";
		}
	}

	@RequestMapping(value = "/edit")
	public String showEditPage(@RequestParam("id") Integer poId, ModelMap map) {
		PurchaseOrder po = service.getOnePurchaseOrder(poId);
		List<ShipmentType> shipments = shTypeService.getShipmentsByEnabled("Yes");
		map.addAttribute("shipments", shipments);
		List<WhUserType> venUsers = whUserService.getWhUserTypeByType("vendor");
		map.addAttribute("venUsers", venUsers);
		map.addAttribute("purchaseOrder", po);
		return "PurchaseOrderEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute PurchaseOrder purchaseOrder, ModelMap map) {
		service.updatePurchaseOrder(purchaseOrder);
		map.addAttribute("message", "Purchase Order " + purchaseOrder.getPoId() + " Updated Successfully");
		List<PurchaseOrder> pos = service.getAllPurchaseOrders();
		map.addAttribute("purchaseOrders", pos);
		return "PurchaseOrderData";
	}

	@RequestMapping(value = "/delete")
	public String deleteOrder(@RequestParam("id") Integer poId, ModelMap map) {
		service.deletePurchaseOrder(poId);
		map.addAttribute("message", "Purchase Order " + poId + " Deleted !!");
		List<PurchaseOrder> pos = service.getAllPurchaseOrders();
		map.addAttribute("purchaseOrders", pos);
		return "PurchaseOrderData";
	}

	@RequestMapping(value = "/all")
	public String loadAllOrders(ModelMap map) {
		List<PurchaseOrder> pos = service.getAllPurchaseOrders();
		map.addAttribute("purchaseOrders", pos);
		return "PurchaseOrderData";
	}
}
