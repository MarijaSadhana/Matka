package mk.test.matka_v2.model;

import java.util.ArrayList;

public class VideosResponse {
    private int numberOfItems;
    private ArrayList<Video> videos;

    public VideosResponse(){}

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
