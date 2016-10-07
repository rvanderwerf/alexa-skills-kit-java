/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.amazon.speech.speechlet;

import com.amazon.speech.slu.Intent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * The request object containing an {@link Intent} for {@code Speechlet} invocation.
 *
 * @see Speechlet#onAudioPlayerRequest(AudioPlayerRequestPlaybackFinished, Session)
 */
@JsonTypeName("AudioPlayerRequest")
public class AudioPlayerRequestPlaybackFinished extends AudioPlayerRequest {

    @JsonProperty("type")
    String audioType;



    /**
     * Returns a new builder instance used to construct a new {@code IntentRequest}.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Private constructor to return a new {@code IntentRequest} from a {@code Builder}.
     *
     * @param builder
     *            the builder used to construct the {@code IntentRequest}.
     */
    private AudioPlayerRequestPlaybackFinished(final Builder builder) {
        super(builder.requestId, builder.timestamp, builder.audioType, builder.token,builder.offsetInMilliseconds,builder.locale);

    }

    /**
     * Protected constructor used for JSON serialization and for extending this class.
     *
     * @param requestId
     *            the request identifier.
     * @param timestamp
     *            the request timestamp.
     * @param audioType
     *            the audio type to handle.
     * @param token
     *            token
     * @param offsetInMilliseconds
     *            offset on milliseconds to play
     * @param locale
     *            locale of audio to play if supported
     */
    protected AudioPlayerRequestPlaybackFinished(@JsonProperty("requestId") final String requestId,
												 @JsonProperty("timestamp") final Date timestamp,
												 @JsonProperty("type") final String audioType,
												 @JsonProperty("token") final String token,
												 @JsonProperty("offsetInMilliseconds") final int offsetInMilliseconds,
												 @JsonProperty("locale") final String locale) {
        super(requestId, timestamp, audioType, token, offsetInMilliseconds, locale);

    }



    /**
     * Builder used to construct a new {@code IntentRequest}.
     */
    public static final class Builder {
        private String requestId;
        private Date timestamp = new Date();
        private String audioType;
        private String token;
        private String locale;
        private int offsetInMilliseconds = 0;

        private Builder() {
        }

        public Builder withRequestId(final String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withTimestamp(final Date timestamp) {
            this.timestamp = (timestamp != null) ? new Date(timestamp.getTime()) : null;
            return this;
        }


        public Builder withType(final String audioType) {
            this.audioType = audioType;
            return this;
        }

        public Builder withToken(final String token) {
            this.token = token;
            return this;
        }
        public Builder withLocale(final String locale) {
            this.locale = locale;
            return this;
        }
        public Builder withOffsetInMilliseconds(final int offsetInMilliseconds) {
            this.offsetInMilliseconds = offsetInMilliseconds;
            return this;
        }

        public AudioPlayerRequestPlaybackFinished build() {
            Validate.notBlank(requestId, "RequestId must be defined");
            Validate.notBlank(audioType, "type must be defined");
            return new AudioPlayerRequestPlaybackFinished(this);
        }
    }
}
