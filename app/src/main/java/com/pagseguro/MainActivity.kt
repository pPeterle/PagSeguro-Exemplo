package com.pagseguro

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import br.com.uol.pslibs.checkout_in_app.PSCheckout
import kotlinx.android.synthetic.main.activity_main1.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val fragmentTransaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, BlankFragment.newInstance())
        fragmentTransaction.commitAllowingStateLoss()

        setSupportActionBar(toolbar)

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        //Fornece controle para LIB de Activity results
        PSCheckout.onActivityResult(
            this,
            requestCode,
            resultCode,
            data
        ) //Controle Lib Activity Life Cycle
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //Android 6+ fornece controle para LIB para request de permissões
        PSCheckout.onRequestPermissionsResult(
            this,
            requestCode,
            permissions,
            grantResults
        ) //Controle Lib Activity Life Cycle
    }

    override fun onBackPressed() {
        if (PSCheckout.onBackPressed(this)) { //Controle Lib Button back
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                PSCheckout.onHomeButtonPressed(this) //Controle Lib Home Button
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        PSCheckout.onDestroy() //Controle Lib Activity Life Cycle
    }
}
