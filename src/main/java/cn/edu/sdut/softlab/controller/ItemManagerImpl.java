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

/**
 * 物品管理器.
 * 
 * @author gaoyisheng
 */
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
	// 不能在此处 直接new()是因为，
	// boughtTime 这个属性 不是在 页面初始化 的时候，初始化。而是
	// 应该放在Add 这个button 的单击事件里。

	// 上面分析有误， 。。。。。so ?

	// Item 的 set/get 方法
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
			/* newItem.setDateBought(new Date()); */
			itemService.create(newItem);
			logger.log(Level.INFO, "Added {0}", newItem);
			return "/AdministratorHome_additems.xhtml?faces-redirect=true";
		} finally {
			utx.commit();
		}
	}

	/**
	 * 1.从前台获取 name 
	 * 2.到数据库中查询 
	 * 3.修改其中 totol字段（入库+=n 出库-=n， 后期交与不同的sevice负责，松耦合提取出来 ） 
	 * 4.保存记录到itme_account表，（创建一个新的字段，为以后查出入库明细 用）
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestScoped
	public String itemOut() throws Exception {
		utx.begin();
		//

		return " ";
	}

}
