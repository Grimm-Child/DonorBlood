package com.styx.gta.donorblood.fragments.donorlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.styx.gta.donorblood.R;
import com.styx.gta.donorblood.adapters.DonorBaseAdapter;
import com.styx.gta.donorblood.base.BaseFragment;

/**
 * Created by amal.george on 24-11-2016.
 */

public class DonorListFragment extends BaseFragment implements DonorListContract.View {
    public static final String TAG = "DonorListFragment";
    private DonorListContract.Presenter presenter;
    DonorBaseAdapter adapter = new DonorBaseAdapter();

    @Override
    protected void initUI() {
        setScreenTitle("DonorListFragment");
        setScreenLayout(R.layout.fragment_donor_list);
    }

    @Override
    protected void setUI(Bundle savedInstanceState) {
        presenter = new DonorListPresenter(this);
        RecyclerView mRecyclerView = ((RecyclerView) rootView.findViewById(R.id.rv_donor_list));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter.setContext(getContext());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void doOnce() {
        presenter.request();
    }

    @Override
    public DonorBaseAdapter getAdapter() {
        return adapter;
    }

    @Override
    public Bundle getViewArguments() {
        return getArguments();
    }


}
