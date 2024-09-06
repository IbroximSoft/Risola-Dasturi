package uz.ibrohim.risola

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import uz.ibrohim.risola.databinding.FragmentSplashBinding
import uz.ibrohim.risola.databinding.LanguageDialogBinding
import uz.ibrohim.risola.language.LanguageAdapter
import uz.ibrohim.risola.language.LanguageList
import uz.ibrohim.risola.utils.Preferences
import uz.ibrohim.risola.utils.languageIntents

class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var userArrayList: ArrayList<LanguageList>

    private var splashTimer = 4000
    private val mTimeCounter = object : CountDownTimer(splashTimer.toLong(), 100) {
        override fun onTick(p0: Long) {}

        override fun onFinish() {

            Preferences.init(requireContext())
            val language: String = Preferences.language
            if (language.isEmpty()) {
                getDialog()
            }else{
                findNavController().navigate(R.id.homeFragment)
            }
        }

        private fun getDialog() {
            val dialog = Dialog(requireContext())
            val bindings: LanguageDialogBinding = LanguageDialogBinding.inflate(
                LayoutInflater.from(requireContext()))

            dialog.setContentView(bindings.root)
            dialog.setCanceledOnTouchOutside(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
            dialog.window!!.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)
            dialog.show()

            val imageId = intArrayOf(R.drawable.language_flag, R.drawable.language_flag)
            val text = arrayOf("O'zbekcha", "Ўзбекча")

            userArrayList = ArrayList()

            for (i in text.indices) {
                val list = LanguageList(text[i], imageId[i])
                userArrayList.add(list)
            }

            bindings.apply {
                languageList.isClickable = true
                languageList.adapter = LanguageAdapter(requireContext() as Activity, userArrayList)

                languageList.onItemClickListener =
                    AdapterView.OnItemClickListener { _: AdapterView<*>?, _: View?, position: Int, _: Long ->
                        when (position) {
                            0 -> {
                                languageIntents(requireContext(), "uz")
                                findNavController().navigate(R.id.homeFragment)
                            }

                            1 -> {
                                languageIntents(requireContext(), "ru")
                                findNavController().navigate(R.id.homeFragment)
                            }
                        }
                    }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        mTimeCounter.start()

        return binding.root
    }
}