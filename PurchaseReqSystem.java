import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import java.lang.*;
import java.lang.reflect.Constructor;

public class PurchaseReqSystem {
	
	public static ArrayList<Item> item = new ArrayList<>();
	public static ArrayList<PR> pr = new ArrayList<>();
	public static ArrayList<PR_Item> pr_item = new ArrayList<>();
	public static ArrayList<Staff> staff = new ArrayList<>();
	public static ArrayList<Manager> manager = new ArrayList<>();
	public static ArrayList<RFQ> rfq = new ArrayList<>();
	public static ArrayList<RFQ_Item> rfq_item = new ArrayList<>();
	public static ArrayList<FinanceStaff> financestaff = new ArrayList<>();
	public static ArrayList<Vendor> vendor = new ArrayList<>();
	public static ArrayList<Company> company = new ArrayList<>();
	public static ArrayList<Quotation> quotation = new ArrayList<>();
	public static ArrayList<Quotation_Item> quotation_item = new ArrayList<>();
	
	public static void main(String[] args){
		
		//Database object in case mySQL
		initiation<PR> in0 = new initiation<>();
	
		try {
			in0.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			pr = in0.Init_obj("PR", "pr");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		
		initiation<Staff> in1 = new initiation<>();
	
		try {
			in1.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			staff = in1.Init_obj("Staff", "staff");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		      
		
		initiation<Item> in2 = new initiation<>();
		
	
		try {
			in2.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			item = in2.Init_obj("Item", "item");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Item> in3 = new initiation<>();
		
		
		try {
			in3.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			pr_item = in3.Init_obj("PR_Item", "pr_item");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Manager> in4 = new initiation<>();
		
		
		try {
			in4.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			manager = in4.Init_obj("Manager", "manager");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<RFQ> in5 = new initiation<>();
	
		try {
			in5.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			rfq = in5.Init_obj("RFQ", "rfq");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<FinanceStaff> in6 = new initiation<>();
		
		try {
			in6.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			financestaff = in6.Init_obj("FinanceStaff", "finance_staff");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<RFQ_Item> in7 = new initiation<>();
		
		try {
			in7.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			rfq_item = in7.Init_obj("RFQ_Item", "rfq_item");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Vendor> in8 = new initiation<>();
		
		try {
			in8.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			vendor = in8.Init_obj("Vendor", "vendor");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Company> in9 = new initiation<>();
		
		try {
			in9.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			company = in9.Init_obj("Company", "company");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Quotation> in10 = new initiation<>();
		
		try {
			in10.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			quotation = in10.Init_obj("Quotation", "quotation");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		initiation<Quotation_Item> in11 = new initiation<>();
		
		try {
			in11.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		 
		try {
			
			quotation_item = in11.Init_obj("Quotation_Item", "quotation_item");
	        
		}catch (Exception ex) {
			System.out.println(ex); 
		}
		
		for(int i = 0; i < pr.size(); i++) {
			pr.get(i).setItemsAndQuantity();
		}
		
		for(int i = 0; i < rfq.size(); i++) {
			rfq.get(i).setItemsAndQuantity();
		}
		
		for(int i = 0; i < quotation.size(); i++) {
			quotation.get(i).setItemsAndQuantity();
		}
		//FinanceMain window = new FinanceMain();
		Login window = new Login();
		//manager_Main_screen window2 = new manager_Main_screen(manager.get(0));


		
		

	}
	
	

	
	
	
}