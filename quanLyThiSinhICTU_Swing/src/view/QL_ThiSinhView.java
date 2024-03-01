package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QL_ThiSinhModel;
import model.thiSinh;
import model.tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.QL_ThiSinhController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Thread.Builder.OfVirtual;
import java.awt.event.ActionEvent;

public class QL_ThiSinhView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QL_ThiSinhModel model;
	public JTextField textField_MTS1;
	public JTable table;
	public JTextField textField_MTS;
	public JTextField textField_HoVaTen;
	public JTextField textField_diemToan;
	public JTextField textField_diemVan;
	public JTextField textField_diemAnh;
	public JTextField textField_ngaySinh;
	public JComboBox comboBox_queQuan;
	public ButtonGroup btn_gioitinh;
	public JRadioButton rd_nam;
	public JRadioButton rd_nu;
	public JComboBox comboBox_queQuanTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QL_ThiSinhView frame = new QL_ThiSinhView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QL_ThiSinhView() {
		this.model = new QL_ThiSinhModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 617);

		Action action = new QL_ThiSinhController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.addActionListener(action);
		menuFile.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelQueQuan = new JLabel("Quê quán");
		labelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelQueQuan.setBounds(10, 16, 86, 45);
		contentPane.add(labelQueQuan);

		JLabel labelMTS = new JLabel("Mã thí sinh");
		labelMTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMTS.setBounds(231, 16, 100, 45);
		contentPane.add(labelMTS);

		textField_MTS1 = new JTextField();
		textField_MTS1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_MTS1.setColumns(10);
		textField_MTS1.setBounds(323, 19, 121, 38);
		contentPane.add(textField_MTS1);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(action);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTimKiem.setBounds(454, 22, 108, 32);
		contentPane.add(btnTimKiem);

		comboBox_queQuanTimKiem = new JComboBox();
		ArrayList<tinh> listTinh = tinh.getDSTinh();
		comboBox_queQuanTimKiem.addItem("");
		for (tinh tinh : listTinh) {
			comboBox_queQuanTimKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuanTimKiem.setBounds(95, 20, 126, 37);
		contentPane.add(comboBox_queQuanTimKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 71, 666, 2);
		contentPane.add(separator_1);

		JLabel labelDSTS = new JLabel("Danh sách thí sinh");
		labelDSTS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDSTS.setBounds(10, 71, 209, 45);
		contentPane.add(labelDSTS);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD v\u00E0 t\u00EAn", "Qu\u00EA qu\u00E1n",
						"Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m to\u00E1n", "\u0110i\u1EC3m v\u0103n",
						"\u0110i\u1EC3m anh" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 109, 666, 146);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 265, 666, 2);
		contentPane.add(separator_1_1);

		JLabel labelDSTS_1 = new JLabel("Thông tin thí sinh");
		labelDSTS_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDSTS_1.setBounds(10, 261, 209, 45);
		contentPane.add(labelDSTS_1);

		JLabel labelMaThiSinh = new JLabel("Mã thí sinh");
		labelMaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMaThiSinh.setBounds(10, 299, 121, 45);
		contentPane.add(labelMaThiSinh);

		textField_MTS = new JTextField();
		textField_MTS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_MTS.setColumns(10);
		textField_MTS.setBounds(130, 302, 149, 31);
		contentPane.add(textField_MTS);

		JLabel labelHoVaTen = new JLabel("Họ và tên");
		labelHoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHoVaTen.setBounds(10, 337, 100, 45);
		contentPane.add(labelHoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(130, 343, 149, 31);
		contentPane.add(textField_HoVaTen);

		JLabel labelQueQuan2 = new JLabel("Quê quán");
		labelQueQuan2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelQueQuan2.setBounds(10, 374, 93, 45);
		contentPane.add(labelQueQuan2);

		JLabel labelDiemToan = new JLabel("Điểm toán");
		labelDiemToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDiemToan.setBounds(375, 299, 121, 45);
		contentPane.add(labelDiemToan);

		textField_diemToan = new JTextField();
		textField_diemToan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_diemToan.setColumns(10);
		textField_diemToan.setBounds(495, 302, 149, 32);
		contentPane.add(textField_diemToan);

		JLabel labelDiemVan = new JLabel("Điểm văn");
		labelDiemVan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDiemVan.setBounds(375, 337, 121, 45);
		contentPane.add(labelDiemVan);

		textField_diemVan = new JTextField();
		textField_diemVan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_diemVan.setColumns(10);
		textField_diemVan.setBounds(495, 343, 149, 32);
		contentPane.add(textField_diemVan);

		JLabel labelDiemAnh = new JLabel("Điểm anh");
		labelDiemAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDiemAnh.setBounds(375, 374, 121, 45);
		contentPane.add(labelDiemAnh);

		textField_diemAnh = new JTextField();
		textField_diemAnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_diemAnh.setColumns(10);
		textField_diemAnh.setBounds(495, 379, 149, 34);
		contentPane.add(textField_diemAnh);

		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNgaySinh.setBounds(10, 416, 121, 45);
		contentPane.add(labelNgaySinh);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(130, 425, 149, 32);
		contentPane.add(textField_ngaySinh);

		comboBox_queQuan = new JComboBox();
		comboBox_queQuan.addItem("");
		for (tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan.setBounds(130, 384, 149, 31);
		contentPane.add(comboBox_queQuan);

		JLabel labelGioiTinh = new JLabel("Giới tính");
		labelGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelGioiTinh.setBounds(375, 416, 93, 45);
		contentPane.add(labelGioiTinh);

		rd_nam = new JRadioButton("Nam");
		rd_nam.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		rd_nam.setBounds(493, 425, 87, 21);
		contentPane.add(rd_nam);

		rd_nu = new JRadioButton("Nữ");
		rd_nu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rd_nu.setBounds(582, 428, 60, 21);
		contentPane.add(rd_nu);

		btn_gioitinh = new ButtonGroup();
		btn_gioitinh.add(rd_nam);
		btn_gioitinh.add(rd_nu);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(19, 505, 112, 32);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(action);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(155, 504, 112, 32);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(285, 505, 112, 32);
		contentPane.add(btnXoa);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLuu.setBounds(411, 505, 112, 32);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyBo.setBounds(544, 505, 112, 32);
		contentPane.add(btnHuyBo);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 496, 666, 2);
		contentPane.add(separator_1_2);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuyTim.setBounds(572, 22, 104, 32);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_MTS.setText("");
		textField_MTS1.setText("");
		textField_HoVaTen.setText("");
		textField_ngaySinh.setText("");
		textField_diemToan.setText("");
		textField_diemVan.setText("");
		textField_diemAnh.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioitinh.clearSelection();
	}

	public void themThiSinhVaoTable(thiSinh tSinh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(
				new Object[] { tSinh.getMaThiSinh() + "", tSinh.getTenThiSinh(), tSinh.getQueQuan().getTenTinh(),
						tSinh.getNgaySinh().getDate() + "/" + (tSinh.getNgaySinh().getMonth() + 1) + "/"
								+ (tSinh.getNgaySinh().getYear() + 1900),
						(tSinh.isGioiTinh() ? "Nam" : "Nữ"), tSinh.getDiemMon1() + "", tSinh.getDiemMon2() + "",
						tSinh.getDiemMon3() + "", });
	}

	public void themSinhVienOrSua(thiSinh tSinh) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(tSinh)) {
			this.model.insert(tSinh);
			this.themThiSinhVaoTable(tSinh);

		} else {
			this.model.update(tSinh);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(tSinh.getMaThiSinh() + "")) {
					model_table.setValueAt(tSinh.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(tSinh.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(tSinh.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(tSinh.getNgaySinh().getDate() + "/" + (tSinh.getNgaySinh().getMonth() + 1)
							+ "/" + (tSinh.getNgaySinh().getYear() + 1900), i, 3);
					model_table.setValueAt((tSinh.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(tSinh.getDiemMon1() + "", i, 5);
					model_table.setValueAt(tSinh.getDiemMon2() + "", i, 6);
					model_table.setValueAt(tSinh.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public void suaThiSinh(thiSinh tSinh) {
		// TODO Auto-generated method stub

	}

	public thiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel(); // Hiện thị donngf người dùng nhập
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		tinh tnh = tinh.gettinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");

		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		thiSinh tSinh = new thiSinh(maThiSinh, tenThiSinh, tnh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return tSinh;
	}

	public void hienThiThongTinThiSinhDaChon() {
		thiSinh tSinh = getThiSinhDangChon();

		this.textField_MTS.setText(tSinh.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(tSinh.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(tSinh.getQueQuan().getTenTinh());
		String s_ngaySinh = tSinh.getNgaySinh().getDate() + "/" + (tSinh.getNgaySinh().getMonth() + 1) + "/"
				+ (tSinh.getNgaySinh().getYear() + 1900);
		this.textField_ngaySinh.setText(s_ngaySinh + "");
		if (tSinh.isGioiTinh()) {
			rd_nam.setSelected(true);
		} else {
			rd_nu.setSelected(true);
		}
//		this.btn_gioitinh.setSelected(null, gioiTinh);
		this.textField_diemToan.setText(tSinh.getDiemMon1() + "");
		this.textField_diemVan.setText(tSinh.getDiemMon2() + "");
		this.textField_diemAnh.setText(tSinh.getDiemMon3() + "");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");

		if (luaChon == JOptionPane.YES_OPTION) {
			thiSinh tSinh = getThiSinhDangChon();
			this.model.delete(tSinh);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThem() {
		// Get dữ liệu
		int maThiSinh = Integer.valueOf(this.textField_MTS.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		tinh tnh = tinh.gettinhByID(queQuan);
		Date ngaySinh = new Date(this.textField_ngaySinh.getText());
		boolean gioiTinh = true;
		if (this.rd_nam.isSelected()) {
			gioiTinh = true;
		}
		if (this.rd_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_diemToan.getText());
		float diemMon2 = Float.valueOf(this.textField_diemVan.getText());
		float diemMon3 = Float.valueOf(this.textField_diemAnh.getText());

		thiSinh tSinh = new thiSinh(maThiSinh, tenThiSinh, tnh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themSinhVienOrSua(tSinh);

	}

	public void thucHienTimKiem() {
		// Gọi hàm hủy tìm kiếm
		this.thucHienHuyTimKiem();
		// Thực hiện hủy tìm kiếm
		int queQuan = this.comboBox_queQuanTimKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MTS1.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel(); // Hiện thị dòng người dùng nhập
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			String tenTinhDaChon = this.comboBox_queQuanTimKiem.getSelectedItem().toString();
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2).toString();
				String id = model_table.getValueAt(i, 0).toString();
				if (!tenTinh.equals(tenTinhDaChon)) {
					idThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienHuyTimKiem() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0)
				break;
			else
				model_table.removeRow(0);
		}

		for (thiSinh tSinh2 : this.model.getDsThiSinhs()) {
			this.themThiSinhVaoTable(tSinh2);
		}
	}

	public void hienThiAboutMe() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý 1.0");

	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát khỏi chương trình?", "Exit",
				JOptionPane.YES_NO_OPTION);

		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (thiSinh ts : this.model.getDsThiSinhs()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thucHienSave() {
		String tenFile = this.model.getTenFile();
		if (tenFile != null && tenFile.length() > 0) {

			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			thiSinh ts = null;
			while ((ts = (thiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinhs(ds);
		;
	}

	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienHuyTimKiem();
		}
	}
}
