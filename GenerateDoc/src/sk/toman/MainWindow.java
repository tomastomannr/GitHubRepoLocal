package sk.toman;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class MainWindow extends JFrame{

	private static int windowWidth = 900;
	private static int windowHeight = 400;
	JList<String> list;
	JComboBox<String> comboBox;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MainWindow mw = new MainWindow();
//		mw.setVisible(true);
	}
	
	public void refreshTables(){
		System.out.println("Refresh start");
		if(comboBox.getSelectedItem()!=null){
			String databaza = comboBox.getSelectedItem().toString();
			System.out.println("Refresh start databaza " + databaza);

			ManagmentDB managmentDB = new ManagmentDB();
			ArrayList<String> tabulky = managmentDB.getTableNames(databaza);
			System.out.println("Refresh start tabulky "+tabulky);

			DefaultListModel<String> listModel = new DefaultListModel<String>();
			for(int i=0;i<tabulky.size();i++){
				listModel.addElement(tabulky.get(i));
				System.out.println("Refresh start pridavam tabulku "+tabulky.get(i));

			}
			list.setModel(listModel);
			list.repaint();
		}
	}
	
	public MainWindow(ArrayList<String> databaseNames){
		this.setSize(windowWidth, windowHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		this.setLocation((int)(screenWidth/2)-windowWidth/2, (int)(screenHeight/2)-windowHeight/2);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblDatabza = new JLabel("Datab\u00E1za :");
		springLayout.putConstraint(SpringLayout.NORTH, lblDatabza, 38, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDatabza, 31, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblDatabza);
		
		
		
		comboBox = new JComboBox<String>();
		for(int i=0;i<databaseNames.size();i++){
			comboBox.addItem(databaseNames.get(i));
		}
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 35, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 23, SpringLayout.EAST, lblDatabza);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 184, SpringLayout.EAST, lblDatabza);
		comboBox.setSelectedIndex(4);
		//comboBox.add
		getContentPane().add(comboBox);
		
		JLabel lblTabulky = new JLabel("Tabulky :");
		springLayout.putConstraint(SpringLayout.NORTH, lblTabulky, 16, SpringLayout.SOUTH, lblDatabza);
		springLayout.putConstraint(SpringLayout.WEST, lblTabulky, 0, SpringLayout.WEST, lblDatabza);
		springLayout.putConstraint(SpringLayout.EAST, lblTabulky, 0, SpringLayout.EAST, lblDatabza);
		getContentPane().add(lblTabulky);
		
		DefaultListModel model = new DefaultListModel();
		list = new JList(new AbstractListModel() {
			String[] values = new String[] {"a", "s", "d", "f"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});

		    // Initialize the list with items
	    String[] items = { "A", "B", "C", "D" };
	    for (int i = 0; i < items.length; i++) {
	      model.add(i, items[i]);
	    }
	    
	    
		scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, -8, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -6, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.NORTH, list, 285, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, list, 31, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, 63, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, list, 271, SpringLayout.WEST, getContentPane());
		//getContentPane().add(list);
		//refreshTables();
		
		
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, -2, SpringLayout.EAST, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, comboBox);
		getContentPane().add(list);
		//scrollPane.add(list);
		//scrollPane.setVisible(true);
		//getContentPane().add(scrollPane);
		
		
//		String[] languages = new String[] {"English", "French", "Spanish", "Japanese", "Chinese"};		
//		// create a combo box with the fixed array:
//		JComboBox<String> comboLanguage = new JComboBox<String>(languages);
		
		
				
		

		
	}
}
