package com.styx.gta.donorblood.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.styx.gta.donorblood.R;
import com.styx.gta.donorblood.constants.Constants;
import com.styx.gta.donorblood.constants.UserAction;
import com.styx.gta.donorblood.fragments.AboutFragment;
import com.styx.gta.donorblood.fragments.DonorDetailFragment;
import com.styx.gta.donorblood.fragments.donorlist.view.DonorListFragment;
import com.styx.gta.donorblood.fragments.home.view.HomeFragment;
import com.styx.gta.donorblood.interfaces.UserActionListener;
import com.styx.gta.donorblood.utilities.Logger;

/**
 * Created by amal.george on 25-11-2016.
 */

public class BaseActivity extends AppCompatActivity implements UserActionListener {
    public static final String TAG = "BaseActivity";

    protected boolean isFragmentExistsInBackStack(String tag) {
        if (getSupportFragmentManager().findFragmentByTag(tag) != null)
            return true;
        else
            return false;
    }

    public void addFragment(final int mContainer, final Fragment mFragment,
                            final String mTag) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        fragmentTransaction.replace(mContainer, mFragment, mTag);
        fragmentTransaction.addToBackStack(mTag);
        fragmentTransaction.commit();
    }

    public void popBackStack(String tag, int flag) {
        this.getSupportFragmentManager().popBackStack(tag, flag);
    }

    public BaseFragment getTopFragment() {
        return ((BaseFragment) this.getSupportFragmentManager().findFragmentById(R.id.fl_content));
    }

    @Override
    public void doUserAction(UserAction mUserAction, Bundle mBundle) {
        int mLayout = R.id.fl_content;
        Fragment mFragment;
        try {
            switch (mUserAction) {
                case HOME_SCREEN:
                    if (isFragmentExistsInBackStack(HomeFragment.TAG)) {
                        if (getTopFragment() instanceof HomeFragment)
                            return;
                        popBackStack(HomeFragment.TAG, 0);
                    } else {
                        mFragment = new HomeFragment();
                        mFragment.setArguments(mBundle);
                        addFragment(mLayout, mFragment, HomeFragment.TAG);
                    }
                    break;
                case DONOR_LIST_FRAGMENT:
                    if (isFragmentExistsInBackStack(DonorListFragment.TAG)) {
                        if (getTopFragment() instanceof DonorListFragment)
                            return;
                        popBackStack(DonorListFragment.TAG, 0);
                    } else {
                        mFragment = new DonorListFragment();
                        mFragment.setArguments(mBundle);
                        addFragment(mLayout, mFragment, DonorListFragment.TAG);
                    }
                    break;
                case DONOR_DETAIL_FRAGMENT:
                    if (isFragmentExistsInBackStack(DonorDetailFragment.TAG)) {
                        if (getTopFragment() instanceof DonorDetailFragment)
                            return;
                        popBackStack(DonorDetailFragment.TAG, 0);
                    } else {
                        mFragment = new DonorDetailFragment();
                        mFragment.setArguments(mBundle);
                        addFragment(mLayout, mFragment, DonorDetailFragment.TAG);
                    }
                    break;
                case ABOUT_FRAGMENT:
                    if (isFragmentExistsInBackStack(AboutFragment.TAG)) {
                        if (getTopFragment() instanceof AboutFragment)
                            return;
                        popBackStack(AboutFragment.TAG, 0);
                    } else {
                        mFragment = new AboutFragment();
                        mFragment.setArguments(mBundle);
                        addFragment(mLayout, mFragment, AboutFragment.TAG);
                    }
                    break;

            }
        } catch (NullPointerException mNullPointerException) {
            Logger.e(TAG, getString(R.string.debug_null));
        }
    }
}