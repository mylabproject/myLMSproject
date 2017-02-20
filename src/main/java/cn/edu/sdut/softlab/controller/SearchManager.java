/**
 * 
 */
package cn.edu.sdut.softlab.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import cn.edu.sdut.softlab.model.Item;
import cn.edu.sdut.softlab.service.SearchFacade;

import java.util.List;

import javax.enterprise.context.Dependent;

/**
 * @author gaoyisheng
 * 总是在itemManager,userManager中很不方便
 *	可能会用不到，先创建起来吧
 *
 */
@Named("SearchManager")
@Dependent
public class SearchManager {
	
	@Inject
	EntityManager em;
	
	private Item newItem = new Item();
		
	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}

	
	@Inject
	SearchFacade searchService;

	
	//TTTOOO DDDOOO
	
	public List<Item> getItemsSearchDT(){
		String i = newItem.getName();
		
		if (i == null || i.equals("")){
			return searchService.allDT();
		}
		return searchService.simpleSearch(i);
	}
	
	/*
	public List<Item> simpleSearch(String name) {
    	
    	return em.createQuery("SELECT i FROM Item i " + 
    								"WHERE i.name LIKE '%?1%' ")
    			.setParameter(1, name)
    			.getResultList();
       
    }*/
	
	
}
