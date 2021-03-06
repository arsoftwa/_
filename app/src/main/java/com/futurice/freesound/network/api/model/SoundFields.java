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

package com.futurice.freesound.network.api.model;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.futurice.freesound.common.utils.Preconditions.get;

/**
 * TODO This could be auto-generated by an annotation processor
 */
public final class SoundFields {

    public static final SoundFields BASE = new SoundFields.Builder()
            .id()
            .url()
            .name()
            .tags()
            .description()
            .geotag()
            .username()
            .images()
            .previews()
            .duration()
            .build();

    private static final String ID = "id";
    private static final String URL = "url";
    private static final String NAME = "name";
    private static final String TAGS = "tags";
    private static final String DESCRIPTION = "description";
    private static final String GEOTAG = "geotag";
    private static final String USERNAME = "username";
    private static final String IMAGES = "images";
    private static final String PREVIEWS = "previews";
    private static final String DURATION = "duration";

    @NonNull
    private final Set<String> fields;

    private SoundFields(@NonNull Set<String> fields) {
        this.fields = get(fields);
    }

    @Override
    public String toString() {
        return RequestHelper.asCommaSeparated(fields);
    }

    private static class Builder {

        @NonNull
        private final Set<String> fields = new HashSet<>();

        Builder id() {
            add(ID);
            return this;
        }

        Builder url() {
            add(URL);
            return this;
        }

        Builder name() {
            add(NAME);
            return this;
        }

        Builder tags() {
            add(TAGS);
            return this;
        }

        Builder description() {
            add(DESCRIPTION);
            return this;
        }

        Builder geotag() {
            add(GEOTAG);
            return this;
        }

        Builder username() {
            add(USERNAME);
            return this;
        }

        Builder images() {
            add(IMAGES);
            return this;
        }

        Builder previews() {
            add(PREVIEWS);
            return this;
        }

        Builder duration() {
            add(DURATION);
            return this;
        }

        private void add(String field) {
            fields.add(field);
        }

        SoundFields build() {
            return new SoundFields(Collections.unmodifiableSet(fields));
        }

    }

}
