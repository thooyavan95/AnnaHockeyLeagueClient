package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.FixturesAdapter
import com.ahl.annahockeyleague.kotlin.data.AhlData
import com.ahl.annahockeyleague.kotlin.data.FixturesData
import com.ahl.annahockeyleague.kotlin.kotlinfragments.AhlViewModel
import com.ahl.annahockeyleague.kotlin.kotlinfragments.UIThreadExecutor
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fixtures_fragment_layout.*

abstract class KotlinBaseFixtures : Fragment() {

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable

    var oldData : AhlData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::getData)
    }

    abstract fun getData(newState : AhlData)

    fun setLoader(){

    }

    fun setFixtures(fixturesDataData : List<FixturesData>) {

        val adapter = FixturesAdapter()
        adapter.updateFixturesData(fixturesDataData)
        fixtures_recycler_view.layoutManager = LinearLayoutManager(context)
        fixtures_recycler_view.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

}