package vttp2022.ssfworkshop16.model;

import java.io.Serializable;

public class Board implements Serializable{
    private static final long serialVersionUID = 1L;
    private long totalCount;
    private Discs squares;

    public long getTotalCount() { return totalCount; }
    public void setTotalCount(long value) { this.totalCount = value; }

    public Discs getSquares() { return squares; }
    public void setSquares(Discs value) { this.squares = value; }
}
