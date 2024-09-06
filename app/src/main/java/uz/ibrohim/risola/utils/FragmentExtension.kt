package uz.ibrohim.risola.utils

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.saadiftkhar.toaster.Toaster
import com.yariksoffice.lingver.Lingver
import uz.ibrohim.risola.HomeActivity
import uz.ibrohim.risola.R

fun Fragment.warningToast(context: Context, string: String){
    Toaster.warning(context = context, text = string, font = R.font.inter_regular)
}

fun languageIntents(context: Context, language: String) {
    Preferences.init(context)
    Lingver.getInstance().setLocale(context, language)
    Preferences.language = language
    val intent = Intent(context, HomeActivity::class.java)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    context.startActivity(intent)
}