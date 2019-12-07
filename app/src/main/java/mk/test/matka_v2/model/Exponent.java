package mk.test.matka_v2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Exponent implements Parcelable {
    private String title;
    private String content;
    private ArrayList<String> images;

    public Exponent (){}

    protected Exponent(Parcel in) {
        title = in.readString();
        images = in.createStringArrayList();
        content = in.readString();
    }

    public static final Creator<Exponent> CREATOR = new Creator<Exponent>() {
        @Override
        public Exponent createFromParcel(Parcel in) {
            return new Exponent(in);
        }

        @Override
        public Exponent[] newArray(int size) {
            return new Exponent[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeStringList(images);
        parcel.writeString(content);
    }
}
