package com.diazbumma.mvpexample.main.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diazbumma.mvpexample.R;
import com.diazbumma.mvpexample.main.models.Hero;

import java.util.ArrayList;

public class HeroRecyclerAdapter extends RecyclerView.Adapter<HeroRecyclerAdapter.HeroViewHolder> {

    private ArrayList<Hero> heroes;
    private Context context;

    public HeroRecyclerAdapter(Context context, ArrayList<Hero> heroes) {
        this.context = context;
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_hero, viewGroup, false);

        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        Hero hero = heroes.get(i);
        heroViewHolder.bindHeroData(hero);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHeroPict;
        TextView tvName;
        TextView tvRealName;
        TextView tvCreatedBy;
        TextView tvFirstAppearance;
        TextView tvBio;

        HeroViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHeroPict = itemView.findViewById(R.id.iv_hero_pict);
            tvName = itemView.findViewById(R.id.tv_name);
            tvRealName = itemView.findViewById(R.id.tv_real_name);
            tvCreatedBy = itemView.findViewById(R.id.tv_created_by);
            tvFirstAppearance = itemView.findViewById(R.id.tv_first_appearance);
            tvBio = itemView.findViewById(R.id.tv_bio);
        }

        void bindHeroData(Hero hero) {
            tvName.setText(hero.getName());
            tvRealName.setText(hero.getRealName());
            tvCreatedBy.setText(hero.getCreatedBy());
            tvFirstAppearance.setText(hero.getFirstAppearance());
            tvBio.setText(hero.getBio());

            Glide.with(context)
                    .load(hero.getImageUrl())
                    .into(ivHeroPict);
        }
    }
}
