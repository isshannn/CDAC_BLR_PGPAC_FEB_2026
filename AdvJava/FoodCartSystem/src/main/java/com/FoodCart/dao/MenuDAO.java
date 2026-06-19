package com.FoodCart.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.FoodCart.pojo.FoodItem;
import com.FoodCart.util.DBConnection;

public class MenuDAO {

	public List<FoodItem> getFoodItems(){

		List<FoodItem> menu_list = new ArrayList<>();
		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pmt = con.prepareStatement("Select * from food_items");
			ResultSet rs = pmt.executeQuery();

			


			while(rs.next()) {
				System.out.println("MenuDAO :: ResultSet check " + rs.getString(2));

				FoodItem menu_obj = new FoodItem();
				menu_obj.setFood_id(rs.getInt(1));
				menu_obj.setFood_name(rs.getString(2));
				menu_obj.setPrice(rs.getDouble(3));

				menu_list.add(menu_obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<menu_list.size(); i++) {
			System.out.println("MenuDAO :: menu_list check " + menu_list.get(i).getFood_name());			
		}
		System.out.println("MenuDAO :: menu_list_size check " + menu_list.size());			
		
		return menu_list;
	}
}
