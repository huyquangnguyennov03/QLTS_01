package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class thiSinh implements Serializable{
	private int maThiSinh;
	private String tenThiSinh;
	private tinh queQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private float diemMon1, diemMon2, diemMon3;
	
	public thiSinh() {
		super();
	}
	public thiSinh(int maThiSinh, String tenThiSinh, tinh queQuan, Date ngaySinh, boolean gioiTinh, float diemMon1,
			float diemMon2, float diemMon3) {
		super();
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	}
	public int getMaThiSinh() {
		return maThiSinh;
	}
	public String getTenThiSinh() {
		return tenThiSinh;
	}
	public tinh getQueQuan() {
		return queQuan;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public float getDiemMon1() {
		return diemMon1;
	}
	public float getDiemMon2() {
		return diemMon2;
	}
	public float getDiemMon3() {
		return diemMon3;
	}
	@Override
	public String toString() {
		return "thiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan + ", ngaySinh="
				+ ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1 + ", diemMon2=" + diemMon2
				+ ", diemMon3=" + diemMon3 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diemMon1, diemMon2, diemMon3, gioiTinh, maThiSinh, ngaySinh, queQuan, tenThiSinh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		thiSinh other = (thiSinh) obj;
		return Float.floatToIntBits(diemMon1) == Float.floatToIntBits(other.diemMon1)
				&& Float.floatToIntBits(diemMon2) == Float.floatToIntBits(other.diemMon2)
				&& Float.floatToIntBits(diemMon3) == Float.floatToIntBits(other.diemMon3) && gioiTinh == other.gioiTinh
				&& maThiSinh == other.maThiSinh && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(queQuan, other.queQuan) && Objects.equals(tenThiSinh, other.tenThiSinh);
	}
	
	
	
}
