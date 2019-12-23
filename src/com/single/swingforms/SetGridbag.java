package com.single.swingforms;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//
public class SetGridbag{
	protected GridBagLayout gridBagLayout;
	protected GridBagConstraints gridBagConstraints;
	
	/**�������� pack() �Ұ�*/
	protected SetGridbag() {
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.NONE;
	}
	
// �׸��忡 ����
	private void setGridbag(int gridx, int gridy, int width, int height, int ipadx, int ipady, int top, int left, int bottom, int right) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = width;
		gridBagConstraints.gridheight = height;
		gridBagConstraints.ipadx = ipadx;
		gridBagConstraints.ipady = ipady;
		gridBagConstraints.insets = new Insets(top, left, bottom, right);
	}

	/** �����̳ʸ� �����ؼ� ������Ʈ ����*/
	protected void setGridbag(Component comp, int gridx, int gridy, int width, int height, int ipadx, int ipady, int top, int left, int bottom, int right, Container cont) {
		setGridbag(gridx, gridy, width, height, ipadx, ipady, top, left, bottom, right);
		gridBagLayout.addLayoutComponent(comp, gridBagConstraints);
		cont.add(comp);
	}
}