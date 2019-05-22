package cn.itcast.store.web.servlet;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.store.service.serviceImp.CategoryServiceImp;
import cn.itcast.store.web.base.BaseServlet;
public class CategoryServlet extends BaseServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String findAllcategorys(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		CategoryServiceImp category = new CategoryServiceImp();
		//取得所有条目
		String allList = category.getAllCategory();
		//添加属性
		
		response.setContentType("application/json;charset=utf-8");//告诉浏览器本次相应的是json格式的数据
		response.getWriter().print(allList);
		
		return null;
	}
}
