package com.abeldandi.alitasecurity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataObject implements Parcelable {
    private String userID;
    private String status;
    private String roomID;
    private String time;
    private String date;

    public DataObject() {
    }

    public DataObject(String userID, String status, String roomID, String time, String date) {
        this.userID = userID;
        this.status = status;
        this.roomID = roomID;
        this.time = time;
        this.date = date;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userID);
        dest.writeString(status);
        dest.writeString(roomID);
        dest.writeString(time);
        dest.writeString(date);
    }

    protected DataObject(Parcel in) {
        userID = in.readString();
        status = in.readString();
        roomID = in.readString();
        time = in.readString();
        date = in.readString();
    }

    public static final Creator<DataObject> CREATOR = new Creator<DataObject>() {
        @Override
        public DataObject createFromParcel(Parcel in) {
            return new DataObject(in);
        }

        @Override
        public DataObject[] newArray(int size) {
            return new DataObject[size];
        }
    };
}
