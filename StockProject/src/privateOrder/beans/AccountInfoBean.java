package privateOrder.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import privateOrder.DAO.AccountDAO;
import privateOrder.DAO.GoodDAO;
import privateOrder.domain.Account;
import privateOrder.domain.Good;

public class AccountInfoBean {

	public static Account getAccountInfo(String email) {

		Account account = new Account();
		ArrayList<Good> accGoods = new ArrayList<>();
		try {
			account = AccountDAO.getAccountByEmail(email);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;

	}

	public static ArrayList<Good> getGoodsByAcc(String email) {
		ArrayList<Good> accGoods = new ArrayList<>();
		try {
			accGoods = GoodDAO.getGoodsByAccount(email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accGoods;
	}

}
