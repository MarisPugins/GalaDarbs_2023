package com.example.galadarbs.FinalWork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.galadarbs.R;
import com.example.galadarbs.models.GameCard;

import java.util.ArrayList;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private OnCardClickListener onCardClickListener;
    public interface OnCardClickListener {
        void onCardClick(GameCard card);
    }

    private final ArrayList<GameCard> cardList;


    public CardAdapter(ArrayList<GameCard> cardList) {
        this.cardList = cardList;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card , parent , false);
        return new ItemCardViewHolder(itemView);
    }


    public void setOnCardClickListener(OnCardClickListener listener) {
        this.onCardClickListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        GameCard card = cardList.get(position);
        if(holder instanceof ItemCardViewHolder){


            ((ItemCardViewHolder) holder).cardValue.setText(String.valueOf(card.getValue()));
            ((ItemCardViewHolder) holder).cardImage.setImageResource(card.isOpened() ? card.getImageResource() : R.drawable.baseline_device_unknown_24);
            ((ItemCardViewHolder) holder).cardImage.setAlpha(card.isOpened() ? 1.0f : 0.5f);

        }

    }
    class ItemCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener   {
        public TextView cardValue;
        public ImageView cardImage;

        ItemCardViewHolder(@NonNull View itemView){
            super(itemView);
            cardValue = itemView.findViewById(R.id.cardValue);
            cardImage = itemView.findViewById(R.id.cardImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                // Get the card object at this position in the list
                GameCard card = cardList.get(position);

                // Call the onCardClickListener with the selected card
                if (onCardClickListener != null) {
                    onCardClickListener.onCardClick(card);
                }
            }
        }
    }


    @Override
    public int getItemCount() {
        return cardList.size();
    }

}
