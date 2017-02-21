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
import javax.faces.bean.ManagedBean;

/**
 * @author gaoyisheng
 *
 */
@Named("SearchManager")
@Dependent
@ManagedBean()
public class SearchManager {
	
	@Inject
	EntityManager em;
	
	//bukeyi = =
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
