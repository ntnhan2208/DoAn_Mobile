package vn.edu.stu.doangk.model;

public class Avenger {
    private Integer id;
    private String ten;
    private String anh;
    private Phe phe;
    private String vukhi;
    private String sucmanh;

    public Avenger() {
    }

    public Avenger(Integer id, String ten, String anh, Phe phe, String vukhi, String sucmanh) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.phe = phe;
        this.vukhi = vukhi;
        this.sucmanh = sucmanh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Phe getPhe() {
        return phe;
    }

    public void setPhe(Phe phe) {
        this.phe = phe;
    }

    public String getVukhi() {
        return vukhi;
    }

    public void setVukhi(String vukhi) {
        this.vukhi = vukhi;
    }

    public String getSucmanh() {
        return sucmanh;
    }

    public void setSucmanh(String sucmanh) {
        this.sucmanh = sucmanh;
    }
}
