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

package ${package};

import com.google.inject.assistedinject.Assisted;
import com.iplanet.sso.SSOException;
import com.sun.identity.idm.*;
import com.sun.identity.shared.debug.Debug;
import org.forgerock.json.JsonValue;
import ${groupId}.annotations.sm.Attribute;
import ${groupId}.auth.node.api.*;
import ${groupId}.core.CoreWrapper;
import ${groupId}.utils.CollectionUtils;

import javax.inject.Inject;
import java.util.*;

import static ${groupId}.auth.node.api.SharedStateConstants.AUTH_LEVEL;
import static ${groupId}.auth.node.api.SharedStateConstants.REALM;
import static ${groupId}.auth.node.api.SharedStateConstants.USERNAME;

/**
 * A node which contributes a configurable set of properties to be added to the user's session, if/when it is created.
 */
@Node.Metadata(outcomeProvider = SingleOutcomeNode.OutcomeProvider.class,
        configClass = TestNode.Config.class)
public class TestNode extends SingleOutcomeNode {

    private final static String DEBUG_FILE = "TestNode";
    protected Debug debug = Debug.getInstance(DEBUG_FILE);
    private final CoreWrapper coreWrapper;


    /**
     * Configuration for the node.
     */
    public interface Config {
    }

    private final Config config;

    /**
     * Constructs a new GetSessionPropertiesNode instance.
     * @param config Node configuration.
     */
    @Inject
    public TestNode(@Assisted Config config, CoreWrapper coreWrapper) {
        this.config = config;
        this.coreWrapper = coreWrapper;
    }

    @Override
    public Action process(TreeContext context) {
        // Node logic here
        return goToNext().build();
    }

}
