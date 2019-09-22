package com.interest.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.interest.dao.master.MenuDao;
import com.interest.dao.master.RoleDao;
import com.interest.model.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.service.MenuService;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	@Transactional
	public List<MenuEntity> menuList(int id) {
		List<String> idList = roleDao.getModulesById(id);
		
		String idstemp = "";
		for (String idtemp : idList) {
			idstemp = idstemp + idtemp;
		}
		String[] ids = idstemp.split(";");
		List<MenuEntity> parentMenuList = menuDao.getParentMenuListById(ids);
		List<MenuEntity> childrenMenuList = menuDao.getMenuListById(ids);
		List<MenuEntity> menuList = new ArrayList<MenuEntity>();

		for (MenuEntity parentMenu : parentMenuList) {
			List<MenuEntity> menuListTemp = new ArrayList<MenuEntity>();
			for (MenuEntity childrenMenu : childrenMenuList) {
				if (parentMenu.getId() == childrenMenu.getParentId()) {
					menuListTemp.add(childrenMenu);
				}
			}
			parentMenu.setChildren(menuListTemp);
			menuList.add(parentMenu);
		}

		return menuList;
	}

	@Override
	@Transactional
	public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
		return menuDao.menusList(pageSize, start, menuId);
	}

	@Override
	@Transactional
	public Integer menusSize(int pageSize, int start, String menuId) {
		return menuDao.menusSize(pageSize, start, menuId);
	}

	@Override
	@Transactional
	public void insertMenu(MenuEntity menuEntity) {
		menuDao.insertMenu(menuEntity);
	}

	@Override
	@Transactional
	public void updateMenu(MenuEntity menuEntity) {
		menuDao.updateMenu(menuEntity);
	}

	@Override
	@Transactional
	public void deleteMenus(List<String> groupId) {
		menuDao.deleteMenus(groupId);
	}

	@Override
	@Transactional
	public List<MenuEntity> menusByParentId(int parentId) {
		return menuDao.menusByParentId(parentId);
	}

	@Override
	@Transactional
	public List<MenuEntity> getSubmenus() {
		return menuDao.getSubmenus();
	}

}
