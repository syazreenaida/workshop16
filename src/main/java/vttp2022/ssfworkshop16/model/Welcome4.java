package vttp2022.ssfworkshop16.model;

import java.io.Serializable;

public class Welcome4 implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private Pieces pieces;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Pieces getPieces() { return pieces; }
    public void setPieces(Pieces value) { this.pieces = value; }
}
