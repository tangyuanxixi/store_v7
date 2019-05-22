package cn.itcast.store.service.serviceImp;

import java.util.List;

import cn.itcast.store.dao.daoImp.CategoryDaoImp;
import cn.itcast.store.domain.Category;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

public class CategoryServiceImp implements CategoryService{

	@Override
	public String getAllCategory() throws Exception {
		
		CategoryDaoImp category = new CategoryDaoImp();
		Jedis jedis = JedisUtils.getJedis();//调用redis
		String jsonStr = jedis.get("allList");
		List<Category> list = null;
		if(null == jsonStr || "".equals(jsonStr))//redis缓冲中没有数据
		{
			list = category.selectAllCategory();//到数据库中查找
			jsonStr=JSONArray.fromObject(list).toString();//转为json格式数据
			jedis.set("allList", jsonStr);//添加到redis缓存中
		} else {//redis缓存中存在
			jsonStr = jedis.get("allList");
		}
		JedisUtils.closeJedis(jedis);
		return jsonStr;
	}

	
}
