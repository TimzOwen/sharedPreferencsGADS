package com.owen.sharedpreference;

public class CatsShowGrounds {

    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public CatsShowGrounds(String imageUrl, String creator, int likes)
    {
        this.mImageUrl = imageUrl;
        this.mCreator = creator;
        this.mLikes = likes;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }
    public String getCreator()
    {
        return mCreator;
    }
    public int getLikes()
    {
        return mLikes;
    }

}
