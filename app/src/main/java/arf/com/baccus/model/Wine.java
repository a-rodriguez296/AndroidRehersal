package arf.com.baccus.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arodriguez on 9/1/15.
 */
public class Wine {

    public Wine(String name, String type, int photo, String companyName, String companyWeb, String notes, String origin, int rating) {
        mName = name;
        mType = type;
        mPhoto = photo;
        mCompanyName = companyName;
        mCompanyWeb = companyWeb;
        mNotes = notes;
        mOrigin = origin;
        mRating = rating;
    }

    private String mName = null;
    private String mType = null;
    private int mPhoto = 0;
    private String mCompanyName = null;
    private String mCompanyWeb = null;
    private String mNotes = null;
    private String mOrigin = null;
    private int mRating = 0;
    private List<String> mgrapes = new LinkedList<>();

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        mRating = rating;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public void setOrigin(String origin) {
        mOrigin = origin;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }

    public String getCompanyWeb() {
        return mCompanyWeb;
    }

    public void setCompanyWeb(String companyWeb) {
        mCompanyWeb = companyWeb;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public void setCompanyName(String companyName) {
        mCompanyName = companyName;
    }

    public int getPhoto() {
        return mPhoto;
    }

    public void setPhoto(int photo) {
        mPhoto = photo;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}



