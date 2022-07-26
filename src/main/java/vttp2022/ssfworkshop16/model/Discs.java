package vttp2022.ssfworkshop16.model;

import java.io.Serializable;

public class Discs implements Serializable{
    private static final long serialVersionUID = 1L;
    private long totalCount;
    private Type[] types;

    public long getTotalCount() { return totalCount; }
    public void setTotalCount(long value) { this.totalCount = value; }

    public Type[] getTypes() { return types; }
    public void setTypes(Type[] value) { this.types = value; }
}
