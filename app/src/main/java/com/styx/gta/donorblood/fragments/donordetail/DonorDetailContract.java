/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.styx.gta.donorblood.fragments.donordetail;

import android.os.Bundle;
import android.view.View;

import com.styx.gta.donorblood.base.BasePresenter;
import com.styx.gta.donorblood.models.Donor;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DonorDetailContract {

    interface View {
        void bindDonorUI(android.view.View rootView, final Donor donor);
        Bundle getViewArguments();
        android.view.View getRootView();
    }

    interface Presenter extends BasePresenter {
    }
}
