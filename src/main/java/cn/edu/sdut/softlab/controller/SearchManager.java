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
import javax.faces.bean.SessionScoped;

/**
 * @author gaoyisheng
 *
 */
@Named("SearchManager")
@Dependent
@SessionScoped
public class SearchManager {
	
	@Inject
	EntityManager em;
	
	//bukeyi = =
/*	private Item newItem = new Item();
		
	public Item getNewItem() {
		return newItem;
	}

	public void setNewItem(Item newItem) {
		this.newItem = newItem;
	}
	*/

	//作为中间变量的存在。类似Credentials
	@Inject
	Tempor tem;
	
	public Tempor getTem() {
		return tem;
	}

	public void setTem(Tempor tem) {
		this.tem = tem;
	}


	@Inject
	SearchFacade searchService;
	
	
	public List<Item> getItemsSearchDT(){
		String i = tem.getName();
		
		if (i == null || i.equals("")){
			return searchService.allDT();
		}
		return searchService.fuzzySearch(i);
	}
	
	/*
	public List<Item> simpleSearch(String name) {
    	
    	return em.createQuery("SELECT i FROM Item i " + 
    								"WHERE i.name LIKE '%?1%' ")
    			.setParameter(1, name)
    			.getResultList();
       
    }*/
	
	
}
