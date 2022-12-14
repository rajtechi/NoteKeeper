package com.rl.notekeeper;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class NoteInfo implements Parcelable {

    private CourseInfo mCourse;
    private String mTitle;
    private String mText;

    public NoteInfo(CourseInfo mCourse, String mTitle, String mtext) {
        this.mCourse = mCourse;
        this.mTitle = mTitle;
        this.mText = mtext;
    }

    public CourseInfo getmCourse() {
        return mCourse;
    }

    public void setmCourse(CourseInfo mCourse) {
        this.mCourse = mCourse;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    private String getCompareKey() {

        return mCourse.getmCourseId() + " | " + mTitle + " | " + mText;


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteInfo noteInfo = (NoteInfo) o;
        return getCompareKey().equals(noteInfo.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    protected NoteInfo(Parcel in) {
        mCourse = in.readParcelable(CourseInfo.class.getClassLoader());
        mTitle = in.readString();
        mText = in.readString();
    }

    public static final Creator<NoteInfo> CREATOR = new Creator<NoteInfo>() {
        @Override
        public NoteInfo createFromParcel(Parcel in) {
            return new NoteInfo(in);
        }

        @Override
        public NoteInfo[] newArray(int size) {
            return new NoteInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mCourse, i);
        parcel.writeString(mTitle);
        parcel.writeString(mText);
    }
}
