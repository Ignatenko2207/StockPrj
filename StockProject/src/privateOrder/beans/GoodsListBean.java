package privateOrder.beans;

import java.util.ArrayList;

import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Good;

public class GoodsListBean {

	public ArrayList<Good> getGoodsForStartPage(){
		ArrayList<Good> goods = new ArrayList<>();
		ArrayList<Good> goodsFromDB = new ArrayList<>();
		try {
			goodsFromDB = GoodDAO.getGoodsByFiltr("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(goodsFromDB.size()<=10){
			goods = goodsFromDB;
		} else{
			for(int i=(goodsFromDB.size()-1); i>=0; i--){
				Good good = goodsFromDB.get(i);
				goods.add(0, good);
				if(goods.size()==10){
					return goods;
				}
			}
		}
		return goods;
	}
}
