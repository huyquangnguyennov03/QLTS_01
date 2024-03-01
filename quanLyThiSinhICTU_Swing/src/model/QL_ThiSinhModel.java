package model;

import java.util.ArrayList;

public class QL_ThiSinhModel {
	private ArrayList<thiSinh> dsThiSinhs;
	private String luaChon;
	private String tenFile;
	
	public QL_ThiSinhModel() {
		this.dsThiSinhs = new ArrayList<thiSinh>();
	}

	public QL_ThiSinhModel(ArrayList<thiSinh> dsThiSinhs) {
		this.dsThiSinhs = dsThiSinhs;
		this.luaChon = "";
		this.tenFile = "";
	}

	public ArrayList<thiSinh> getDsThiSinhs() {
		return dsThiSinhs;
	}
	
	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public void setDsThiSinhs(ArrayList<thiSinh> dsThiSinhs) {
		this.dsThiSinhs = dsThiSinhs;
	}
	
	public void insert(thiSinh thiSinh) {
		this.dsThiSinhs.add(thiSinh);
	}
	public void delete(thiSinh thiSinh) {
		this.dsThiSinhs.remove(thiSinh);
	}
	public void update(thiSinh thiSinh) {
		this.dsThiSinhs.remove(thiSinh);
		this.dsThiSinhs.add(thiSinh);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(thiSinh tSinh) {
		for (thiSinh thiSinhh : dsThiSinhs) {
			if(thiSinhh.getMaThiSinh() == tSinh.getMaThiSinh())
				return true;
		}
		return false;
	}
	
	
}
