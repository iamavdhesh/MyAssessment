package com.app.myassesment

import androidx.lifecycle.*
import com.app.myassesment.core.BaseActivity
import com.app.myassesment.repository.api.network.Resource
import com.app.myassesment.widget.MyRecyclerView

/**
 * Created by Avdhesh Kumar on 05,Sept,2020
 */

/**
 * Syntactic sugar for [LiveData.observe] function where the [Observer] is the last parameter.
 * Hence can be passed outside the function parenthesis.
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline observer: (T) -> Unit) {
    this.observe(owner, Observer { it?.apply(observer) })
}

/**
 * Eliminates the boiler plate on the UI when dealing with `LiveData<Resource<T>>`
 * type from `Repository`.
 * It internally updates the [list] based upon the status and executes
 * the [f] only if status is either SUCCESS or ERROR.
 */
fun <ResultType> Resource<ResultType>.load(list: MyRecyclerView, f: (ResultType?) -> Unit) {
    list.showState(status)
    load(f)
}

/**
 * Eliminates the boiler plate on the UI when dealing with `LiveData<Resource<T>>`
 * type from `Repository`.
 * It internally executes the [f] only if status is either SUCCESS or ERROR.
 */
fun <ResultType> Resource<ResultType>.load(f: (ResultType?) -> Unit) {
    if (!status.isLoading()) {
        f(data)
    }
}

/**
 * Synthetic sugaring to get instance of [ViewModel] for [AppCompatActivity].
 */
inline fun <reified T : ViewModel> BaseActivity<T>.getViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory).get(T::class.java)
}