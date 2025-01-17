package uz.ibrohim.risola

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.ibrohim.risola.utils.warningToast
import uz.ibrohim.risola.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}