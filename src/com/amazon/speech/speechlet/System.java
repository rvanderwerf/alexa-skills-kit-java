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
import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * A {@code Session} represents a single execution of a {@code Speechlet} by a user.
 * </p>
 *
 * <p>
 * Multiple executions of a {@code Speechlet} are tied to separate {@code Session}s with different
 * identifiers. If the user explicitly exits the {@code Speechlet} and restarts it immediately
 * after, the new execution of the {@code Speechlet} will be associated with a new {@code Session},
 * regardless of how much time elapsed between the two runs.
 * </p>
 *
 * <p>
 * A {@code Session} is tied to the specific user registered to the device initiating the
 * {@code Speechlet} {@code Session}. A {@code Session} provides state that is maintained between
 * the multiple invocations of a {@code Speechlet}.
 * </p>
 *
 * <p>
 * The attributes of a {@code Session} are simple key-value pairs that are maintained between
 * invocations. You can use them to store lightweight data. They are comparable to session cookies
 * that you would use in a system where the client is a browser. Ending the session by closing the
 * browser would clear those cookies.
 * </p>
 *
 *
 * <p>
 * If the {@code Speechlet} throws a {@code SpeechletException}, modifications to the attributes up
 * to that point are applied, even if the request was not processed successfully.
 * </p>
 *
 * <p>
 * Because a {@code Speechlet} is a cloud-based service, the life-cycle of the actual session object
 * passed in the {@code Speechlet} methods is unrelated to the Alexa skill execution as experienced
 * by the user interacting with the speech-enabled device. A {@code Speechlet} receives a new
 * {@code Session} instance for each {@code Speechlet} invocation. The identifier of the
 * {@code Session} is what uniquely identifies it between invocations. References to a
 * {@code Session} should never be stored as its contents is invalid after returning from a
 * {@code Speechlet} method.
 * </p>
 *
 * @see Speechlet
 * @see SpeechletException
 */
public final class System {
    private final Application application;
    private final User user;
    private final Device device;


    /**
     * Returns a new builder instance used to construct a new {@code Session}.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Private constructor to return a new {@code Session} from a {@code Builder}.
     *
     * @param builder
     *            the builder used to construct the {@code Session}.
     */
    private System(final Builder builder) {

        application = builder.application;
        device = builder.device;
        user = builder.user;
    }

    /**
     * Private constructor used for JSON serialization.
     *
     * @param application
     *            the application
     * @param user
     *            the user associated with this session
     * @param device
     *            the user device
     */
    private System(@JsonProperty("application") final Application application,
                   @JsonProperty("user") final User user,
                   @JsonProperty("device") final Device device) {

        this.application = application;
        this.user = user;
        this.device = device;
    }

    /**
     * This is only for Jackson to figure out what default values are (e.g. isNew = false).
     */
    private System() {
        this.application = null;
        this.user = null;
        this.device = null;
    }

    /**
     * Returns the application.
     *
     * @return the application
     */
    public Application getApplication() {
        return application;
    }

    /**
     * Returns all the session attributes.
     *
     * @return a mutable map of all the attributes that may be altered directly
     */


    /**
     * Returns the user associated with this session.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

	/**
     * user device info
     * @return
     */
    public Device getDevice() {
        return device;
    }

    /**
     * Builder used to construct a new {@code Session}.
     */
    public static final class Builder {

        private Application application;
        private User user;
        private Device device;

        private Builder() {
        }



        public Builder withApplication(final Application application) {
            this.application = application;
            return this;
        }



        public Builder withUser(final User user) {
            this.user = user;
            return this;
        }

        public Builder withDevice(final Device user) {
            this.device = device;
            return this;
        }

        public System build() {
            return new System(this);
        }
    }
}
