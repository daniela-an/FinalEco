package appmoviles.com.appsmoviles20191;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterGames extends RecyclerView.Adapter<AdapterGames.CustomViewHolder> {

    ArrayList<GameModel> data;

    public AdapterGames(){
        data = new ArrayList<>();
    }

    public void showAllGames(ArrayList<GameModel> games) {
        for(int i = 0 ; i<games.size() ; i++){
            if(!data.contains(games.get(i))) data.add(games.get(i));
        }
        notifyDataSetChanged();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout root;
        public CustomViewHolder(LinearLayout v) {
            super(v);
            root = v;
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.renglon_game, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        ((TextView) holder.root.findViewById(R.id.renglon_game_name)).setText(data.get(position).getName());
        holder.root.findViewById(R.id.renglon_game_vote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(data.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener{
        void onItemClick(GameModel game);
    }

    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener){
        this.listener = listener;
    }

}