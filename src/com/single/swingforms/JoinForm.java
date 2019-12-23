package com.single.swingforms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.factory.DAOFactory;
import com.single.dto.User;
import com.single.etc.Varidation;
import com.single.jdbc.Conn;
import com.single.jdbc.OracleScottConn;

//회원가입 프레임
//아이디(PK) VARCHAR(10), 암호 VARCHAR(12), 사용자명 VARCHAR(25), 생년월일 DATE, 전화번호 VARCHAR(20), 힌트 VARCHAR(50)
public class JoinForm extends FrameDesign{
	private static final long serialVersionUID = 1L;
	private JPanel privacyPanel, hintPanel, btnPanel;
	private JLabel idLabel, passLabel, passCheckLabel, repassLabel, userNameLabel, birthLabel, telLabel, hintLabel;
	private JTextField idField, userNameField, birthField, telField, hintField;
	private JPasswordField passField, repassField;
	private JButton commitBtn, notice;


	public JoinForm() {
		super();
		privacyPanel = new JPanel(setGridbag.gridBagLayout);
		hintPanel = new JPanel(setGridbag.gridBagLayout);
		btnPanel = new JPanel();
		
		commitBtn = new JButton("Commit");
		
		idLabel = new JLabel("ID");
		passLabel = new JLabel("Password");
		passCheckLabel = new JLabel("비밀번호 형식불일치"); // 비밀번호가 조건에 맞는지 확인하는 라벨
		passCheckLabel.setForeground(Color.RED);
		repassLabel = new JLabel("Checkword");
		userNameLabel = new JLabel("Name");
		birthLabel = new JLabel("Birthday");
		telLabel = new JLabel("Tel");
		hintLabel = new JLabel("hint");
		
		idField = new JTextField(11);
		passField = new JPasswordField(11);
		repassField = new JPasswordField(11);
		userNameField = new JTextField(11);
		birthField = new JTextField(11);
		telField = new JTextField(11);
		hintField = new JTextField(15);
		
//		setGridbag.setGridbag(comp, gridx, gridy, width, height, ipadx, ipady, top, left, bottom, right, cont);
		setGridbag.setGridbag(idLabel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 10, privacyPanel);
		setGridbag.setGridbag(idField, 1, 0, 2, 1, 0, 0, 0, 0, 15, 0, privacyPanel);
		setGridbag.setGridbag(passLabel, 0, 1, 1, 1, 0, 0, 0, 0, 0, 10, privacyPanel);
		setGridbag.setGridbag(passField, 1, 1, 2, 1, 0, 0, 0, 0, 8, 0, privacyPanel);
		setGridbag.setGridbag(repassLabel, 0, 2, 1, 1, 0, 0, 0, 0, 0, 10, privacyPanel);
		setGridbag.setGridbag(repassField, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, privacyPanel);
		setGridbag.setGridbag(passCheckLabel, 1, 3, 2, 1, 0, 0, 0, 0, 15, 0, privacyPanel);
		setGridbag.setGridbag(userNameLabel, 0, 4, 1, 1, 0, 0, 0, 0, 15, 10, privacyPanel);
		setGridbag.setGridbag(userNameField, 1, 4, 2, 1, 0, 0, 0, 0, 15, 0, privacyPanel);
		setGridbag.setGridbag(birthLabel, 0, 5, 1, 1, 0, 0, 0, 0, 15, 10, privacyPanel);
		setGridbag.setGridbag(birthField, 1, 5, 2, 1, 0, 0, 0, 0, 15, 0, privacyPanel);
		setGridbag.setGridbag(telLabel, 0, 6, 1, 1, 0, 0, 0, 0, 0, 10, privacyPanel);
		setGridbag.setGridbag(telField, 1, 6, 2, 1, 0, 0, 0, 0, 0, 0, privacyPanel);
		
		setGridbag.setGridbag(hintLabel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 10, hintPanel);
		setGridbag.setGridbag(hintField, 1, 0, 2, 1, 0, 0, 0, 0, 0, 0, hintPanel);
		
		btnPanel.add(commitBtn);
		
		pack();
		
		privacyPanel.setBorder(new TitledBorder(new EtchedBorder(), "Privacy"));
		hintPanel.setBorder(new TitledBorder(new EtchedBorder(), "For finding password.."));
		
		getContentPane().setLayout(setGridbag.gridBagLayout);
		setGridbag.setGridbag(privacyPanel, 0, 1, 1, 1, 30, 20, 0, 0, 15, 0, getContentPane());
		setGridbag.setGridbag(hintPanel, 0, 2, 1, 1, 30, 20, 0, 0, 15, 0, getContentPane());
		setGridbag.setGridbag(btnPanel, 0, 3, 1, 1, 0, 0, 0, 0, 0, 0, getContentPane());
		
		passField.addKeyListener(new passkeyHandler());
		repassField.addKeyListener(new passkeyHandler());
		
		commitBtn.addActionListener(new CommitBtnHandler());
		
		
		setDisign("JOIN", 600, 200, 360, 550, false);
	}
	
// 핸들러
	class passkeyHandler extends KeyAdapter {
		@SuppressWarnings("deprecation")
		@Override
		public void keyReleased(KeyEvent e) {
			super.keyPressed(e);
			String pass = passField.getText();
			String repass = repassField.getText();
			
			if(Varidation.isPasswordStr(pass)) {
				if(pass.equals(repass)) {passCheckLabel.setText(" ");}
				else { passCheckLabel.setText("확인비밀번호 불일치");}
			}else passCheckLabel.setText("비밀번호 형식불일치");
		}
	}
	// 회원가입 구현
	class CommitBtnHandler implements ActionListener{
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String pass = passField.getText();
			String name =userNameField.getText();
			String birth = birthField.getText();
			String tel = telField.getText();
			String hint = hintField.getText();
			String[] error = new String[6];
			
