import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JPasswordField txtPassword;
	private JTextArea txtID;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		this.frmLogin.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 448, 326);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 43);
		frmLogin.getContentPane().add(panel);
		
		JLabel lblPurchaseRequisitionSystem = new JLabel("Purchase Requisition System");
		lblPurchaseRequisitionSystem.setFont(new Font("Lato", Font.BOLD, 27));
		panel.add(lblPurchaseRequisitionSystem);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(134, 108, 86, 17);
		frmLogin.getContentPane().add(lblId);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(89, 156, 86, 17);
		frmLogin.getContentPane().add(lblPassword);
		
		txtID = new JTextArea();
		txtID.setLineWrap(true);
		txtID.setBounds(211, 104, 125, 20);
		frmLogin.getContentPane().add(txtID);
		
		JButton btnSignIn = new JButton("SIGN IN");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//staffMenu();
				//managerMenu();
				FinanceStaffMenu();
				vendorMenu();
				emptyFields();
			}
		});
		btnSignIn.setBounds(221, 207, 115, 42);
		frmLogin.getContentPane().add(btnSignIn);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(211, 154, 125, 20);
		frmLogin.getContentPane().add(txtPassword);
	}
	
	private void emptyFields() {
		txtPassword.setText("");
		txtID.setText("");
	}
	
	private void FinanceStaffMenu() {
		for(int i = 0; i < PurchaseReqSystem.financestaff.size(); i++) {
			if(txtID.getText().equals(PurchaseReqSystem.financestaff.get(i).getFinanceStaffID()) && passwordEvaluation()) {
				FinanceMain window = new FinanceMain(PurchaseReqSystem.financestaff.get(i));
				frmLogin.dispose();
			}
		}
	}
	
	private void vendorMenu() {
		for(int i = 0; i < PurchaseReqSystem.vendor.size(); i++) {
			if(txtID.getText().equals(PurchaseReqSystem.vendor.get(i).getVendorID()) && passwordEvaluation()) {
				VendorMain window = new VendorMain(PurchaseReqSystem.vendor.get(i));
				frmLogin.dispose();
			}
		}
	}
	

	private boolean checkPassword(String table, String pk) {
		
		initiation<Object> connector = new initiation();
		String password = null;
		try {
			connector.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		
		try {
			connector.setStatement(connector.getConnection().createStatement() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connector.setResultSet(connector.getStatement().executeQuery("SELECT password FROM " +table+ " where " +pk+ " = '"+txtID.getText()+"'"));
				
				

				while (connector.getResultSet().next()) {
					password = connector.getResultSet().getString("password");
	            }
								
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		
		return password.equals(txtPassword.getText());
		
	}
	
	
	private boolean passwordEvaluation() {
		
		String user = txtID.getText().substring(0, 2);
		
		switch(user) {
			case "ST" :
				return checkPassword("staff", "staffID");			
			case "MN" :
				return checkPassword("manager", "managerID");
			case "FS" :
				return checkPassword("finance_staff", "finance_StaffID");			
			case "VN" :
				return checkPassword("vendor", "vendorID");
				
		}
		
		return false;

	}
	
	
}
