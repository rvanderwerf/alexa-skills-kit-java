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

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code User} tied to a {@code Speechlet} {@code Session} is the user registered to the device
 * initiating the {@code Speechlet} {@code Session} and contains a unique identifier.
 *
 * @see Speechlet
 * @see Session
 * @see SpeechletException
 */
public class Device {
    private final List<String> supportedInterfaces;


    /**
     * Returns a new builder instance used to construct a new {@code IntentRequest}.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }


    @SuppressWarnings("unused")
    private Device() {
        this(new ArrayList<String>());
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
    private Device(@JsonProperty("supportedInterfaces") final List<String> supportedInterfaces) {

        this.supportedInterfaces = supportedInterfaces;

    }

    public List<String> getSupportedInterfaces() {
        return supportedInterfaces;
    }

    /**
     * Builder used to construct a new {@code User}.
     */
    public static final class Builder {
        private List<String> supportedInterfaces;

        private Builder() {
        }

        public Builder withSupportedInterfaces(final List<String> supportedInterfaces) {
            this.supportedInterfaces = supportedInterfaces;
            return this;
        }


        public Device build() {
            return new Device(this);
        }
    }
}
