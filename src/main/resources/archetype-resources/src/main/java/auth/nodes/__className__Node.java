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

package org.forgerock.openam.auth.nodes;

import com.google.inject.assistedinject.Assisted;
import com.iplanet.sso.SSOException;
import com.sun.identity.idm.*;
import org.forgerock.json.JsonValue;
import ${groupId}.annotations.sm.Attribute;
import ${groupId}.auth.node.api.*;
import ${groupId}.core.CoreWrapper;
import ${groupId}.utils.CollectionUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

import static ${groupId}.auth.node.api.SharedStateConstants.AUTH_LEVEL;
import static ${groupId}.auth.node.api.SharedStateConstants.REALM;
import static ${groupId}.auth.node.api.SharedStateConstants.USERNAME;

/**
 * A node which contributes a configurable set of properties to be added to the user's session, if/when it is created.
 */
@Node.Metadata(outcomeProvider = SingleOutcomeNode.OutcomeProvider.class,
        configClass = ${className}Node.Config.class)
public class ${className}Node extends SingleOutcomeNode {

    private final CoreWrapper coreWrapper;
    private final Logger logger = LoggerFactory.getLogger("amAuth");
    private static final String BUNDLE = ${className}Node.class.getName().replace(".",
        "/");


    /**
     * Configuration for the node.
     */
    public interface Config {
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
    public ${className}Node(@Assisted Config config, CoreWrapper coreWrapper) {
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
        return goToNext().build();
    }

    /* Override this function if you want to add custom audit logs for this node.
     *
    @Override
    public JsonValue getAuditEntryDetail() {
        return json(object(field("key", "value"))));
    }
     */

}
