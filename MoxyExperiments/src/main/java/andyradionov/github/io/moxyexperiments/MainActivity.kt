package andyradionov.github.io.moxyexperiments

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter_1.init(mvpDelegate)
        counter_2.init(mvpDelegate)
    }
}
