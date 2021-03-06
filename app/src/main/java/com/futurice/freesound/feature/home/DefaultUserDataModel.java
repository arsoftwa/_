/*
 * Copyright 2016 Futurice GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.futurice.freesound.feature.home;

import com.futurice.freesound.network.api.FreeSoundApi;
import com.futurice.freesound.network.api.model.UserResult;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import io.reactivex.Single;

import static com.futurice.freesound.common.utils.Preconditions.get;

final class DefaultUserDataModel implements UserDataModel {

    @VisibleForTesting
    static final String USER_NAME = "SpiceProgram";

    @NonNull
    private final FreeSoundApi freeSoundApi;

    DefaultUserDataModel(@NonNull final FreeSoundApi freeSoundApi) {
        this.freeSoundApi = get(freeSoundApi);
    }

    @NonNull
    @Override
    public Single<UserResult> getHomeUser() {
        return freeSoundApi.user(USER_NAME);
    }
}
