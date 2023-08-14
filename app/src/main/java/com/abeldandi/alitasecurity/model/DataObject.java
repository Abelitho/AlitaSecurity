package com.abeldandi.alitasecurity.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataObject implements Parcelable {
    private String userID;
    private String status;
    private String roomID;
    private String time;

    public DataObject() {
    }

    public DataObject(String userID, String status, String roomID, String time) {
        this.userID = userID;
        this.status = status;
        this.roomID = roomID;
        this.time = time;
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
    }

    protected DataObject(Parcel in) {
        userID = in.readString();
        status = in.readString();
        roomID = in.readString();
        time = in.readString();
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
