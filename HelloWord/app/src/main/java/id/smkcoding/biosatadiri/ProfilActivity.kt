package id.smkcoding.biosatadiri

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    companion object{
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()

        btnEditName.setOnClickListener{navigasiKeEditProfil()}

        btnCall.setOnClickListener{dialPhoneNumber(txtTelp.text.toString())}

    }

    private fun ambilData(){
        val bundle = intent.extras

        val nama = bundle?.getString("nama")
        val gender = bundle?.getString("Gender")
        val umur = bundle?.getString("Umur")
        val email = bundle?.getString("Email")
        val telp = bundle?.getString("Telp")
        val alamat = bundle?.getString("alamat")

        txtName.text=nama
        txtGender.text=gender
        txtUmur.text=umur
        txtEmail.text=email
        txtTelp.text=telp
        txtAddress.text=alamat
    }
    private fun navigasiKeEditProfil(){
        val intent = Intent(this, EditProfilActivity::class.java)

        val namaUser = txtName.text.toString()
        intent.putExtra("nama",namaUser)

        startActivityForResult(intent, REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {


                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{

                Toast.makeText()
            }
        }
    }
        
    }





