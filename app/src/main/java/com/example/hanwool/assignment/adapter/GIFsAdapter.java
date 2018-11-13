package com.example.hanwool.assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanwool.assignment.GIFsViewActivity;
import com.example.hanwool.assignment.LastestActivity;
import com.example.hanwool.assignment.R;
import com.example.hanwool.assignment.modal.Lastest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GIFsAdapter extends RecyclerView.Adapter<GIFsAdapter.ItemHolder>  {
    Context context;
    ArrayList<Lastest> arrayGIFs;
    ArrayList<Lastest> arrayResult;
    ProgressBar progressBar;
public static int index = 0;

    public GIFsAdapter(Context context, ArrayList<Lastest> arrayGIFs) {
        this.context = context;
        this.arrayGIFs = arrayGIFs;

    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_lastest,null);
        ItemHolder itemHolder= new ItemHolder(v);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, final int position) {
        Lastest Lastest = arrayGIFs.get(position);
index = position;
        holder.txtView.setText(Lastest.getView().toString());
        Picasso.with(context).load(Lastest.getImgLastest())
                .placeholder(R.drawable.ic_logo)
                .error(R.drawable.imgerror)
                .into(holder.imgLastest);


        Boolean exist = false;

        for (int a = 0; a<LastestActivity.arrGifFavor.size(); a++){
            if (arrayGIFs.get(position).getImgLastest().equals(LastestActivity.arrGifFavor.get(a).getImgLastest())){
                holder.chkFavor.setChecked(true);
                exist= true;
            }
        }

        if (exist==false){
            holder.chkFavor.setChecked(false);

        }
        holder.chkFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.chkFavor.isChecked()){
                    LastestActivity.arrGifFavor.add(new Lastest(arrayGIFs.get(position).getImgLastest(),
                            arrayGIFs.get(position).getView()));
                   // notifyDataSetChanged();
                    Toast.makeText(context, "Đã thêm vào yêu thích", Toast.LENGTH_SHORT).show();

                }
                else {
                    for (int i =0; i <LastestActivity.arrGifFavor.size(); i++){
                        if (LastestActivity.arrGifFavor.get(i).getImgLastest().equals(arrayGIFs.get(position).getImgLastest())){
                            LastestActivity.arrGifFavor.remove(i);
                            notifyDataSetChanged();
                            Toast.makeText(context, "Đã xóa khỏi yêu thích", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
//    public Filter getFilter() {
//        return new Filter() {
//
//
//
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                final FilterResults oReturn = new FilterResults();
//                final ArrayList<Lastest> results = new ArrayList<Lastest>();
//                if (arrayResult == null)
//                    arrayResult = arrayGIFs;
//                if (constraint != null) {
//                    if (arrayResult != null && arrayResult.size() > 0) {
//                        for (final Lastest Lastest : arrayResult) {
//                            if (Lastest.getTitle().toLowerCase().contains(constraint.toString()))
//
//                                results.add(Lastest);
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
//                arrayGIFs = (ArrayList<Lastest>) results.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    @Override
    public int getItemCount() {
        return arrayGIFs.size();
    }

    public class  ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imgLastest;
        public TextView txtView;
        public CheckBox chkFavor;

        public ItemHolder(View itemView) {
            super(itemView);
            imgLastest = itemView.findViewById(R.id.imgLastest);
            txtView= itemView.findViewById(R.id.txtViews);
            chkFavor= itemView.findViewById(R.id.imgFavourite);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, GIFsViewActivity.class);

                        intent.putExtra("url",arrayGIFs);
                        intent.putExtra("index", arrayGIFs.get(getPosition()));



                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }
    }

}