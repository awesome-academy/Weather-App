import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.ngadt.weatherapp.data.model.Weather
import kotlinx.coroutines.Delay
import java.sql.Time
import java.util.Timer
import java.util.TimerTask

abstract class BaseActivity<T : ViewBinding>(private val inflater: (LayoutInflater) -> T) :
    AppCompatActivity() {
    protected val binding: T by lazy { inflater(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initData()
    }

    abstract fun initData()
}
