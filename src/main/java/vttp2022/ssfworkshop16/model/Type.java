package vttp2022.ssfworkshop16.model;

import java.io.Serializable;

public class Type implements Serializable{
    private static final long serialVersionUID = 1L;
    private String type;
    private long count;

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }
}
