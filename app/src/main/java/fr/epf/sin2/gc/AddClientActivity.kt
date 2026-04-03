package fr.epf.sin2.gc

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "AddClientActivity"

class AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        val lastnameEdittext =  findViewById<EditText>(R.id.add_client_lastname_edittext)

        val addButton = findViewById<Button>(R.id.add_client_button)

        val genderGroup = findViewById<RadioGroup>(R.id.add_client_gender_radiogroup)

        val ageTextview = findViewById<TextView>(R.id.add_client_age_textview)
        val ageSeekbar = findViewById<SeekBar>(R.id.add_client_age_seekbar)

      
        
        ageSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                p0: SeekBar?,
                progress: Int,
                p2: Boolean
            ) {
                ageTextview.text = progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) = Unit
            override fun onStopTrackingTouch(p0: SeekBar?) = Unit

        });
        
        addButton.setOnClickListener{
            Log.d(TAG, "Nom: ${lastnameEdittext.text}")

            val gender =
                if(genderGroup.checkedRadioButtonId == R.id.add_client_gender_man_radiobutton)
                    "Homme" else "Femme"

            Log.d(TAG, "Sexe : ${gender}")
            Log.d(TAG, "Age: ${ageSeekbar.progress}")


            Toast.makeText(this, "Bravo !!", Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}