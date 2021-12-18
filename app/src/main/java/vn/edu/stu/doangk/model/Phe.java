package vn.edu.stu.doangk.model;

import java.io.Serializable;
import java.util.Objects;

public class Phe implements Serializable {
    private Integer ma;
    private String tenphe;
    private static int newma = 1;

    public Phe(String tenphe) {
        this.ma = newma++;
        this.tenphe = tenphe;
    }

    @Override
    public String toString() {
        return ma + "   " + tenphe;
    }

    public Integer getMa() {
        return ma;
    }

    public String getTenphe() {
        return tenphe;
    }

    public void setTenphe(String tenphe) {
        this.tenphe = tenphe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phe phe = (Phe) o;
        return Objects.equals(tenphe, phe.tenphe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenphe);
    }
}

