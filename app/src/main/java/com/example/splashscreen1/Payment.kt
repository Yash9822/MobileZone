package com.example.splashscreen1

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_payment.*


class Payment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val toolbar_detail_product: Toolbar = findViewById(R.id.toolbar_detail_product)
        setSupportActionBar(toolbar_detail_product)
        getSupportActionBar()?.setTitle("Payment")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        var payment: Button = findViewById(R.id.payment)
        var click:TextView = findViewById(R.id.click)

        var name:String? = intent.getStringExtra("Name")

        payment.setOnClickListener {

            var installed = appInstalledOrNot("com.whatsapp")
            if (installed) {
                var i: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+919810160184&text=Hi This is "
                        +name+" here!, I have done my payment procedure and I'm sending you the screenshot of the payment receipt"))
                startActivity(i)
                click.apply {
                    setVisibility(View.VISIBLE)
                }
            } else {
                Toast.makeText(this@Payment, "Whatsapp not installed on your device", Toast.LENGTH_SHORT).show()
            }
        }


        click.setOnClickListener {
            startActivity(Intent(this@Payment,Thank_You::class.java))
        }

    }
    private fun appInstalledOrNot(uri: String): Boolean {
        val pack = packageManager
        val installed: Boolean
        installed = try {
            pack.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return installed
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {

        outState.putInt("Visibility",click.visibility)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        click.visibility = savedInstanceState.getInt("Visibility")
    }
}
