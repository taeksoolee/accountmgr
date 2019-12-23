package com.single.swingforms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.factory.DAOFactory;
import com.single.dao.UserDAO;
import com.single.dto.User;
import com.single.swingforms.JoinForm.CommitBtnHandler;

//로그인 프레임 : 작성미완료
public class LoginForm extends FrameDesign{
	private static final long serialVersionUID = 1L;
	
	private JPanel loginPanel;
	private JLabel idLabel, passLabel;
	private JTextField idField;
	private JPasswordField passField;
	private JButton loginBtn, joinBtn, findBtn; //

	public LoginForm() {
		super();
		loginPanel = new JPanel(setGridbag.gridBagLayout);
		
		loginBtn = new JButton("Login");
		joinBtn = new JButton("Join");
		findBtn = new JButton("Find");
		
		titleLabel = new JLabel("LOGIN");
		idLabel = new JLabel("ID");
		passLabel = new JLabel("password");
		
		idField = new JTextField(11);
		passField = new JPasswordField(11);
		
//		SetGridbag.setGridbag(comp, gridx, gridy, width, height, ipadx, ipady, top, left, bottom, right, cont);
		setGridbag.setGridbag(findBtn, 2, 0, 1, 1, 0, 0, 0, 0, 10, 0, loginPanel);
		setGridbag.setGridbag(joinBtn, 1, 0, 1, 1, 0, 0, 0, 0, 10, 0, loginPanel);
		setGridbag.setGridbag(idLabel, 0, 1, 1, 1, 0, 0, 0, 0, 5, 10, loginPanel);
		setGridbag.setGridbag(idField, 1, 1, 2, 1, 0, 0, 0, 0, 5, 10, loginPanel);
		setGridbag.setGridbag(passLabel, 0, 2, 1, 1, 0, 0, 0, 0, 5, 10, loginPanel);
		setGridbag.setGridbag(passField, 1, 2, 2, 1, 0, 0, 0, 0, 5, 10, loginPanel);
		setGridbag.setGridbag(loginBtn, 2, 3, 1, 1, 0, 0, 20, -10, 0, 0, loginPanel);
		pack();
		
		loginPanel.setBorder(new EtchedBorder());
		
		getContentPane().setLayout(setGridbag.gridBagLayout);
		setGridbag.setGridbag(loginPanel, 0, 1, 1, 1, 30, 30, 10, 0, 0, 0, getContentPane());
		
		joinBtn.addActionListener(new JoinBtnHandler());
		findBtn.addActionListener(new FindBtnHandler());
		loginBtn.addActionListener(new LoginBtnHandler());
		
		setDisign("LOGIN", 500, 100, 270, 300, true);
	}
//
	public static void main(String[] args) {
		new LoginForm();
	}
//핸들러 클래스
	class JoinBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new JoinForm();
		}
	}
	class FindBtnHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new FindForm();
		}
	}
	class LoginBtnHandler implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText(); 
			String pass = passField.getText();
			
			User user = (User)(DAOFactory.getUserDAO().select(id, UserDAO.OP_ID));
			if(!user.getId().equals(id)) {
				JOptionPane.showMessageDialog(new JFrame(), "선택하신 아이디가 존재하지 않습니다..", "입력오류", JOptionPane.ERROR_MESSAGE); return;
			}
			if(!user.getPassword().equals(pass)) {
				JOptionPane.showMessageDialog(new JFrame(), "비밀 번호가 일치하지 않습니다.", "입력오류", JOptionPane.ERROR_MESSAGE); return;
			}
			setVisible(false);
			new MainForm(user);
		}
	}
}