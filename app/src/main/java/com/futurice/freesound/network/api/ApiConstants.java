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

package com.futurice.freesound.network.api;

import com.futurice.freesound.common.InstantiationForbiddenError;

/**
 * Constants used in the Freesound API.
 */
final class ApiConstants {

    static final String TOKEN_QUERY_PARAM = "token";
    static final String IS_GEO_TAGGED_FILTER_QUERY_PARAM = "is_geotagged";

    private ApiConstants() {
        throw new InstantiationForbiddenError();
    }
}
