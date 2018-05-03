#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

/*
 * Copyright 2018 ForgeRock AS. All Rights Reserved
 *
 * Use of this code requires a commercial software license with ForgeRock AS.
 * or with one of its affiliates. All use shall be exclusively subject
 * to such license between the licensee and ForgeRock AS.
 */

package ${package}.auth.nodes;

import com.google.inject.assistedinject.Assisted;
import com.iplanet.sso.SSOException;
import com.sun.identity.idm.*;
import org.forgerock.json.JsonValue;
import org.forgerock.openam.annotations.sm.Attribute;
import org.forgerock.openam.auth.node.api.*;
import org.forgerock.openam.core.CoreWrapper;
import org.forgerock.openam.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

import static org.forgerock.openam.auth.node.api.SharedStateConstants.AUTH_LEVEL;
import static org.forgerock.openam.auth.node.api.SharedStateConstants.REALM;
import static org.forgerock.openam.auth.node.api.SharedStateConstants.USERNAME;

/**
 * A ${nodeName} node.
 * You can extend:
 * SingleOutcomeNode
 * AbstractDecisionNode
 * Or directly implement the Node interface.
 */
@Node.Metadata(outcomeProvider = SingleOutcomeNode.OutcomeProvider.class,
        configClass = ${nodeName}Node.Config.class)
public class ${nodeName}Node extends SingleOutcomeNode {

    private final CoreWrapper coreWrapper;
    private final Logger logger = LoggerFactory.getLogger(${nodeName}Node.class);
    private static final String BUNDLE = ${nodeName}Node.class.getName().replace(".", "/");

    /**
     * Configuration for the node.
     * It can have as many attributes as needed, or none.
     */
    public interface Config {
        // Example enumerated value
        @Attribute(order = 100)
        default ExampleEnum example() {
            // implemented as a default method as there is a default value
            return ExampleEnum.FALSE;
        }
    }

    private final Config config;

    /*
     * Constructs a new GetSessionPropertiesNode instance.
     * We can have Assisted:
     * * Config config
     * * UUID nodeId
     *
     * We may want to Inject:
     * CoreWrapper
     */
    @Inject
    public ${nodeName}Node(@Assisted Config config, CoreWrapper coreWrapper) {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    /*
     * From the context you will be able to access:
     * Callbacks
     * Shared State
     * Transient State
     *
     * We have certain Actions prefefined that we can use:
     * send -> send a callback
     * goTo -> go to a different node
     *
     * Look into ActionBuilder to see how to:
     * update shared state
     * add session hooks -> classes that will be executed post-authentication.
     */
    @Override
    public Action process(TreeContext context) {
        // Node logic here
        // This is an example of how to use the logger
        logger.debug("${className}Node started");
        logger.debug("Our attribute is: " + config.example());
        return goToNext().build();
    }

    /* Override this function if you want to add custom audit logs for this node.
     *
    @Override
    public JsonValue getAuditEntryDetail() {
        return json(object(field("key", "value"))));
    }
     */

    /**
     * Config state example
     */
    public enum ExampleEnum  {
        FALSE(false),
        TRUE(true);

        private final boolean isTrue;

        private ExampleEnum(boolean isTrue) {
            this.isTrue = isTrue;
        }

        public boolean isTrue() {
            return isTrue;
        }
    }

}
