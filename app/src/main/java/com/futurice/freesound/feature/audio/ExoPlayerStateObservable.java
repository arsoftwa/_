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

package com.futurice.freesound.feature.audio;

import com.google.android.exoplayer2.ExoPlayer;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;

import static com.futurice.freesound.common.utils.Preconditions.get;

/**
 * Make an Observable from the ExoPlayer player state.
 *
 * Based upon techniques used in the RxBinding library.
 */
final class ExoPlayerStateObservable extends Observable<ExoPlayerState> {

    @NonNull
    private final ExoPlayer exoPlayer;

    private final boolean emitInitial;

    @Inject
    ExoPlayerStateObservable(@NonNull final ExoPlayer exoPlayer) {
        this(exoPlayer, true);
    }

    ExoPlayerStateObservable(@NonNull final ExoPlayer exoPlayer,
                             final boolean emitInitial) {
        this.exoPlayer = get(exoPlayer);
        this.emitInitial = emitInitial;
    }

    @Override
    protected void subscribeActual(final Observer<? super ExoPlayerState> observer) {
        Listener listener = new Listener(exoPlayer, observer);
        observer.onSubscribe(listener);
        exoPlayer.addListener(listener);
        if (emitInitial) {
            emitValue(ExoPlayerState.create(exoPlayer.getPlayWhenReady(),
                                            exoPlayer.getPlaybackState()),
                      observer);
        }
    }

    private static class Listener extends BaseAudioPlayerEventListener<ExoPlayerState> {

        Listener(@NonNull final ExoPlayer exoPlayer,
                 @NonNull final Observer<? super ExoPlayerState> observer) {
            super(exoPlayer, observer);
        }

        @Override
        public void onPlayerStateChanged(final boolean playWhenReady, final int playbackState) {
            // Strictly speaking, this check is not required because the listener is removed
            // upon disposal, therefore ExoPlayer won't keep it around to notify of changes.
            if (!isDisposed()) {
                emitValue(ExoPlayerState.create(playWhenReady, playbackState), observer);
            }
        }

    }

    private static void emitValue(@NonNull final ExoPlayerState exoPlayerState,
                                  @NonNull final Observer<? super ExoPlayerState> observer) {
        observer.onNext(exoPlayerState);
    }
}
