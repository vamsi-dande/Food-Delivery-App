package com.tap.DAO;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDAO {

	int insertMenu(Menu m);
	Menu fetchByMenuId(int menuId);
	List<Menu> fetchByRestId(int restId);
	int deleteByMenuId(int menuId);
	int updateAvailStatus(boolean isAvail, int menuId);
}
