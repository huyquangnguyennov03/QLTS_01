package Controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import model.thiSinh;
import model.tinh;
import view.QL_ThiSinhView;

public class QL_ThiSinhController implements Action {
	public QL_ThiSinhView view;

	public QL_ThiSinhController(QL_ThiSinhView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMssageDialog(view, "Bạn vừa nhấn vào: " + cm);
		if (cm.equals("Thêm")) {
			this.view.thucHienThem();
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (cm.equals("Lưu")) {
			try {
				this.view.thucHienThem();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (cm.equals("Sửa")) {
			this.view.hienThiThongTinThiSinhDaChon();
		} else if (cm.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if (cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		} else if (cm.equals("Tìm kiếm")) {
			this.view.thucHienTimKiem();
		} else if (cm.equals("Hủy tìm")) {
			this.view.thucHienHuyTimKiem();
		} else if (cm.equals("About me")) {
			this.view.hienThiAboutMe();
		} else if (cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		} else if (cm.equals("Save")) {
			this.view.thucHienSave();
		} else if (cm.equals("Open")) {
			this.view.thucHienOpen();
		}

	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
