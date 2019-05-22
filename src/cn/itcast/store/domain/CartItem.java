package cn.itcast.store.domain;

/**
 * 每一条商品的模型，主要有图片、商品、价格、数量、小计
 * @author tangyuan
 *
 * 2019年5月21日
 * <p>CopyRight:Copyright(c)2019</p>
 */
public class CartItem {

	private Product product;//这个对象里面提取图片、商品、价格
	private int num;//商品数量
	private double subTotal;//小计金额
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setSubTotal(int subTotal){
		
		this.subTotal = subTotal;
	}
	public double getSubTotal(){
		return num * product.getShop_price();//商品小计 = 商品价格 * 商品数量
	}
	
}
