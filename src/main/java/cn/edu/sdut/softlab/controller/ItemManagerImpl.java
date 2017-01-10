/*
 * @author gaoyisheng
 */

package cn.edu.sdut.softlab.controller;

import cn.edu.sdut.softlab.model.Item;
import cn.edu.sdut.softlab.service.ItemFacade;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import javax.transaction.UserTransaction;

@Named("itemManager")
@RequestScoped
public class ItemManagerImpl implements ItemManager {

	@Inject
	private transient Logger logger;
	@Inject
	ItemFacade itemService;

	@Inject
	private UserTransaction utx;

	private Item newItem = new Item();

	//Item 的 set/get 方法
	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}

	@Override
	@Produces
	@Named
	@RequestScoped
	public List<Item> getItems() throws Exception {
		try {
			utx.begin();
			return itemService.findAll();
		} finally {
			utx.commit();
		}
	}

	@Override
	public String addItem() throws Exception {
		try {
			utx.begin();
			itemService.create(newItem);
			logger.log(Level.INFO, "Added {0}", newItem);
			return "/items.xhtml?faces-redirect=true";
		} finally {
			utx.commit();
		}
	}


}
