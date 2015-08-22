package de.derandroidpro.recyclerviewtutorial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RvAdapterKlasse extends RecyclerView.Adapter<RvAdapterKlasse.ViewHolderKlasse> {


    public class ViewHolderKlasse extends RecyclerView.ViewHolder{

        TextView itemTextView;
        ImageView itemImageView;


        public ViewHolderKlasse(View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.textViewItem);
            itemImageView = (ImageView) itemView.findViewById(R.id.imageViewItem);

        }
    }


    @Override
    public ViewHolderKlasse onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout1, null);

        return new ViewHolderKlasse(itemView1);
    }

    @Override
    public void onBindViewHolder(ViewHolderKlasse viewHolderKlasse, final int i) {

        viewHolderKlasse.itemTextView.setText(MainActivity.itemTexte.get(i));
        viewHolderKlasse.itemImageView.setImageResource(MainActivity.itemFotoIDs.get(i));

        viewHolderKlasse.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.tv1.setText(MainActivity.itemTexte.get(i));

/*
                switch (i){

                    case 0: //deinCode
                        break;
                    case 1: //deinCode
                        break;  *
                } */
            }
        });

        viewHolderKlasse.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                MainActivity.itemTexte.remove(i);
                MainActivity.itemFotoIDs.remove(i);
                notifyDataSetChanged();


                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return MainActivity.itemTexte.size();
    }
}
