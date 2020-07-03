package com.owen.sharedpreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CatsAdapter extends RecyclerView.Adapter<CatsAdapter.CatsViewHolder> {

    private Context mContext;
    private ArrayList<CatsShowGrounds> mCatsShowGrounds;

    public CatsAdapter(Context context, ArrayList<CatsShowGrounds> catsShowList)
    {
        this.mContext = context;
        this.mCatsShowGrounds = catsShowList;
    }

    @NonNull
    @Override
    public CatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a view
        View view = LayoutInflater.from(mContext).inflate(R.layout.cats_show, parent,false);
        return new CatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatsViewHolder holder, int position) {
        //get Item position and post
        CatsShowGrounds currentCat = mCatsShowGrounds.get(position);

        String imageUrl = currentCat.getImageUrl();
        String catName = currentCat.getCreator();
        int likesCounter = currentCat.getLikes();

        //now post the images to the UI
        holder.mTvCreateCat.setText(catName);
        holder.mTVLikeCat.setText("Likes: + " + likesCounter);

        //To load the image, we now use picasso library
        Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mCatsShowGrounds.size();
    }

    //create ViewHolderClass
    public class CatsViewHolder extends RecyclerView.ViewHolder{

        //create variables to hold the items in position
        public ImageView mImageView;
        public TextView mTvCreateCat;
        public TextView mTVLikeCat;

        public CatsViewHolder(@NonNull View itemView) {
            super(itemView);

            //find the views using Ids
            mImageView = itemView.findViewById(R.id.img_view);
            mTvCreateCat = itemView.findViewById(R.id.tv_create);
            mTVLikeCat= itemView.findViewById(R.id.tvLikes_Dn);
        }
    }


}
