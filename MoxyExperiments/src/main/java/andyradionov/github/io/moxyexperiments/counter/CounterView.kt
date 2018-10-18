package andyradionov.github.io.moxyexperiments.counter

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.arellomobile.mvp.MvpView

/**
 * @author Andrey Radionov
 */
interface CounterView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showCount(count: Int)
}