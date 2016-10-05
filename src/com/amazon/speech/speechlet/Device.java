/**
    Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.amazon.speech.speechlet;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * The {@code User} tied to a {@code Speechlet} {@code Session} is the user registered to the device
 * initiating the {@code Speechlet} {@code Session} and contains a unique identifier.
 *
 * @see Speechlet
 * @see Session
 * @see SpeechletException
 */
public class Device {
    private final Map<String,Object> supportedInterfaces;


    /**
     * Returns a new builder instance used to construct a new {@code IntentRequest}.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }




    /**
     * Private constructor to return a new {@code User} from a {@code Builder}.
     *
     * @param builder
     *            the builder used to construct the {@code User}
     */
    private Device(final Builder builder) {
        this.supportedInterfaces = builder.supportedInterfaces;
    }

    /**
     * Private constructor used for JSON serialization.
     *
     * @param supportedInterfaces
     *            list of supported interfaces
     */
    private Device(@JsonProperty("supportedInterfaces") final Map<String,Object> supportedInterfaces) {

        if (supportedInterfaces != null) {
            this.supportedInterfaces = supportedInterfaces;
        } else {
            this.supportedInterfaces = new HashMap<String,Object>();
        }


    }

    public Map<String,Object> getSupportedInterfaces() {
        return supportedInterfaces;
    }

    /**
     * Builder used to construct a new {@code User}.
     */
    public static final class Builder {
        private Map<String,Object> supportedInterfaces;

        private Builder() {
        }

        public Builder withSupportedInterfaces(final Map<String,Object> supportedInterfaces) {
            this.supportedInterfaces = supportedInterfaces;
            return this;
        }


        public Device build() {
            return new Device(this);
        }
    }
}
