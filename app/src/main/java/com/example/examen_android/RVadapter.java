package com.example.examen_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RVadapter extends RecyclerView.Adapter<RVadapter.EnemyViewHolder> {
    public static class EnemyViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView enemyName;
        TextView enemyAge;
        TextView enemyDescription;

        EnemyViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            enemyName = itemView.findViewById(R.id.item_input_name);
            enemyAge = itemView.findViewById(R.id.item_input_age);
            enemyDescription = itemView.findViewById(R.id.item_input_description);
        }
    }

    List<Enemy> enemies;
    Context context;
    private CustomItemClick listener;

    RVadapter(List<Enemy> enemies,Context context,CustomItemClick listener){
        this.enemies = enemies;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public EnemyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        final EnemyViewHolder evh = new EnemyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v, evh.getAdapterPosition());
            }
        });

        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EnemyViewHolder enemyViewHolder, int i) {
        enemyViewHolder.enemyName.setText(enemies.get(i).getName());
        enemyViewHolder.enemyAge.setText(enemies.get(i).getAge());
        enemyViewHolder.enemyDescription.setText(enemies.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return enemies.size();
    }

    public Context getContext(){return context;}
}
