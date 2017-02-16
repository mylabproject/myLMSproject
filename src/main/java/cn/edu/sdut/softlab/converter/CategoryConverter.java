/**
 * 
 */
package cn.edu.sdut.softlab.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import cn.edu.sdut.softlab.model.Category;
import cn.edu.sdut.softlab.service.CategoryFacade;

/**
 * @author gaoyisheng
 *
 */
public class CategoryConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CategoryFacade categoryservice;

	@Inject
	FacesContext fc;

	/**
	 * @param String
	 *            name
	 * @return Object
	 * 
	 *         传入一个 category_name ，根据name查找返回一个 category 对象，
	 */
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String name) {
		if (name != null) {

			Category category = categoryservice.findByName(name);

			return category;
		}

		return null;
	}

	/**
	 * @param Object
	 *            arg2
	 * @return String
	 * 
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
