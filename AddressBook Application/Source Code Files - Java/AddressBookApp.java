/*
Name : Ajit Vithal Gaikwad
	   avg180001
	   CS 6360.501
Project: SQL Programming Project - AddressBook Application - Java Code

*/


import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class AddressBookApp extends JFrame implements TextListener,ActionListener{
	
	Connection connection;
	Statement statement, statement2;
	Date Date1;
	PreparedStatement statement1;
	private static final long serialVersionUID =1L;
	TextField Address1, FirstName, LastName, MiddleName, SearchText, AddressType, City, State, ZipCode, DateType, Dates, PhoneType, AreaCode, Number;
	TextArea Address;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15,
		   l01, l02, l03, l04, l05, l06, l07, l08, l09, l010, l011, l012, l013, l014, l015;
	JLabel[] j = new JLabel[20];
	JLabel[] x = new JLabel[20];
	JLabel[] y = new JLabel[20];
	JLabel[] z = new JLabel[20];
	JLabel[] s = new JLabel[20];
	JLabel[] ph = new JLabel[20];
	JLabel[] num = new JLabel[20];
	JLabel[] area = new JLabel[20];
	JLabel[] dtype = new JLabel[20];
	JLabel[] dt = new JLabel[20];
	TextField[] textaddtype = new TextField[20];
	TextField[] textadd = new TextField[20];
	TextField[] textcity = new TextField[20];
	TextField[] textstate = new TextField[20];
	TextField[] textzip = new TextField[20];
	TextField[] textphtype = new TextField[20];
	TextField[] textdtype = new TextField[20];
	TextField[] textarea = new TextField[20];
	TextField[] textnum = new TextField[20];
	TextField[] textdt = new TextField[20];
	JTable table;
	JPanel newPanel, newEntryPanel, viewEntryPanel, modEntryPanel;
	JButton addButton, delButton, modButton, searchButton, doneButton, cancelButton, showAllButton, doneaftermodButton, viewButton, backButton;
	//Vector columnNames = new Vector();
	Vector data = new Vector();
	JScrollPane scrollPane;
	String FirstNameValue, MiddleNameValue, LastNameValue, SearchTextValue, AddressValue, Date2, Fname, Mname, Lname,Address1Value,
		   AddressTypeValue, CityValue, StateValue, ZipCodeValue, DateTypeValue, DateValue, PhoneTypeValue, AreaCodeValue, NumberValue;
	JFrame addEntry, viewEntry, modEntry;
	StringBuffer addtypebuffer = new StringBuffer(15);
	StringBuffer contacttypebuffer = new StringBuffer(15);
	StringBuffer  addbuffer = new StringBuffer(15);
	StringBuffer acodebuffer = new StringBuffer(15);
	StringBuffer statebuffer = new StringBuffer(15);
	StringBuffer citybuffer = new StringBuffer(15);
	StringBuffer numbuffer = new StringBuffer(15);
	StringBuffer sBuffer = new StringBuffer(15);
	ListSelectionModel cellSelectionModel;
	int [] selectedRow, selectedColumns;
	int sR;
			    	
	String[] arrofAddType, arrofAdd, arrofZip, arrofCity, arrofState, arrofPhone, arrofArea, arrofNum, arrofDateType, arrofDate;
	

	public AddressBookApp()
	{
		super("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,700);
		setVisible(true);
		setLocation(250,250);
		setResizable(true);
		//JTabbedPane tabbedpane = new JTabbedPane();	
		//System.out.println(abp);
		newPanel = new JPanel();
		newPanel.setLayout(null);
		add(newPanel);

        table = new JTable();
        newPanel.add(table);

        scrollPane = new JScrollPane(table);
        //scrollPane.getViewport().setViewPosition(new Point(0,0));
        newPanel.add(scrollPane);
        scrollPane.setBounds(15,100,965,450);
        //frame.setSize(300, 150);


	    addButton = new JButton("Add Contact");
	    newPanel.add(addButton);
	    addButton.setBounds(50,580,150,25);

	    viewButton = new JButton("View Contact");
	    newPanel.add(viewButton);
	    viewButton.setBounds(210,580,150,25);
	    viewButton.setEnabled(false);

	    ImageIcon search = new ImageIcon("search1.jpg");
	    searchButton = new JButton(search);
	    newPanel.add(searchButton);
	    searchButton.setBounds(955,50,20,23);

	    SearchText = new TextField(10);
	    newPanel.add(SearchText);
	    SearchText.setBounds(800,50,150,25);
	    //l5.setLabelFor(SearchText);

	    showAllButton = new JButton("Display Contacts");
	    newPanel.add(showAllButton);
	    showAllButton.setBounds(50,50,150,25);

	    addButton.addActionListener(this);
	    searchButton.addActionListener(this);
	    SearchText.addTextListener(this);
	    showAllButton.addActionListener(this);
	    viewButton.addActionListener(this);
	    

	    try {

              Class.forName("com.mysql.jdbc.Driver");
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ADDRESSBOOK", "root", "swordfish");

             }
             catch(Exception e)
             {
				System.out.println(e);
             }
	}


	public void textValueChanged(TextEvent te){
		//System.out.println("What Changed" + te.getSource());

		if(te.getSource() == FirstName){
			FirstNameValue = FirstName.getText();
		}

		else if(te.getSource() == MiddleName){
			MiddleNameValue = MiddleName.getText();
		}

		else if(te.getSource() == LastName){
			LastNameValue = LastName.getText();
		}

		else if(te.getSource() == SearchText){
			SearchTextValue = SearchText.getText();
		}

		else if(te.getSource() == Address){
			AddressValue = Address.getText();
		}

		else if(te.getSource() == Address1){
			Address1Value = Address1.getText();
		}

		else if(te.getSource() == AddressType){
			AddressTypeValue = AddressType.getText();
		}

		else if(te.getSource() == City){
			CityValue = City.getText();
		}

		else if(te.getSource() == State){
			StateValue = State.getText();
		}

		else if(te.getSource() == ZipCode){
			ZipCodeValue = ZipCode.getText();
		}

		else if(te.getSource() == DateType){
			DateTypeValue = DateType.getText();
		}

		else if(te.getSource() == Dates){
			DateValue = Dates.getText();		
		}

		else if(te.getSource() == PhoneType){
			PhoneTypeValue = PhoneType.getText();
		}

		else if(te.getSource() == AreaCode){
			AreaCodeValue = AreaCode.getText();
		}

		else if(te.getSource() == Number){
			NumberValue = Number.getText();
		}

		else{
			if(arrofPhone!=null){
			for(int i=0; i<arrofPhone.length; i++){
				if(te.getSource() == textphtype[i]){
					arrofPhone[i] = textphtype[i].getText();
				}
				else if(te.getSource() == textarea[i]){
					arrofArea[i] = textarea[i].getText();
				}
				else if(te.getSource() == textnum[i]){
					arrofNum[i] = textnum[i].getText();
				}
			}
		}
		if(arrofAddType!=null){
			for(int i=0; i<arrofAddType.length; i++){
				if(te.getSource() == textadd[i]){
					arrofAdd[i] = textadd[i].getText();
				}
				else if(te.getSource() == textaddtype[i]){
					arrofAddType[i] = textaddtype[i].getText();
				}
				else if(te.getSource() == textstate[i]){
					arrofState[i] = textstate[i].getText();
				}
				else if(te.getSource() == textcity[i]){
					arrofCity[i] = textcity[i].getText();
				}
				else if(te.getSource() == textzip[i]){
					arrofZip[i] = textzip[i].getText();
				}
			}
		}
		if(arrofDateType!=null){
			for(int i=0; i<arrofDateType.length; i++){
				if(te.getSource() == textdt[i]){
					arrofDate[i] = textdt[i].getText();
				}
				else if(te.getSource() == textdtype[i]){
					arrofDateType[i] = textdtype[i].getText();
				}
			}	
		}
	}

	}



	public void actionPerformed(ActionEvent ae){
		Vector columnNames = new Vector();;
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		ResultSet set;																																																						
		if (ae.getSource() == searchButton || ae.getSource() == showAllButton){
			try {
				//System.out.println("Entered");
				viewButton.setEnabled(false);
				tableModel = new DefaultTableModel(columnNames, 0);
				if (ae.getSource() == searchButton){
					String query = "SELECT ConPhoAddDat.* FROM (SELECT ConPhoAdd.*, ConDat.DateType, ConDat.Date FROM (SELECT ConAdd.*,ConPho.PhoneType, ConPho.AreaCode, ConPho.Numbers FROM (Select a.Contact_id, a.FirstName, a.MiddleName, a.LastName, GROUP_CONCAT(a.Address_type) as AddressType, GROUP_CONCAT(a.Address) as StreetAddress, GROUP_CONCAT(a.Zip) as Zip, GROUP_CONCAT(a.City) as City, GROUP_CONCAT(a.State) as State  FROM (SELECT CONTACT.*,ADDRESS.Address, ADDRESS.City, ADDRESS.State, ADDRESS.Zip, ADDRESS.Address_type FROM CONTACT  LEFT JOIN ADDRESS ON CONTACT.Contact_id = ADDRESS.Contact_id   UNION SELECT CONTACT.*,ADDRESS.Address, ADDRESS.City, ADDRESS.State, ADDRESS.Zip, ADDRESS.Address_type FROM CONTACT RIGHT JOIN ADDRESS ON CONTACT.Contact_id = ADDRESS.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConAdd LEFT JOIN (Select a.Contact_id, GROUP_CONCAT(a.Phone_type) as PhoneType, GROUP_CONCAT(a.AreaCode) as AreaCode, GROUP_CONCAT(a.Numbers) as Numbers FROM (SELECT CONTACT.*,PHONE.Phone_type, PHONE.AreaCode, PHONE.Numbers FROM CONTACT  LEFT JOIN PHONE ON CONTACT.Contact_id = PHONE.Contact_id   UNION SELECT CONTACT.*, PHONE.Phone_type, PHONE.AreaCode, PHONE.Numbers FROM CONTACT RIGHT JOIN PHONE ON CONTACT.Contact_id = PHONE.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConPho ON ConAdd.Contact_id = ConPho.Contact_id) as ConPhoAdd LEFT JOIN (Select a.Contact_id, GROUP_CONCAT(a.Date_type) as DateType, GROUP_CONCAT(a.Dates) as `Date` FROM (SELECT CONTACT.*,DATES.Date_type, DATES.Dates FROM CONTACT  LEFT JOIN DATES ON CONTACT.Contact_id = DATES.Contact_id   UNION SELECT CONTACT.*,DATES.Date_type, DATES.Dates FROM CONTACT RIGHT JOIN DATES ON CONTACT.Contact_id = DATES.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConDat ON ConPhoAdd.Contact_id = ConDat.Contact_id) as ConPhoAddDat WHERE ConPhoAddDat.FirstName LIKE ? OR ConPhoAddDat.MiddleName LIKE ? OR ConPhoAddDat.LastName  LIKE ?  OR ConPhoAddDat.PhoneType LIKE ? OR ConPhoAddDat.AreaCode LIKE ? OR ConPhoAddDat.Numbers LIKE ?  OR ConPhoAddDat.DateType LIKE ? OR ConPhoAddDat.Date LIKE ? OR ConPhoAddDat.AddressType LIKE ? OR ConPhoAddDat.StreetAddress LIKE ? OR ConPhoAddDat.Zip LIKE ? OR ConPhoAddDat.State LIKE ? OR ConPhoAddDat.City LIKE ?;";
					statement1 = connection.prepareStatement(query);
					statement1.setString(1,"%" + SearchTextValue + "%");
					statement1.setString(2,"%" + SearchTextValue + "%");
					statement1.setString(3,"%" + SearchTextValue + "%");
					statement1.setString(4,"%" + SearchTextValue + "%");
					statement1.setString(5,"%" + SearchTextValue + "%");
					statement1.setString(6,"%" + SearchTextValue + "%");
					statement1.setString(7,"%" + SearchTextValue + "%");
					statement1.setString(8,"%" + SearchTextValue + "%");
					statement1.setString(9,"%" + SearchTextValue + "%");
					statement1.setString(10,"%" + SearchTextValue + "%");
					statement1.setString(11,"%" + SearchTextValue + "%");
					statement1.setString(12,"%" + SearchTextValue + "%");
					statement1.setString(13,"%" + SearchTextValue + "%");

					set = statement1.executeQuery();
				}
				else{
					tableModel = new DefaultTableModel(columnNames, 0);
					statement = connection.createStatement();
					set = statement.executeQuery("SELECT ConPhoAdd.*, ConDat.DateType, ConDat.Date FROM (SELECT ConAdd.*,ConPho.PhoneType, ConPho.AreaCode, ConPho.Numbers FROM (Select a.Contact_id, a.FirstName, a.MiddleName, a.LastName, GROUP_CONCAT(a.Address_type) as AddressType, GROUP_CONCAT(a.Address) as StreetAddress, GROUP_CONCAT(a.Zip) as Zip, GROUP_CONCAT(a.City) as City, GROUP_CONCAT(a.State) as State  FROM (SELECT CONTACT.*,ADDRESS.Address, ADDRESS.City, ADDRESS.State, ADDRESS.Zip, ADDRESS.Address_type FROM CONTACT  LEFT JOIN ADDRESS ON CONTACT.Contact_id = ADDRESS.Contact_id   UNION SELECT CONTACT.*,ADDRESS.Address, ADDRESS.City, ADDRESS.State, ADDRESS.Zip, ADDRESS.Address_type FROM CONTACT RIGHT JOIN ADDRESS ON CONTACT.Contact_id = ADDRESS.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConAdd LEFT JOIN (Select a.Contact_id, GROUP_CONCAT(a.Phone_type) as PhoneType, GROUP_CONCAT(a.AreaCode) as AreaCode, GROUP_CONCAT(a.Numbers) as Numbers FROM (SELECT CONTACT.*,PHONE.Phone_type, PHONE.AreaCode, PHONE.Numbers FROM CONTACT  LEFT JOIN PHONE ON CONTACT.Contact_id = PHONE.Contact_id   UNION SELECT CONTACT.*, PHONE.Phone_type, PHONE.AreaCode, PHONE.Numbers FROM CONTACT RIGHT JOIN PHONE ON CONTACT.Contact_id = PHONE.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConPho ON ConAdd.Contact_id = ConPho.Contact_id) as ConPhoAdd LEFT JOIN (Select a.Contact_id, GROUP_CONCAT(a.Date_type) as DateType, GROUP_CONCAT(a.Dates) as `Date` FROM (SELECT CONTACT.*,DATES.Date_type, DATES.Dates FROM CONTACT  LEFT JOIN DATES ON CONTACT.Contact_id = DATES.Contact_id   UNION SELECT CONTACT.*,DATES.Date_type, DATES.Dates FROM CONTACT RIGHT JOIN DATES ON CONTACT.Contact_id = DATES.Contact_id) as a GROUP BY a.Contact_id, a.FirstName, a.MiddleName, a.LastName) as ConDat ON ConPhoAdd.Contact_id = ConDat.Contact_id");
						//("SELECT * FROM CONTACT OUTER JOIN ADDRESS ON CONTACT.Contact_id = ADDRESS.Contact_id");
				}
				
				ResultSetMetaData md = set.getMetaData();
				int columns = md.getColumnCount();
				
				for (int i = 1; i <= columns; i++) {
					columnNames.addElement( md.getColumnName(i) );
				}
	           
	            while (set.next()){
	            	Vector row = new Vector(columns);
	                for (int i = 1; i <= columns; i++)
	                {
	                	row.addElement(set.getObject(i));
	                }
	                data.addElement(row);
	                tableModel.addRow(row);
	            }
	            set.close();
	            //statement1.close();
		} catch (SQLException ae1){
			ae1.printStackTrace();
		}
		//DefaultTableModel tableModel = new DefaultTableModel(columnNames, data);
		table.setModel(tableModel);
		table.setRowHeight(25); 
		table.getColumnModel().getColumn(0).setHeaderValue("ID");

		table.setRowSelectionAllowed(true);
		cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
	      public void valueChanged(ListSelectionEvent e) {
	      	//modButton.setEnabled(true);
	      	viewButton.setEnabled(true);
	        String selectedData = null;
	        selectedRow = table.getSelectedRows();
	        selectedColumns = table.getSelectedColumns();
	        sR = table.getSelectedRow();
	        

	        for (int i = 0; i < selectedRow.length; i++) {
	        	//System.out.println("i: " + i);
	          for (int j = 0; j < selectedColumns.length; j++) {
	          	if(table.getValueAt(selectedRow[i], selectedColumns[j])!=null){
	          		selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]).toString();	
	          	}
	          	else{
	          		selectedData = "";

	          	}
	          }
	        }
	      }

	    });
		}

		else if(ae.getSource() == delButton) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
	        int gettingID = Integer.parseInt(model.getValueAt(sR,0).toString());
	        String query = "";
	        try{
	        	statement.executeUpdate("DELETE FROM ADDRESS WHERE Contact_id = '" + gettingID + "'");
	        	statement.executeUpdate("DELETE FROM PHONE WHERE Contact_id = '" + gettingID + "'");
	        	statement.executeUpdate("DELETE FROM DATES WHERE Contact_id = '" + gettingID + "'");
	        	statement.executeUpdate("DELETE FROM CONTACT WHERE Contact_id = '" + gettingID + "'");
	        	viewEntry.setVisible(false);
	        	//table.setModel(tableModel);
	        }catch(SQLException e1){
	        	e1.printStackTrace();
	        }
	        this.setEnabled(true);

		}

		else if(ae.getSource() == viewButton) {
			DateValue = null;
			DateTypeValue = null;
			PhoneTypeValue = null;
			NumberValue = null;
			AreaCodeValue = null;
			ZipCodeValue = null;
			CityValue = null; StateValue = null;
			AddressTypeValue = null;
			AddressValue = null;

			this.setEnabled(false);
			DefaultTableModel model = (DefaultTableModel)table.getModel();
	        String gettingID = model.getValueAt(sR,0).toString();
	        Fname = model.getValueAt(sR,1).toString();
		    if(model.getValueAt(sR,2)!=null){
		    	Mname = model.getValueAt(sR,2).toString();
		    }
		    else{
		    	Mname = "";
		    }

		    if(model.getValueAt(sR,3)!=null){
		    	Lname = model.getValueAt(sR,3).toString();
		    }
		    else{
		    	Lname = "";
		    }

			viewEntry = new JFrame(Fname + " " + Mname + " " + Lname);
			viewEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			viewEntry.setSize(600,600);
        	viewEntry.setVisible(true);
        	viewEntry.setLocation(50,50);
        	viewEntry.setResizable(true);
        	viewEntryPanel = new JPanel();

        	//newEntryPanel.setVisible(true);
        	viewEntryPanel.setLayout(null);
        	viewEntryPanel.setPreferredSize(new Dimension(500,500));
        	viewEntry.add(viewEntryPanel);

        	int k = 75;
			int a = 60;

	    	l2 = new JLabel("NAME : " + Fname + " " + Mname + " " +Lname);
		    viewEntryPanel.add(l2);
		    l2.setBounds(100,45,200,15);

		    if (model.getValueAt(sR,4)!= null){
		    	String Addtype = model.getValueAt(sR,4).toString();
		    	arrofAddType = Addtype.split(",");

		    	String Add;
		    	if (model.getValueAt(sR,5)!= null){
		    		Add = model.getValueAt(sR,5).toString();
		    	}
		    	else{
		    		Add = "";
		    	}
		    	arrofAdd = Add.split(",");

		    	String Z;
		    	if (model.getValueAt(sR,6)!= null){
		    		Z = model.getValueAt(sR,6).toString();
		    	}
		    	else{
		    		Z = "";
		    	}
		    	arrofZip = Z.split(",");
		    	
		    	String C;

		    	if (model.getValueAt(sR,7)!= null){
		    		C= model.getValueAt(sR,7).toString();
		    	}
		    	else{
		    		C= "";
		    	}
		    	arrofCity = C.split(",");

		    	String S;
		    	if (model.getValueAt(sR,7)!= null){
		    		S = model.getValueAt(sR,8).toString();
		    	}
		    	else{
		    		S = "";
		    	}
		    	arrofState = S.split(",");

		    	
		    	
		    	

		   
		    	l3 = new JLabel("ADDRESSESS : ");
			    viewEntryPanel.add(l3);
			    l3.setBounds(100,70,200,15);

	    		
	    	
		    	for(int i=0; i<arrofAddType.length; i++){
		    		k = k + 15;
		    		//a = a + 200;
		    		j[i] = new JLabel(arrofAddType[i]);
		    		viewEntryPanel.add(j[i]);
		    		j[i].setBounds(100,k,300,15);
		    		k = k + 15;
		    		//a = a + 200;
		    		x[i] = new JLabel("Street Address:- " + arrofAdd[i]);
		    		viewEntryPanel.add(x[i]);
		    		x[i].setBounds(100,k,300,15);
		    		k = k + 15;
		    		//a = a + 200;
		    		y[i] = new JLabel("City:- " + arrofCity[i]);
		    		viewEntryPanel.add(y[i]);
		    		y[i].setBounds(100,k,300,15);
		    		k = k + 15;
		    		//a = a + 200;
		    		z[i] = new JLabel("State:- " + arrofState[i]);
		    		viewEntryPanel.add(z[i]);
		    		z[i].setBounds(100,k,300,15);
		    		k = k + 15;
		    		//a = a + 200;
		    		s[i] = new JLabel("Zip:- " + arrofZip[i]);
		    		viewEntryPanel.add(s[i]);
		    		s[i].setBounds(100,k,300,15);
		    		k = k + 15;
		    		//a = a + 200;
		    	}
		    }
		    

	    	if (model.getValueAt(sR,9)!= null){
	    		String Ptype = model.getValueAt(sR,9).toString();
	    		arrofPhone = Ptype.split(",");

	    		String Num = model.getValueAt(sR,11).toString();
	    		arrofNum = Num.split(",");

	    		String Acode = model.getValueAt(sR,10).toString();
		    	arrofArea = Acode.split(",");
		    	
		    	k=k+15;
		    	l4 = new JLabel("CONTACTS : ");
			    viewEntryPanel.add(l4);
			    l4.setBounds(100,k,200,15);

		    	for(int i=0; i<arrofPhone.length; i++){
		    		k = k + 15;
		    		ph[i] = new JLabel(arrofPhone[i] + ":" + "number:- " + "(" +arrofArea[i] + ")"+arrofNum[i]);
		    		viewEntryPanel.add(ph[i]);
		    		ph[i].setBounds(100,k,300,15);
		    	
		    		
		    	}
	    	}

	    	if (model.getValueAt(sR,12)!= null && model.getValueAt(sR,13)!=null){
		    	String Dtype = model.getValueAt(sR,12).toString();
		    	arrofDateType = Dtype.split(",");

	    		String Dval = model.getValueAt(sR,13).toString();
	    		arrofDate = Dval.split(",");
		    	
		    	

		    	k=k+25;
		    	l5 = new JLabel("IMPORTANT DATES : ");
			    viewEntryPanel.add(l5);
			    l5.setBounds(100,k,300,15);

		    	for(int i=0; i<arrofDateType.length; i++){
		    		k = k + 15;
		    		//a = a + 200;
		    		dt[i] = new JLabel(arrofDateType[i] + ":- " + arrofDate[i]);
		    		viewEntryPanel.add(dt[i]);
		    		dt[i].setBounds(100,k,300,15);
		    		
		    	}
	    	}

		    delButton = new JButton("Delete Contact");
		    viewEntryPanel.add(delButton);
		    delButton.setBounds(210,k+100,150,25);
		    delButton.addActionListener(this);

		    modButton = new JButton("Modify");
		    viewEntryPanel.add(modButton);
		    modButton.setBounds(50,k+100,150,25);
		    modButton.addActionListener(this);

		    backButton = new JButton("Back");
		    viewEntryPanel.add(backButton);
		    backButton.setBounds(370,k+100,150,25);
		    backButton.addActionListener(this);
		    
	     
		}
		else if(ae.getSource() == backButton) {
			viewEntry.setVisible(false);
			this.setEnabled(true);
		}



		else if(ae.getSource() == addButton || ae.getSource() == modButton) {
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			try{
				DateValue = null;
				DateTypeValue = null;
				PhoneTypeValue = null;
				NumberValue = null;
				AreaCodeValue = null;
				ZipCodeValue = null;
				CityValue = null; StateValue = null;
				AddressTypeValue = null;
				AddressValue = null;
				this.setEnabled(false);
				addEntry = new JFrame("Add Entry");
				addEntry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				addEntry.setSize(1000,1000);
            	addEntry.setVisible(true);
            	addEntry.setLocation(350,300);
            	addEntry.setResizable(true);
            	newEntryPanel = new JPanel();

            	//newEntryPanel.setVisible(true);
            	newEntryPanel.setLayout(null);
            	newEntryPanel.setPreferredSize(new Dimension(600,700));
            	addEntry.add(newEntryPanel);

            	l1 = new JLabel("First Name");
			    newEntryPanel.add(l1);
			    l1.setBounds(100,85,100,30);
			    FirstName = new TextField(10);
			    newEntryPanel.add(FirstName);
			    l1.setLabelFor(FirstName);
			    FirstName.setBounds(100,50,100,30);
			    
			    l2 = new JLabel("Middle Name");
			    newEntryPanel.add(l2);
			    l2.setBounds(220,85,100,30);
			    MiddleName = new TextField(10);
			    newEntryPanel.add(MiddleName);
			    l2.setLabelFor(MiddleName);
			    MiddleName.setBounds(220,50,100,30);

			    l3 = new JLabel("Last Name");
			    newEntryPanel.add(l3);
			    l3.setBounds(340,85,100,30);
			    LastName = new TextField(10);
			    newEntryPanel.add(LastName);
			    l3.setLabelFor(LastName);
			    LastName.setBounds(340,50,100,30);

			    FirstName.addTextListener(this);
	    		MiddleName.addTextListener(this);
	    		LastName.addTextListener(this);
				
			    //tabbedpane.addTab("New Contact",null,newcontact," Click To Add New Contact ");
			    if(ae.getSource() == addButton){
				

			    l4 = new JLabel("Street Address");
			    newEntryPanel.add(l4);
			    Address = new TextArea();
			    l4.setBounds(250,260,150,30);
			    newEntryPanel.add(Address);
			    l4.setLabelFor(Address);
			    Address.setBounds(250,150,200,100);


			    l6 = new JLabel("Address Type");
			    newEntryPanel.add(l6);
			    AddressType = new TextField(10);
			    l6.setBounds(100,210,100,30);
			    newEntryPanel.add(AddressType);
			    l6.setLabelFor(AddressType);
			    AddressType.setBounds(100,170,100,30);

			    l7 = new JLabel("City");
			    newEntryPanel.add(l7);
			    l7.setBounds(100,330,100,30);
			    City = new TextField(10);
			    newEntryPanel.add(City);
			    l7.setLabelFor(City);
			    City.setBounds(100,300,100,30);

			    l8 = new JLabel("State");
			    newEntryPanel.add(l8);
			    l8.setBounds(220,330,100,30);
			    State = new TextField(10);
			    newEntryPanel.add(State);
			    l8.setLabelFor(State);
			    State.setBounds(220,300,100,30);

			    l9 = new JLabel("ZipCode");
			    newEntryPanel.add(l9);
			    l9.setBounds(340,330,100,30);
			    ZipCode = new TextField(5);
			    newEntryPanel.add(ZipCode);
			    l9.setLabelFor(ZipCode);
			    ZipCode.setBounds(340,300,100,30);

			    l10 = new JLabel("Date Type");
			    newEntryPanel.add(l10);
			    l10.setBounds(100,410,100,30);
			    DateType = new TextField(5);
			    newEntryPanel.add(DateType);
			    l10.setLabelFor(DateType);
			    DateType.setBounds(100,370,100,30);

			    l11 = new JLabel("Date");
			    newEntryPanel.add(l11);
			    l11.setBounds(210,410,100,30);
			    
			    Dates = new TextField(10);
			    newEntryPanel.add(Dates);
			    l11.setLabelFor(Dates);
			    Dates.setBounds(210,370,100,30);

			    l12 = new JLabel("Phone Type");
			    newEntryPanel.add(l12);
			    l12.setBounds(100,490,100,30);
			    PhoneType = new TextField(10);
			    newEntryPanel.add(PhoneType);
			    l12.setLabelFor(PhoneType);
			    PhoneType.setBounds(100,450,100,30);

			    l13 = new JLabel("Area Code");
			    newEntryPanel.add(l13);
			    l13.setBounds(220,490,100,30);
			    AreaCode = new TextField(10);
			    newEntryPanel.add(AreaCode);
			    l13.setLabelFor(AreaCode);
			    AreaCode.setBounds(220,450,100,30);

			    //"Need to Implement storage in db is separated by -"
			    l14 = new JLabel("Number");
			    newEntryPanel.add(l14);
			    l14.setBounds(340,490,100,30);
			    Number = new TextField(10);
			    newEntryPanel.add(Number);
			    l14.setLabelFor(Number);
			    Number.setBounds(340,450,100,30);

            	addEntry.pack();

            	
	    		Address.addTextListener(this);
	    		AddressType.addTextListener(this);
	    		City.addTextListener(this);
	    		State.addTextListener(this);
	    		ZipCode.addTextListener(this);
	    		DateType.addTextListener(this);
	    		Dates.addTextListener(this);
	    		PhoneType.addTextListener(this);
	    		AreaCode.addTextListener(this);
	    		Number.addTextListener(this);
	    		
	    			doneButton = new JButton("Done");
		    		newEntryPanel.add(doneButton);
		    		doneButton.setBounds(150,650,100, 30);
		    		doneButton.addActionListener(this);
	    		}

	    		cancelButton = new JButton("Cancel");
	    		newEntryPanel.add(cancelButton);
	    		cancelButton.setBounds(280,650,100, 30);

	    		cancelButton.addActionListener(this);


	    		if(ae.getSource() == modButton){

	    			arrofAddType = null; arrofDateType=null; arrofAdd=null; arrofDate=null; arrofZip=null; arrofCity=null; arrofPhone=null; 
	    			arrofArea =null; arrofState=null; arrofNum =null;
	    			doneaftermodButton = new JButton("Done");
		    		newEntryPanel.add(doneaftermodButton);
		    		doneaftermodButton.setBounds(150,650,100,30);
		    		doneaftermodButton.addActionListener(this);
	    		


	    			String gettingID = model.getValueAt(sR,0).toString();
			        Fname = model.getValueAt(sR,1).toString();

				    if(model.getValueAt(sR,2)!=null){
				    	Mname = model.getValueAt(sR,2).toString();
				    }
				    else{
				    	Mname = "";
				    }

				    if(model.getValueAt(sR,3)!=null){
				    	Lname = model.getValueAt(sR,3).toString();
				    }
				    else{
				    	Lname = "";
				    }

				    FirstName.setText(Fname);
			    	MiddleName.setText(Mname);
			    	LastName.setText(Lname);

			    	int k = 120;
					int a = 100;

					l3 = new JLabel("ADDRESSESS : ");
				    newEntryPanel.add(l3);
				    l3.setBounds(100,k,200,15);

				    if(model.getValueAt(sR,4)!=null){
		    			String Addtype = model.getValueAt(sR,4).toString();
				    	arrofAddType = Addtype.split(",");
				    	
				    	String Add = model.getValueAt(sR,5).toString();
				    	arrofAdd = Add.split(",");
				    	//arrofAdd.add (" ");

				    	String Z = model.getValueAt(sR,6).toString();
				    	arrofZip = Z.split(",");
				    	//arrofZip.add(" ");
				    	
				    	String C = model.getValueAt(sR,7).toString();
				    	arrofCity = C.split(",");
				    	//arrofCity.add(" ");

				    	String S = model.getValueAt(sR,8).toString();
				    	arrofState = S.split(",");

				    	for(int i=0; i<arrofAddType.length; i++){
				    		k = k + 30;
				    		//a = a + 200;
				    		textaddtype[i] = new TextField(arrofAddType[i]);
				    		newEntryPanel.add(textaddtype[i]);
				    		textaddtype[i].setBounds(100,k,100,30);
				    		k=k+25;
				    		j[i] = new JLabel("Address Type");
				    		newEntryPanel.add(j[i]);
				    		j[i].setBounds(100,k,200,30);
				    		textaddtype[i].addTextListener(this);
				    		//k = k + 15;
				    		a = a + 110;
				    		k = k-25;
				    		textadd[i] = new TextField(arrofAdd[i]);
				    		newEntryPanel.add(textadd[i]);
				    		textadd[i].setBounds(210,k,200,30);
				    		k=k+25;
				    		x[i] = new JLabel("Street Address");
				    		newEntryPanel.add(x[i]);
				    		x[i].setBounds(210,k,200,30);
				    		textadd[i].addTextListener(this);
				    		
				    		//a = a + 200;
				    		k=k-25;
				    		textcity[i] = new TextField(arrofCity[i]);
				    		newEntryPanel.add(textcity[i]);
				    		textcity[i].setBounds(415,k,100,30);
				    		k = k + 25;
				    		y[i] = new JLabel("City");
				    		newEntryPanel.add(y[i]);
				    		y[i].setBounds(415,k,100,30);
				    		textcity[i].addTextListener(this);

				    		//a = a + 200;
				    		k = k-25;
				    		textstate[i] = new TextField(arrofState[i]);
				    		newEntryPanel.add(textstate[i]);
				    		textstate[i].setBounds(530,k,100,30);
				    		k = k+25;
				    		z[i] = new JLabel("State ");
				    		newEntryPanel.add(z[i]);
				    		z[i].setBounds(530,k,100,30);
				    		textstate[i].addTextListener(this);

				    		//a = a + 200;
				    		k = k-25;
				    		textzip[i] = new TextField(arrofZip[i]);
				    		newEntryPanel.add(textzip[i]);
				    		textzip[i].setBounds(640,k,100,30);
				    		k = k+25;
				    		s[i] = new JLabel("Zip");
				    		newEntryPanel.add(s[i]);
				    		s[i].setBounds(640,k,100,30);
				    		textzip[i].addTextListener(this);
				    		//k = k + 15;
				    		//a = a + 200;
				    	}
				    }
			    	//arrofState.add(" ");


			    		k = k + 30;
			    		//a = a + 200;
			    		AddressType = new TextField(10);
			    		newEntryPanel.add(AddressType);
			    		AddressType.setBounds(100,k,100,30);
			    		k=k+25;
			    		l06 = new JLabel("Address Type");
			    		newEntryPanel.add(l06);
			    		l06.setBounds(100,k,200,30);
			    		AddressType.addTextListener(this);
			    		//k = k + 15;
			    		
			    		k = k-25;
			    		Address1 = new TextField(50);
			    		newEntryPanel.add(Address1);
			    		Address1.setBounds(210,k,200,30);
			    		k=k+25;
			    		l07 = new JLabel("Street Address");
			    		newEntryPanel.add(l07);
			    		l07.setBounds(210,k,200,25);
			    		Address1.addTextListener(this);
			    		
			    		//a = a + 200;
			    		k=k-25;
			    		City = new TextField(10);
			    		newEntryPanel.add(City);
			    		City.setBounds(415,k,100,30);
			    		k = k + 25;
			    		l08 = new JLabel("City");
			    		newEntryPanel.add(l08);
			    		l08.setBounds(415,k,100,30);
			    		City.addTextListener(this);

			    		//a = a + 200;
			    		k = k-25;
			    		State = new TextField(10);
			    		newEntryPanel.add(State);
			    		State.setBounds(530,k,100,30);
			    		k = k+25;
			    		l09 = new JLabel("State ");
			    		newEntryPanel.add(l09);
			    		l09.setBounds(530,k,100,30);
			    		State.addTextListener(this);

			    		//a = a + 200;
			    		k = k-25;
			    		ZipCode = new TextField(10);
			    		newEntryPanel.add(ZipCode);
			    		ZipCode.setBounds(640,k,100,30);
			    		k = k+25;
			    		l10 = new JLabel("Zip");
			    		newEntryPanel.add(l10);
			    		l10.setBounds(640,k,100,30);
			    		ZipCode.addTextListener(this);

			    		k=k+30;
				    	l4 = new JLabel("CONTACTS : ");
					    newEntryPanel.add(l4);
					    l4.setBounds(100,k,200,15);

			    		if(model.getValueAt(sR,9)!=null){
					    	String Ptype = model.getValueAt(sR,9).toString();
					    	arrofPhone = Ptype.split(",");
					    	
					    	String Acode = model.getValueAt(sR,10).toString();
					    	arrofArea = Acode.split(",");

					    	String Num = model.getValueAt(sR,11).toString();
				    		arrofNum = Num.split(",");

				    		for(int i=0; i<arrofPhone.length; i++){
					    		k = k + 30;
					    		textphtype[i] = new TextField(arrofPhone[i]);
					    		newEntryPanel.add(textphtype[i]);
					    		textphtype[i].setBounds(100,k,100,30);
					    		k=k+25;
					    		ph[i] = new JLabel("Phone Type");
					    		newEntryPanel.add(ph[i]);
					    		ph[i].setBounds(100,k,100,30);
					    		textphtype[i].addTextListener(this);

					    		k = k-25;
					    		textarea[i] = new TextField(arrofArea[i]);
					    		newEntryPanel.add(textarea[i]);
					    		textarea[i].setBounds(210,k,100,30);
					    		k = k+25;
					    		area[i] = new JLabel("Area");
					    		newEntryPanel.add(area[i]);
					    		area[i].setBounds(210,k,100,30);
					    		textarea[i].addTextListener(this);

					    		k = k-25;
					    		textnum[i] = new TextField(arrofNum[i]);
					    		newEntryPanel.add(textnum[i]);
					    		textnum[i].setBounds(320,k,100,30);
					    		k = k+25;
					    		num[i] = new JLabel("Number");
					    		newEntryPanel.add(num[i]);
					    		num[i].setBounds(320,k,100,30);
					    		textnum[i].addTextListener(this);
					    	
					    		
					    	}
					    	k=k-25;
					    }

					    if(model.getValueAt(sR,9)==null){
			    			k=k+30;
			    		}

			    		PhoneType = new TextField(10);
			    		newEntryPanel.add(PhoneType);
			    		PhoneType.setBounds(430,k,100,30);
			    		k=k+25;
			    		l03 = new JLabel("Phone Type");
			    		newEntryPanel.add(l03);
			    		l03.setBounds(430,k,100,30);
			    		PhoneType.addTextListener(this);

			    		k = k-25;
			    		AreaCode = new TextField(10);
			    		newEntryPanel.add(AreaCode);
			    		AreaCode.setBounds(540,k,100,30);
			    		k = k+25;
			    		l04 = new JLabel("Area");
			    		newEntryPanel.add(l04);
			    		l04.setBounds(540,k,100,30);
			    		AreaCode.addTextListener(this);

			    		k = k-25;
			    		Number = new TextField(10);
			    		newEntryPanel.add(Number);
			    		Number.setBounds(650,k,100,30);
			    		k = k+25;
			    		l05 = new JLabel("Number");
			    		newEntryPanel.add(l05);
			    		l05.setBounds(650,k,100,30);
			    		Number.addTextListener(this);



			    	k=k+30;
			    	l5 = new JLabel("IMPORTANT DATES : ");
				    newEntryPanel.add(l5);
				    l5.setBounds(100,k,300,15);

				     if(model.getValueAt(sR,12)!=null && model.getValueAt(sR,13)!=null){
				    	String Dtype = model.getValueAt(sR,12).toString();
				    	arrofDateType = Dtype.split(",");

				    	String Dval = model.getValueAt(sR,13).toString();
				    	arrofDate = Dval.split(",");

				    	for(int i=0; i<arrofDateType.length; i++){
				    		k = k + 30;
				    		textdtype[i] = new TextField(arrofDateType[i]);
				    		newEntryPanel.add(textdtype[i]);
				    		textdtype[i].setBounds(100,k,100,30);
				    		k=k+25;
				    		dtype[i] = new JLabel("Date Type");
				    		newEntryPanel.add(dtype[i]);
				    		dtype[i].setBounds(100,k,100,30);
				    		textdtype[i].addTextListener(this);

				    		k = k-25;
				    		textdt[i] = new TextField(arrofDate[i]);
				    		newEntryPanel.add(textdt[i]);
				    		textdt[i].setBounds(210,k,100,30);
				    		k = k+25;
				    		dt[i] = new JLabel("Date");
				    		newEntryPanel.add(dt[i]);
				    		dt[i].setBounds(210,k,100,30);
				    		textdt[i].addTextListener(this);

				    	}
				    	k = k-25;
				    }

			    		
			    		if(model.getValueAt(sR,12)==null || model.getValueAt(sR,13)==null){
			    			k=k+30;
			    		}
			    		DateType = new TextField(10);
			    		newEntryPanel.add(DateType);
			    		DateType.setBounds(320,k,100,30);
			    		k=k+25;
			    		l01 = new JLabel("Date Type");
			    		newEntryPanel.add(l01);
			    		l01.setBounds(320,k,100,30);
			    		DateType.addTextListener(this);

//FirstName, LastName, MiddleName, SearchText, AddressType, City, State, ZipCode, DateType, Dates, PhoneType, AreaCode, Number;

			    		k = k-25;
			    		Dates = new TextField(10);
			    		newEntryPanel.add(Dates);
			    		Dates.setBounds(430,k,100,30);
			    		k = k+25;
			    		l02 = new JLabel("Date");
			    		newEntryPanel.add(l02);
			    		l02.setBounds(430,k,100,30);
			    		Dates.addTextListener(this);
			    }

			} catch (Exception e){
				System.out.println("Error:" + e);
			}

		}
		
		/*else if(ae.getSource() == showAllButton){
			try{


			} catch(exception e){
				System.out.println("" + e);
			}
		}*/
		else if(ae.getSource() == doneButton){
			try{
				if (FirstNameValue != null && Address != null){
					int refid = 0;
					
					if(AddressValue!=null){
						AddressValue = AddressValue.replace(',',' ');	
					}
					
					statement = connection.createStatement();
					statement.executeUpdate("INSERT INTO CONTACT (FirstName, MiddleName, LastName)" + 
																" VALUES('" + FirstNameValue + "', '" + MiddleNameValue 
																+ "', '" + LastNameValue + "') ");

					ResultSet rs = statement.executeQuery("SELECT Contact_id from CONTACT where Contact_id = LAST_INSERT_ID()");

					int getID=0;

					while(rs.next()){
						getID = rs.getInt("Contact_id");
					}
					
					
					if(AddressTypeValue!=null){
						statement.executeUpdate("INSERT INTO ADDRESS (Contact_id, Address_type, Address, City, State, Zip)" + 
																	" VALUES( '" + getID + "','" + AddressTypeValue 
																	+ "', '" + AddressValue + "', '" + CityValue + "', '" 
																	+ StateValue + "', '" + ZipCodeValue + "') ");
					}

					if(AreaCodeValue!=null){
						statement.executeUpdate("INSERT INTO PHONE (Contact_id, Phone_type, AreaCode, Numbers)" +
																"VALUES('" + getID + "','" + PhoneTypeValue 
																+ "', '"+ AreaCodeValue +"', '" + NumberValue + "')");
					}
					
					if (DateValue!=null){
						try{
							Date1=new SimpleDateFormat("yyyy-MM-DD").parse(DateValue);
							SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-DD");
							Date2=newFormat.format(Date1);
						} catch (Exception e){
							System.out.println("Error:" + e);
						}

						statement.executeUpdate("INSERT INTO DATES (Contact_id, Date_type, Dates)" +
																	"VALUES('" + getID + "','" + DateTypeValue 
																	+ "', '"+ Date2 +"')");
					}
				
				}
				addEntry.setVisible(false);
				this.setEnabled(true);
			}catch(SQLException ae2){
				ae2.printStackTrace();
			}
		}

		else if(ae.getSource() == doneaftermodButton){
				try{
					if (FirstNameValue != null){
						int refid = 0;

						DefaultTableModel model = (DefaultTableModel)table.getModel();
				        int gettingID = Integer.parseInt(model.getValueAt(sR,0).toString());
				        //System.out.println("This is it: " + gettingID);
						

						
						statement = connection.createStatement();

						statement.executeUpdate("DELETE FROM ADDRESS WHERE Contact_id = '" + gettingID + "'");
			        	statement.executeUpdate("DELETE FROM PHONE WHERE Contact_id = '" + gettingID + "'");
			        	statement.executeUpdate("DELETE FROM DATES WHERE Contact_id = '" + gettingID + "'");
			        	statement.executeUpdate("DELETE FROM CONTACT WHERE Contact_id = '" + gettingID + "'");
						statement.executeUpdate("INSERT INTO CONTACT (Contact_id, FirstName, MiddleName, LastName)" + 
																	" VALUES('"+ gettingID +"', '" + FirstNameValue + "', '" + MiddleNameValue 
																	+ "', '" + LastNameValue + "') ");

						//System.out.println("Focus here : "+arrofAddType);
						if(arrofAddType!=null){
							for(int i=0; i<arrofAddType.length; i++){

								statement.executeUpdate("INSERT INTO ADDRESS (Contact_id, Address_type, Address, City, State, Zip)" + 
																			" VALUES('"+ gettingID +"','" + arrofAddType[i] 
																			+ "', '" + arrofAdd[i] + "', '" + arrofCity[i] + "', '" 
																			+ arrofState[i] + "', '" + arrofZip[i] + "') ");
							}
						}
						if(AddressTypeValue !=null){
							statement.executeUpdate("INSERT INTO ADDRESS (Contact_id, Address_type, Address, City, State, Zip)" + 
																		" VALUES('"+ gettingID +"','" + AddressTypeValue 
																		+ "', '" + Address1Value + "', '" + CityValue + "', '" 
																		+ StateValue + "', '" + ZipCodeValue + "') ");
						}

						//System.out.println("Focus here : "+arrofPhone);
						if(arrofPhone!=null){
							//System.out.println("Focus here : "+arrofPhone);
							for(int i=0; i<arrofPhone.length; i++){
								statement.executeUpdate("INSERT INTO PHONE (Contact_id, Phone_type, AreaCode, Numbers)" +
																			"VALUES('"+ gettingID +"','" + arrofPhone[i] 
																			+ "', '"+ arrofArea[i] +"', '" + arrofNum[i] + "')");
							}
						}

						if(PhoneTypeValue!=null){
							statement.executeUpdate("INSERT INTO PHONE (Contact_id, Phone_type, AreaCode, Numbers)" +
																		"VALUES('"+ gettingID +"','" + PhoneTypeValue
																		+ "', '"+ AreaCodeValue +"', '" + NumberValue + "')");
						}

						if(arrofDateType!=null){
							for(int i=0; i<arrofDateType.length; i++){
								if(arrofDate[i].equals("")){
										statement.executeUpdate("INSERT INTO DATES (Contact_id, Date_type, Dates)" +
																			"VALUES('"+ gettingID +"','" + arrofDateType[i] 
																			+ "', NULL)");
									}else{
								try{
									
										//System.out.println("Pahunch Gya" + arrofDate[i]);
										Date1=new SimpleDateFormat("yyyy-MM-DD").parse(arrofDate[i]);
										SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-DD");
										Date2=newFormat.format(Date1);	
									
									
									//System.out.println(Date1);
							} catch (Exception e){
								System.out.println("Error:" + e);
							}
								statement.executeUpdate("INSERT INTO DATES (Contact_id, Date_type, Dates)" +
																			"VALUES('"+ gettingID +"','" + arrofDateType[i] 
																			+ "', '"+ Date2 +"')");
							}
							}
						}
						//System.out.println("Adding Data`" + DateTypeValue);
						if(DateTypeValue!=null){
							try{
								Date1=new SimpleDateFormat("yyyy-MM-DD").parse(DateValue);
								SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-DD");
								Date2=newFormat.format(Date1);
								} catch(Exception e){
									System.out.println("Error:" + e);
								}
								statement.executeUpdate("INSERT INTO DATES (Contact_id, Date_type, Dates)" +
																			"VALUES('"+ gettingID +"','" + DateTypeValue
																			+ "', '"+ Date2 +"')");
						}	
					}
				viewEntry.setVisible(false);
				addEntry.setVisible(false);
				this.setEnabled(true);

			}catch(SQLException ae2){
				ae2.printStackTrace();
			}
		}
		else if(ae.getSource() == cancelButton){
				this.setEnabled(true);
				addEntry.setVisible(false);
		}
	}


	public static void main (String[] args) {
		AddressBookApp abp = new AddressBookApp();
		abp.setVisible(true);

	}
}