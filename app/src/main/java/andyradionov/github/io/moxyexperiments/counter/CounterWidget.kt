package andyradionov.github.io.moxyexperiments.counter

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import andyradionov.github.io.moxyexperiments.R
import com.arellomobile.mvp.MvpDelegate
import com.arellomobile.mvp.presenter.InjectPresenter


/**
 * @author Andrey Radionov
 */
class CounterWidget(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs), CounterView {

    private lateinit var mParentDelegate: MvpDelegate<*>
    private val mMvpDelegate: MvpDelegate<CounterWidget> = MvpDelegate(this)

    @InjectPresenter
    lateinit var mCounterPresenter: CounterPresenter
    private val mCounterTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.item_counter, this, true)
        mCounterTextView = findViewById(R.id.count_text) as TextView
        val button = findViewById<Button>(R.id.plus_button)
        button.setOnClickListener({ view -> mCounterPresenter.onPlusClick() })
    }

    fun init(parentDelegate: MvpDelegate<*>) {
        mParentDelegate = parentDelegate
        mMvpDelegate.setParentDelegate(mParentDelegate, id.toString())

        mMvpDelegate.onCreate()
        mMvpDelegate.onAttach()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        mMvpDelegate.onSaveInstanceState()
        mMvpDelegate.onDetach()
    }

    override fun showCount(count: Int) {
        mCounterTextView.text = count.toString()
    }
}