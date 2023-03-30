package com.example.galadarbs.FinalWork;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galadarbs.R;
import com.example.galadarbs.models.GameCard;

import java.util.ArrayList;
import java.util.Collections;

public class FindJokerFragment extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private CardAdapter adapter;
    private ArrayList<GameCard> cardList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.final_card_game , container , false);
        recyclerView = view.findViewById(R.id.card_recycle_view);
        createCardList();
        adapter = new CardAdapter(cardList);

        adapter.setOnCardClickListener(new CardAdapter.OnCardClickListener() {
            @Override
            public void onCardClick(GameCard card) {
                int position = cardList.indexOf(card);
                if (card.isOpened()) {
                    Toast.makeText(getContext(), "Card is already opened", Toast.LENGTH_SHORT).show();
                } else {
                    card.setOpened(true);
                    adapter.notifyItemChanged(position);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        if (cardList.stream().filter(GameCard::isOpened).count() == 21) {
                            Toast.makeText(getContext(), "You win!", Toast.LENGTH_SHORT).show();
                        } else if (cardList.size() - cardList.stream().filter(GameCard::isOpened).count() < 3) {
                            Toast.makeText(getContext(), "You lose!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));




        return view;

    }

    private void createCardList() {
        for (int i = 1; i <= 13; i++) {
            cardList.add(new GameCard(i, R.drawable.card_club));
            cardList.add(new GameCard(i, R.drawable.card_diamond));
            cardList.add(new GameCard(i, R.drawable.card_heart));
            cardList.add(new GameCard(i, R.drawable.card_spade));
        }
        cardList.add(new GameCard(14, R.drawable.card_joker));
        Collections.shuffle(cardList);
    }





}
