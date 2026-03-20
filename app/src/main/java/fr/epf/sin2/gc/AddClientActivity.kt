package fr.epf.sin2.gc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "AddClientActivity"

class AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val lastnameEdittext =  findViewById<EditText>(R.id.add_client_lastname_edittext)

        val addButton = findViewById<Button>(R.id.add_client_button)

        addButton.setOnClickListener{
            Log.d(TAG, "Nom: ${lastnameEdittext.text}")
        }
    }
}