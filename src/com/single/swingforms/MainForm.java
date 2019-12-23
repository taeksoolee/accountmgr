package com.single.swingforms;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.single.dto.User;
import com.single.swingforms.FindForm.SearchActionHandler;
import com.single.swingforms.FindForm.ToggleActionHandler;

public class MainForm extends FrameDesign{
	private static final long serialVersionUID = 1L;
	private JLabel welcomeLabel, mainLabel;
	private JPanel menuPanel, mainPanel, maininnerPanel, topPanel;
	private JButton btn;
	private User user = null;

	public MainForm(User user) {
		super();
		this.user = user;
		
		menuPanel = new JPanel(setGridbag.gridBagLayout);
		mainPanel = new JPanel(setGridbag.gridBagLayout);
		maininnerPanel = new JPanel(setGridbag.gridBagLayout);
		topPanel = new JPanel(setGridbag.gridBagLayout);
		getContentPane().setLayout(setGridbag.gridBagLayout);
		
		
		btn = new JButton("btn");
		
		JOptionPane.showMessageDialog(this, "환영합니다.", "", JOptionPane.INFORMATION_MESSAGE);
		welcomeLabel = new JLabel(user.getUserName() + "님 환영합니다.", JLabel.RIGHT);
		mainLabel = new JLabel("임시");
		
		
		setGridbag.setGridbag(mainLabel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, maininnerPanel);
		
		setGridbag.setGridbag(welcomeLabel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, topPanel);
		setGridbag.setGridbag(btn, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, menuPanel);
		setGridbag.setGridbag(maininnerPanel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, mainPanel);
		
		
		setGridbag.setGridbag(topPanel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, getContentPane());
		setGridbag.setGridbag(menuPanel, 0, 1, 1, 5, 0, 0, 0, 0, 0, 0, getContentPane());
		setGridbag.setGridbag(mainPanel, 1, 1, 4, 5, 0, 0, 0, 0, 0, 0, getContentPane());
		
		pack();
		
		setVisible(true);
		setBounds(500,500,600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//임시 객체 생성
		new MainForm(new User("id", "password", "name", "birthday", "tel", "hint"));
	}
}
