package com.example.albumsmvvm.activities

import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.albumsmvvm.viewmodel.AlbumViewModel
import com.example.albumsmvvm.viewmodel.ViewModelFactory

open class BaseActivity : AppCompatActivity() {

    val viewModel: AlbumViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(AlbumViewModel::class.java)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showToast(msg: String?) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    fun showAlert(msg: String?): AlertDialog =
        AlertDialog.Builder(this)
            .setTitle("Atenção")
            .setMessage(msg)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .show()
}