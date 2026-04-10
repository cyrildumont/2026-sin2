package fr.epf.sin2.gc

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        parent: ViewGroup,
        viewType: Int
    ): ClientViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            inflater.inflate(R.layout.client_view,parent,false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(vh: ClientViewHolder, position: Int) {
        val client = clients[position] // clients.get(position)
        val view = vh.itemView

        view.click {
            view.context.apply {
                val intent =
                    Intent(this, DetailsClientActivity::class.java)
                intent.putExtra("CLIENT", client.fullName)
                startActivity(intent)
            }
        }

/*
        val fullNameTextview = view.findViewById<TextView>(R.id.client_fullname_textview)
        fullNameTextview.text = client.fullName
*/
        view.findViewById<TextView>(R.id.client_fullname_textview).apply {
            text = client.fullName
        }

        view.findViewById<ImageView>(R.id.client_imageview).apply {
            if(client.imageUri.isBlank()){
                Glide.with(view).load(client.image).into(this)
            }else{
                Glide.with(view).load(client.imageUri).into(this)
            }
        }


    }
    override fun getItemCount() = clients.size
}

private const val TAG = "ClientAdapter"





