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
 * @see Speechlet#onAudioPlayerRequest(AudioPlayerRequest, Session)
 */
@JsonTypeName("AudioPlayerRequest")
public class AudioPlayerRequest extends SpeechletRequest {

    @JsonProperty("type")
    String audioType;






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
    protected AudioPlayerRequest(@JsonProperty("requestId") final String requestId,
                                 @JsonProperty("timestamp") final Date timestamp,
                                 @JsonProperty("type") final String audioType,
                                 @JsonProperty("token") final String token,
                                 @JsonProperty("offsetInMilliseconds") final int offsetInMilliseconds,
                                 @JsonProperty("locale") final String locale) {
        super(requestId, timestamp, audioType, token, offsetInMilliseconds, locale);

    }




}
