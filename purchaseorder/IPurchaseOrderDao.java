package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	public int savePurchaseOrder(PurchaseOrder po);
	public void updatePurchaseOrder(PurchaseOrder po);
	public void deletePurchaseOrder(Integer poId);
	public PurchaseOrder getOnePurchaseOrder(Integer poId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
