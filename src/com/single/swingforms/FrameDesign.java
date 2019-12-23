package com.single.swingforms;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
/** */
public class FrameDesign extends JFrame{
	private static final long serialVersionUID = 1L;
	protected SetGridbag setGridbag = new SetGridbag();
	protected JLabel titleLabel;
	static {
		try {
			Class.forName("com.single.dao.JdbcDAO");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrameDesign() {
		super();
		
	}
	
	protected void setDisign(String title, int x, int y, int w, int h, boolean isExit) {
		setTitle(title);
		setVisible(true);
		setBounds(x,y,w,h);
		if(isExit == true) setDefaultCloseOperation(EXIT_ON_CLOSE);
		titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("±¼¸²", Font.BOLD, 30));
		setGridbag.setGridbag(titleLabel, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, getContentPane());
	}
}
