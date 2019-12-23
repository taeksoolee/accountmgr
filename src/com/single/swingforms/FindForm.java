package com.single.swingforms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.factory.DAOFactory;
import com.single.dao.DAO;
import com.single.dao.UserDAO;
import com.single.dto.User;
import com.single.etc.Varidation;

import oracle.net.aso.i;

public class FindForm extends FrameDesign{
	private static final long serialVersionUID = 1L;
	private JPanel selectPanel, inputIdPanel, inputPassPanel, btnPanel;
	private JLabel nameLabel, birthLabel, idLabel, hintLabel;
	private JTextField nameField, birthField, idField, hintField;
	private JButton searchBtn, idBtn, passBtn;
	private int mode;
	private final int MODE_ID = 0, MODE_PASS = 1;
	

	public FindForm() {
		super();
		
		selectPanel = new JPanel(setGridbag.gridBagLayout);
		inputIdPanel = new JPanel(setGridbag.gridBagLayout);
		inputPassPanel = new JPanel(setGridbag.gridBagLayout);
		btnPanel = new JPanel();
//
		searchBtn = new JButton("Search");
		idBtn = new JButton("ID");
		passBtn = new JButton("Password");
		
		idLabel = new JLabel("ID");
		nameLabel = new JLabel("Name");
		birthLabel = new JLabel("Birthday");
		hintLabel = new JLabel("hint");
		
		idField = new JTextField(8);
		nameField = new JTextField(8);
		birthField = new JTextField(11);
		hintField = new JTextField(25);
		
//		setGridbag.setGridbag(comp, gridx, gridy, width, height, ipadx, ipady, top, left, bottom, right, cont);
		selectPanel.add(idBtn);
		selectPanel.add(passBtn);
		
		setGridbag.setGridbag(nameLabel, 0, 0, 1, 1, 0, 0, 0, 0, 9, 0, inputIdPanel);
		setGridbag.setGridbag(nameField, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, inputIdPanel);
		setGridbag.setGridbag(birthLabel, 3, 0, 1, 1, 0, 0, 0, 0, 9, 0, inputIdPanel);
		setGridbag.setGridbag(birthField, 4, 0, 1, 1, 0, 0, 0, 0, 0, 0, inputIdPanel);
		
		setGridbag.setGridbag(idLabel, 0, 0, 1, 1, 0, 0, 0, 0, 9, 0, inputPassPanel);
		setGridbag.setGridbag(idField, 1, 0, 1, 1, 0, 0, 0, 0, 0, 180, inputPassPanel);
		setGridbag.setGridbag(hintLabel, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, inputPassPanel);
		setGridbag.setGridbag(hintField, 0, 2, 4, 1, 0, 0, 0, 0, 0, 20, inputPassPanel);
		
		btnPanel.add(searchBtn);
		
		pack();
		
		inputIdPanel.setBorder(new TitledBorder(new EtchedBorder(), "ID seach"));
		inputPassPanel.setBorder(new TitledBorder(new EtchedBorder(), "Pass seach"));
		
		getContentPane().setLayout(setGridbag.gridBagLayout);
		setGridbag.setGridbag(selectPanel, 0, 1, 1, 1, 0, 0, 10, 0, 0, 0, getContentPane());
		setGridbag.setGridbag(inputIdPanel, 0, 2, 1, 1, 10, 10, 0, 0, 5, 0, getContentPane());
		setGridbag.setGridbag(inputPassPanel, 0, 3, 1, 1, 10, 10, 0, 0, 10, 0, getContentPane());
		setGridbag.setGridbag(btnPanel, 0, 4, 1, 1, 0, 0, 0, 0, 0, 0, getContentPane());
		
		mode = MODE_PASS;
		toggle(true);
		
		idBtn.addActionListener(new ToggleActionHandler());
		passBtn.addActionListener(new ToggleActionHandler());
		searchBtn.addActionListener(new SearchActionHandler());
		
		setResizable(false);
		setDisign("FIND", 600, 200, 400, 320, false);
	}
	
	public void toggle(boolean b) {// true : id, false : pass 
		nameField.setEnabled(b);
		birthField.setEnabled(b);
		idField.setEnabled(!b);
		hintField.setEnabled(!b);
		idBtn.setEnabled(!b);
		passBtn.setEnabled(b);
		
		nameField.setText("");
		birthField.setText("");
		hintField.setText("");
		idField.setText("");
		
		if(mode == MODE_ID) mode = MODE_PASS;
		else mode = MODE_ID;
	}
	
	class ToggleActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == idBtn) {
				toggle(true);
			}else {
				toggle(false);
			}
		}
	}
	
	class SearchActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(mode) {
			case MODE_ID:
				if(!Varidation.isNullStr(nameField.getText())
						|| !Varidation.isNullStr(birthField.getText())){ 
					User user = (User)(DAOFactory.getUserDAO().select(nameField.getText(), UserDAO.OP_NAME));
					if(user == null) {
						JOptionPane.showMessageDialog(new JFrame(), "일치하는 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE); 
						return;
					}
					String userBirth = user.getBirthday().substring(0, 10);
					System.out.println(userBirth);
					if(userBirth.equals(birthField.getText())) {
						JOptionPane.showMessageDialog(new JFrame(), "아이디는 '"+ user.getId() + "' 입니다.", "안내", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(new JFrame(), "일치하는 회원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "값을 넣어주세요", "오류", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case MODE_PASS:
				break;
			}
			
		}
	}
}
