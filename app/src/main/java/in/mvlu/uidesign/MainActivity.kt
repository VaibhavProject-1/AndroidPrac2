package `in`.mvlu.uidesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

import java.security.KeyStore.TrustedCertificateEntry

class MainActivity : AppCompatActivity() {

    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var cbAgeCheck: CheckBox
    private lateinit var btnSave: Button
    private var isMale : Boolean = true
    private var areYou18: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        onClick()

    }

    private fun onClick() {

        rgGender.setOnCheckedChangeListener { _, checkedId ->
            /*if (checkedId == R.id.rb_male) {
                isMale = true
            } else if (checkedId == R.id.rb_female) {
                isMale = false
            }*/
            when (checkedId) {
                R.id.rb_male -> isMale = true
                R.id.rb_female -> isMale = false
            }
        }

        cbAgeCheck.setOnCheckedChangeListener { _, isChecked ->
            areYou18 = isChecked
        }

        btnSave.setOnClickListener {
            val builder: StringBuilder = StringBuilder("First Name: ")
            builder.append(etFirstName.text.toString()).append("\n")
            builder.append(" Last Name: ")
            builder.append(etLastName.text.toString()).append("\n")
            builder.append(" Gender: ")
            builder.append(if (isMale) "Male" else "Female").append("\n")
            builder.append(" Are you 18+: ")
            builder.append(if (areYou18) "Yes" else "No").append("\n")



            Toast.makeText(this,builder.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    private fun initComponent() {
        etFirstName = findViewById(R.id.et_first_name)
        etLastName = findViewById(R.id.et_last_name)
        rgGender = findViewById(R.id.rg_gender)
        cbAgeCheck = findViewById(R.id.cb_age_check)
        btnSave = findViewById(R.id.btn_save)
    }

}