			// 유효성검사
			if(Varidation.isNullStr(id) 
					|| Varidation.isNullStr(pass)
					|| Varidation.isNullStr(name)
					|| Varidation.isNullStr(birth)
					|| Varidation.isNullStr(tel)
					|| Varidation.isNullStr(hint)
					) {
				JOptionPane.showMessageDialog(new JFrame(), "모든값을 입력해주세요.", "입력오류", JOptionPane.ERROR_MESSAGE);
				setAllLabelColor(Color.BLACK);
				repassLabel.setForeground(Color.BLACK);
				
				if(Varidation.isNullStr(idField.getText())) idLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(passField.getText())) passLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(repassField.getText())) repassLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(userNameField.getText())) userNameLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(birthField.getText())) birthLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(telField.getText())) telLabel.setForeground(Color.RED);;
				if(Varidation.isNullStr(hintField.getText())) hintLabel.setForeground(Color.RED);;
			}else {
				if(!Varidation.isIdStr(id)) error[0] = "id"; 
				if(!Varidation.isPasswordStr(pass)) error[1] = "pass"; 
				if(!Varidation.isNameStr(name)) error[2] = "name"; 
				if(!Varidation.isBirthStr(birth)) error[3] = "birth"; 
				if(!Varidation.isTelStr(tel)) error[4] = "tel"; 
				if(!Varidation.isHintStr(hint)) error[5] = "hint";
				
				String result = "";
				for(String tmp : error) {
					if(tmp != null) result = result + " " + tmp;
				}
				System.out.println(result);
				
				if(!Varidation.isNullStr(result)) { // error 없음
					JOptionPane.showMessageDialog(new JFrame(), "값이 올바르지 않습니다..", "입력오류", JOptionPane.ERROR_MESSAGE);
					for(String tmp : error) {
						if(tmp != null) {
							switch(tmp) {
							case "id": idLabel.setForeground(Color.RED); break;
							case "pass": passLabel.setForeground(Color.RED); break;
							case "name": userNameLabel.setForeground(Color.RED); break;
							case "birth": birthLabel.setForeground(Color.RED); break;
							case "tel": telLabel.setForeground(Color.RED); break;
							case "hint": hintLabel.setForeground(Color.RED); break;
							}
						}
					}
				}else {
					DAOFactory.getUserDAO().insert(new User(id, pass, name, birth, tel, hint)); // 생성
					JOptionPane.showMessageDialog(new JFrame(), "회원가입이 완료되셨습니다.", "환영합니다.", JOptionPane.INFORMATION_MESSAGE);
					setAllLabelColor(Color.BLACK);
					setAllFieldClear();
				}
			}
		}
	}
	
	public void setAllFieldClear() {
		idField.setText("");
		passField.setText("");
		repassField.setText("");
		userNameField.setText("");
		birthField.setText("");
		telField.setText("");
		hintField.setText("");
	}
	public void setAllLabelColor(Color c) {
		idLabel.setForeground(c);
		passLabel.setForeground(c);
		userNameLabel.setForeground(c);
		birthLabel.setForeground(c);
		telLabel.setForeground(c);
		hintLabel.setForeground(c);
	}
}