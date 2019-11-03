package com.example.sub2expert.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String courseId;
    private String title;
    private String description;
    private String sutradara;
    private String tahun;
    private String imagePath;

    public Film(String courseId, String title, String description, String sutradara, String tahun, String imagePath) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.sutradara = sutradara;
        this.tahun = tahun;
        this.imagePath = imagePath;
    }

    protected Film(Parcel in) {
        courseId = in.readString();
        title = in.readString();
        description = in.readString();
        sutradara = in.readString();
        tahun = in.readString();
        imagePath = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }
    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(courseId);
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(sutradara);
        parcel.writeString(tahun);
        parcel.writeString(imagePath);
    }
}
