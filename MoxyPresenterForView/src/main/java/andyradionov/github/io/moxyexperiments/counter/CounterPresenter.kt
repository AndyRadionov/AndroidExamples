package andyradionov.github.io.moxyexperiments.counter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.InjectViewState



/**
 * @author Andrey Radionov
 */
@InjectViewState
class CounterPresenter : MvpPresenter<CounterView>() {
    private var mCount: Int = 0

    init {
        viewState.showCount(mCount)
    }

    fun onPlusClick() {
        mCount++
        viewState.showCount(mCount)
    }
}