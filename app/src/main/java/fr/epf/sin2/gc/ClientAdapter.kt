package fr.epf.sin2.gc

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.epf.sin2.gc.model.Client

/*
class ClientViewHolder extends RecyclerView.ViewHolder {
    public ClientViewHolder(View view){
        super(view)
    }
}*/

class ClientViewHolder(view : View) : RecyclerView.ViewHolder(view)

class ClientAdapter(val clients : List<Client>) : RecyclerView.Adapter<ClientViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ClientViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(p0: ClientViewHolder, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = clients.size

}