#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package org.forgerock.openam.auth.nodes;

import static java.util.Arrays.asList;

import javax.inject.Inject;

import ${groupId}.auth.node.api.AbstractNodeAmPlugin;
import ${groupId}.auth.node.api.Node;
import ${groupId}.plugins.PluginException;
import ${groupId}.sm.AnnotatedServiceRegistry;

import com.iplanet.sso.SSOException;
import com.sun.identity.sm.SMSException;

/**
 * Core nodes installed by default with no engine dependencies.
 */
public class ${className}NodePlugin extends AbstractNodeAmPlugin {

    private final AnnotatedServiceRegistry serviceRegistry;

    /**
     * DI-enabled constructor.
     * @param serviceRegistry A service registry instance.
     */
    @Inject
    public ${className}NodePlugin(AnnotatedServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public String getPluginVersion() {
        return "1.0.0";
    }

    @Override
    public void onStartup() throws PluginException {
        for (Class<? extends Node> nodeClass : getNodes()) {
            pluginTools.registerAuthNode(nodeClass);
        }
    }

    @Override
    protected Iterable<? extends Class<? extends Node>> getNodes() {
        return asList(
                ${className}Node.class
        );
    }
}
