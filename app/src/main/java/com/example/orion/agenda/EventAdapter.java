package com.example.orion.agenda;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Orion on 14/04/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.eventViewHolder> {
    private ArrayList<Event> eventList;


    public EventAdapter(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public eventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event,parent,false);
        //eventViewHolder event=new eventViewHolder(v);
        return new eventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(eventViewHolder holder, int position) {
        holder.tvEvento.setText(eventList.get(position).getEvento());
        holder.tvEventoFecha.setText(eventList.get(position).getFecha());
        holder.tvEventoHora.setText(eventList.get(position).getHora());
        holder.tvEventoDescrip.setText(eventList.get(position).getDescripcion());
        holder.tvTel.setText(eventList.get(position).getTel());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class eventViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private TextView tvEvento;
        private TextView tvEventoFecha;
        private TextView tvEventoHora;
        private TextView tvEventoDescrip;
        private TextView tvTel;

        public eventViewHolder(View itemView) {
            super(itemView);

            tvEvento=(TextView) itemView.findViewById(R.id.tvEvento);
            tvEventoFecha=(TextView) itemView.findViewById(R.id.tvEventoFecha);
            tvEventoHora=(TextView) itemView.findViewById(R.id.tvEventoHora);
            tvEventoDescrip=(TextView) itemView.findViewById(R.id.tvEventoDescrip);
            tvTel=(TextView) itemView.findViewById(R.id.tvTel);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem edit=menu.add(Menu.NONE,1,1,"Edit");
            MenuItem delete=menu.add(Menu.NONE,2,2,"Delete");
            MenuItem call=menu.add(Menu.NONE,3,3,"Call");
            edit.setOnMenuItemClickListener(listenerOnEditMenu);
            delete.setOnMenuItemClickListener(listenerOnDeleteMenu);
            call.setOnMenuItemClickListener(listenerOnCallMenu);
        }

        MenuItem.OnMenuItemClickListener listenerOnEditMenu=new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        };

        MenuItem.OnMenuItemClickListener listenerOnDeleteMenu=new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        };

        MenuItem.OnMenuItemClickListener listenerOnCallMenu=new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        };
    }

}
