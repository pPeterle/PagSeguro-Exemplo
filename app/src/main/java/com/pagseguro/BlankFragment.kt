package com.pagseguro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.uol.pslibs.checkout_in_app.PSCheckout
import br.com.uol.pslibs.checkout_in_app.wallet.util.PSCheckoutConfig
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_blank.view.*

class BlankFragment : Fragment() {
    private val SELLER_EMAIL = ""
    private val SELLER_TOKEN = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        initWallet()


        view.list_card.setOnClickListener {
            Toast.makeText(activity, "Listar cartões", Toast.LENGTH_SHORT).show()
            PSCheckout.showListCards()
        }

        return view
    }

    private fun initWallet() {
        //Inicialização a lib com parametros necessarios
        val psCheckoutConfig = PSCheckoutConfig()
        psCheckoutConfig.sellerToken = SELLER_TOKEN
        psCheckoutConfig.sellerEmail = SELLER_EMAIL
        //Informe o fragment container
        psCheckoutConfig.container = R.id.fragment_container

        //Inicializa apenas os recursos da carteira
        PSCheckout.initWallet(activity, psCheckoutConfig)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()

    }
}