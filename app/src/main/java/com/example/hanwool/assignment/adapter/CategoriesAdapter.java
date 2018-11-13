package com.example.hanwool.assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanwool.assignment.ImageInCatActivity;
import com.example.hanwool.assignment.R;
import com.example.hanwool.assignment.modal.Categories;
import com.example.hanwool.assignment.modal.Categories;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ItemHolder>  {
    Context context;
    ArrayList<Categories> arrayCategories;
    ArrayList<Categories> arrayResult;
    ProgressBar progressBar;


    public CategoriesAdapter(Context context, ArrayList<Categories> arrayCategories) {
        this.context = context;
        this.arrayCategories = arrayCategories;

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_categories,null);
        ItemHolder itemHolder= new ItemHolder(v);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Categories categories = arrayCategories.get(position);
        holder.txtCat.setText(categories.getCateName()+ "("+ categories.getTotalWallpaper()+")");
        Picasso.with(context).load(categories.getCateImage())
                .placeholder(R.drawable.ic_logo)
                .error(R.drawable.imgerror)
                .into(holder.imgCategories);



    }
//    public Filter getFilter() {
//        return new Filter() {
//
//
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                final FilterResults oReturn = new FilterResults();
//                final ArrayList<Categories> results = new ArrayList<Categories>();
//                if (arrayResult == null)
//                    arrayResult = arrayCategories;
//                if (constraint != null) {
//                    if (arrayResult != null && arrayResult.size() > 0) {
//                        for (final Categories Categories : arrayResult) {
//                            if (Categories.getTitle().toLowerCase().contains(constraint.toString()))
//
//                                results.add(Categories);
//                        }
//                    }
//                    oReturn.values = results;
//                }
//                return oReturn;
//            }
//
//            @SuppressWarnings("unchecked")
//            @Override
//            protected void publishResults(CharSequence constraint,
//                                          FilterResults results) {
//                arrayCategories = (ArrayList<Categories>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    @Override
    public int getItemCount() {
        return arrayCategories.size();
    }

    public class  ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgCategories;
        public TextView txtCat;


        public ItemHolder(View itemView) {
            super(itemView);
            imgCategories = itemView.findViewById(R.id.imgCat);
            txtCat= itemView.findViewById(R.id.txtCat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImageInCatActivity.class);
                    intent.putExtra("cid",arrayCategories.get(getPosition()).getCatId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    //Toast.makeText(context, arrayCategories.get(getPosition()).getCatId().toString(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

}