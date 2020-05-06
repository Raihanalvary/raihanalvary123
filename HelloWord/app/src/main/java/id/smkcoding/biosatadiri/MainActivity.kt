package id.smkcoding.biosatadiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var NameInput:String = ""
    private var AgeInput:String = ""
    private var EmailInput:String = ""
    private var TelpInput:String = ""
    private var AddressInput:String = ""
    private var GenderInput:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnsave.setOnClickListener{goToProfilActivity() }

        fun setDataSpinnerGender(){
            val adapter = ArrayAdapter.createFromResource(this,
            R.array.Jenis_Kelamin, android.R.layout.simple_spinner_item)

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                 spinnerGender.adapter= adapter
        }
        fun validasiInput(){
        NameInput = edtName.text.toString()
        AgeInput = edtAge.text.toString()
        EmailInput = edtEmail.text.toString()
        TelpInput = edtTelp.text.toString()
        AddressInput = edtAddress.text.toString()
        GenderInput = spinnerGender.selectedItem.toString()

        when{
            NameInput.isEmpty()-> edtName.error = "Nama tidak boleh kosong"
            GenderInput.equals("Pilih Jenis Kelamin",ignoreCase = true)->tampilToast("Jenis Kelamin harus dipilih")
            EmailInput.isEmpty()-> edtEmail.error = "Email tidak boleh kosong"
            TelpInput.isEmpty()-> edtTelp.error = "Telp tidak boleh kosong"
            AddressInput.isEmpty()-> edtAddress.error = "Alamat tidak boleh kosong"

            else->{
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }

    }
    }
    private fun tampilToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", NameInput)
        bundle.putString("gender", GenderInput)
        bundle.putString("umur", AgeInput)
        bundle.putString("email",EmailInput)
        bundle.putString("telp", TelpInput)
        bundle.putString("alamat", AddressInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }

            }










