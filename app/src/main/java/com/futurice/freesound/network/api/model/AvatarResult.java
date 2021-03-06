package com.futurice.freesound.network.api.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import android.support.annotation.NonNull;

import static com.futurice.freesound.common.utils.Preconditions.get;

@AutoValue
public abstract class AvatarResult {

    @NonNull
    public abstract String small();

    @NonNull
    public abstract String medium();

    @NonNull
    public abstract String large();

    @NonNull
    public static TypeAdapter<AvatarResult> typeAdapter(@NonNull final Gson gson) {
        return new AutoValue_AvatarResult.GsonTypeAdapter(get(gson));
    }

    @SuppressWarnings("NullableProblems")
    @AutoValue.Builder
    public interface Builder {

        @NonNull
        Builder small(@NonNull final String small);

        @NonNull
        Builder medium(@NonNull final String medium);

        @NonNull
        Builder large(@NonNull final String large);

        @NonNull
        AvatarResult build();
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_AvatarResult.Builder();
    }
}
