package com.example.msi.fastparking;

/**
 * Created by msi on 7/1/2016.
 */
public class ParkingSlots {
    private String position,usedBy;
    private boolean available = false;
    private int special;
    public ParkingSlots(String position,int special){
        this.position = position;
        this.available = true;
        this.usedBy = null;
        this.special = special;
    }
    public ParkingSlots(String position, boolean available, String usedBy,int special){
        this.position = position;
        this.available = available;
        this.usedBy = usedBy;
        this.special = special;
    }
    public String getPosition(){
        return position;
    }
    public boolean isAvailable(){
        return available;
    }
    public String getUsedBy(){
        return usedBy;
    }
    public int getSpecial(){
        return special;
    }
}
