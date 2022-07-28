package vttp2022.ssfworkshop16.model;

import java.io.Serializable;
import java.util.Random;

public class Welcome4 implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private byte[] pieces;
    private String id;
    private int insertCount;
    private int updateCount;
    private boolean upsert;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public byte[] getPieces() { return pieces; }
    public void setPieces(byte[] value) { this.pieces = value; }

    public Welcome4() {this.id = generateId(8);}
    private synchronized String generateId(int numchars) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < numchars) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0, numchars);
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public int getInsertCount() {return insertCount;}
    public void setInsertCount(int insertCount) {this.insertCount = insertCount;}

    public int getUpdateCount() {return updateCount;}
    public void setUpdateCount(int updateCount) {this.updateCount = updateCount;}

    public boolean isUpsert() {return upsert;}
    public void setUpsert(boolean upsert) {this.upsert = upsert;}

    
    
}
