package test;

import javax.swing.UIManager;

import view.QL_ThiSinhView;
import view.dangNhapView;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QL_ThiSinhView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
