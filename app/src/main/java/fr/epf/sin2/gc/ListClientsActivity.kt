package fr.epf.sin2.gc

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.sin2.gc.model.Client
import fr.epf.sin2.gc.model.Gender
import fr.epf.sin2.gc.services.ClientService
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ListClientsActivity : AppCompatActivity() {

    private lateinit  var recyclerview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_clients)

        val clients = Client.generateList()

        recyclerview = findViewById<RecyclerView>(R.id.clients_recyclerview)
        recyclerview.apply {
            layoutManager =
                LinearLayoutManager(this@ListClientsActivity,
                    LinearLayoutManager.VERTICAL,false)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_clients,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_client_action -> {
                startActivity(Intent(this, AddClientActivity::class.java))
            }
            R.id.synchro_action -> {
                synchroClients()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Synchronisation des clients avec RandomUser
     */
    private fun synchroClients() {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://randomuser.me/")
            .client(client)
            .build()

        val clientService =
            retrofit.create<ClientService>(ClientService::class.java)

        runBlocking {
            val response = clientService.listClients()
            val clients = response.results.map {
                Client(
                    it.name.last,
                    it.name.first,
                    if (it.gender == "male") Gender.MAN else Gender.WOMAN,
                    it.picture.thumbnail
                )
            }
            recyclerview.adapter = ClientAdapter(clients)

        }

    }


}