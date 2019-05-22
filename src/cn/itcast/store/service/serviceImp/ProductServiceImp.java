package cn.itcast.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.store.dao.ProductDao;
import cn.itcast.store.dao.daoImp.ProductDaoImp;
import cn.itcast.store.domain.PageModel;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;

public class ProductServiceImp implements ProductService {

	ProductDao product = new ProductDaoImp();
	/**
	 * 获取热门商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> gethotProduct() throws SQLException {
		
		List<Product> productList = product.selectProductFromIshot();
		return productList;
	}

	@Override
	public List<Product> getNewProduct() throws SQLException {
		List<Product> productList = product.selectNewProduct();
		return productList;
	}

	@Override
	public Product finProductInfoByPid(String pid) throws SQLException {
		ProductDao productDao = new ProductDaoImp();
		Product product = productDao.finProductInfoByPid(pid);
		return product;
	}

	@Override
	public PageModel findProductsByCidWithPage(String cid, int curPage) throws SQLException {
		//查找cid下面有多少条记录
		int totalRecords = product.findTotalRecordsByCid(cid);
		//PageModel的参数（int currentPageNum,int totalRecords,int pageSize）
		PageModel pm = new PageModel(curPage, totalRecords, 12);
		//查看某一页的的SQL语句为：select * from Product where cid = cid limit startPage, pageSize;
		
		List<Product> list = product.findProductsByCidWithPage(cid, pm.getStartIndex(), pm.getPageSize());
		//用一个PageModel来封装
		pm.setList(list);
		pm.setUrl("ProductServlet?method=findProductsByCidWithPage&cid="+cid);
		return pm;
	}
	@Override
	public Product findProductByPid(String pid) throws SQLException {
		
		return product.findProductByPid(pid);
	}

}
