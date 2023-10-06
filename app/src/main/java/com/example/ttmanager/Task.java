package com.example.ttmanager;
import android.os.Parcel;
import android.os.Parcelable;
public class Task implements Parcelable{
    private String taskDescription;
    private int year;
    private int month;
    private int day;

    public Task(String taskDescription, int year, int month, int day) {
        this.taskDescription = taskDescription;
        this.year = year;
        this.month = month;
        this.day = day;

    }

    public String getTaskDescription() {
        return taskDescription;
    }

    @Override
    public String toString() {
        return taskDescription + " (Due: " + year + "-" + (month + 1) + "-" + day + ")";
    }

    // Parcelable implementation for transferring Task objects between activities
    // (generate Parcelable implementation in Android Studio)

    protected Task(Parcel in) {
        taskDescription = in.readString();
        year = in.readInt();
        month = in.readInt();
        day = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(taskDescription);
        dest.writeInt(year);
        dest.writeInt(month);
        dest.writeInt(day);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };
}

