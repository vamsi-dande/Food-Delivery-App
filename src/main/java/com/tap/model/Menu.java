package com.tap.model;

public class Menu {
	
	private int menuId;
	private int restId;
	private String itemName;
	private String description;
	private float price;
	private boolean isAvailable;
	private String imagePath;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public Menu(int menuId, String itemName, String description, float price, boolean isAvailable,
			String imagePath, int restId) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}
	
	public Menu(String itemName, String description, float price,  String imagePath, int restId) {
		super();
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
	}
	public Menu() {
		super();
	}
	
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restId=" + restId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
	}
	

	public static void main(String[] args) {

//		Menu menu = new Menu("Bonda","mysore",30.0f,true,"dosa.png",1);
//		MenuDAOImpl mdao = new MenuDAOImpl();
//		System.out.println(mdao.insertMenu(menu));
//		List<Menu> list = new ArrayList<Menu>();
//		list = mdao.fetchByRestId(1);
//		for(Menu m : list) {
//			System.out.println(m);
//		}
//		System.out.println(mdao.fetchByMenuId(1));
//		System.out.println(mdao.updateAvailStatus(false, 3));
//		System.out.println(mdao.deleteByMenuId(3));
		
	}

}





















