package id.smkcoding.biosatadiri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_profil.*

class EditProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        val intentData = intent.extras
        val nameUser = intentData?.getString("nama")

        edtProfilName.setText(nameUser)

        btnEditSave.setOnClickListener { saveData() }
    }

    private fun saveData(){
        val nameEdit = edtProfilName.text.toString()
        if (!nameEdit.isEmpty()) {
            val result = Intent()

            result.putExtra("nama", nameEdit)
            setResult(Activity.RESULT_OK, result)
        } else {

            setResult((Activity.RESULT_CANCELED)
            )
            finish()
        }

    }
}
