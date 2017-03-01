package sk.toman.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class Window extends JFrame {

	private final int windowHeight = 500;
	private final int windowWidth = 900;

	public Window(){
		this.setSize(windowWidth, windowHeight);
		this.setVisible(true);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		this.setLocation((int)(screenWidth/2)-windowWidth/2, (int)(screenHeight/2)-windowHeight/2);
		this.setTitle("TTO Test App");
		
		JTextField jTextFusername = new JTextField();
		JTextField jTextFpass = new JTextField();
		JButton jButtonConnect = new JButton("Connect");
		
		this.add(jTextFusername);
		this.add(jTextFpass);
		this.add(jButtonConnect);
		
		//jTextFusername.setLocation(windowWidth/2-jTextFusername.getWidth()/2, windowHeight/2-jTextFusername.getHeight()/2);
		jTextFusername.setSize(100, 30);
		jTextFusername.setLocation(100, 100);
		
		
		
		
		
		jTextFpass.setSize(100, 30);
		jTextFpass.setLocation(100, 200);
		
		jButtonConnect.setSize(100, 30);
		jButtonConnect.setLocation(100, 300);
		
		
		DefaultTableModel tm = new DefaultTableModel();
		JTable jTable= new JTable(tm);
		
		
		
		
		this.add(jTextFusername);
		this.add(jTextFpass);
		this.add(jButtonConnect);
		

		jTextFusername.setVisible(true);
		jTextFpass.setVisible(true);
		jButtonConnect.setVisible(true);

		
	}
	

	
}
