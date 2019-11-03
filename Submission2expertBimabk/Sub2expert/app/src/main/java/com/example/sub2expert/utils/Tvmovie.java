package com.example.sub2expert.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvmovie implements Parcelable {
    private String courseId;
    private String title;
    private String description;
    private String creator;
    private String tahun;
    private String imagePath;

    public Tvmovie(String courseId, String title, String description, String creator, String tahun, String imagePath) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.tahun = tahun;
        this.imagePath = imagePath;
    }

    protected Tvmovie(Parcel in) {
        courseId = in.readString();
        title = in.readString();
        description = in.readString();
        creator = in.readString();
        tahun = in.readString();
        imagePath = in.readString();
    }

    public static final Creator<Tvmovie> CREATOR = new Creator<Tvmovie>() {
        @Override
        public Tvmovie createFromParcel(Parcel in) {
            return new Tvmovie(in);
        }

        @Override
        public Tvmovie[] newArray(int size) {
            return new Tvmovie[size];
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getImagePath() {
        return imagePath;
    }
    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
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
        parcel.writeString(creator);
        parcel.writeString(tahun);
        parcel.writeString(imagePath);
    }
}
