/**
 * Created on Apr 5, 2005
 */
package com.activiti.repo.version.lightweight;

import java.util.Collection;
import java.util.Map;

import com.activiti.repo.node.AssociationExistsException;
import com.activiti.repo.node.InvalidNodeRefException;
import com.activiti.repo.node.NodeService;
import com.activiti.repo.ref.NodeRef;
import com.activiti.repo.ref.Path;

/**
 * THe light weight version store node service implementation.
 * 
 * @author Roy Wetherall
 */
public class LightWeightVersionStoreNodeService extends LightWeightVersionStoreBase //implements NodeService 
{
    /**
     * Error messages
     */
    private final static String MSG_UNSUPPORTED = 
        "This operation is not supported by a version store implementation of the node service.";
//    
//    /**
//     * @see #createNode(NodeRef, String, String, Map)
//     */
//    public NodeRef createNode(NodeRef parentRef, String name, String nodeType) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * Creates a new, non-abstract, real node as a primary child of the given parent node.
//     * 
//     * @param parentRef the parent node
//     * @param name the name of the child association between the parent and the new child
//     * @param nodeType a predefined node type
//     * @param properties optional map of properties to assign to the node
//     * @return Returns a reference to the newly created node
//     * @throws InvalidNodeRefException if the parent reference is invalid
//     */
//    public NodeRef createNode(NodeRef parentRef,
//            String temp,
//            String name,
//            String nodeType,
//            Map<String, String> properties) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * Deletes the given node.
//     * 
//     * @param nodeRef reference to a node within a store
//     * @throws InvalidNodeRefException if the reference given is invalid
//     */
//    public void deleteNode(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * Makes a parent-child association between the given nodes.  Both nodes must belong to the same store.
//     * 
//     * @param parentRef
//     * @param childRef 
//     * @param name the name of the association
//     * @throws InvalidNodeRefException if the parent or child nodes could not be found
//     */
//    public void addChild(NodeRef parentRef, NodeRef childRef, String temp, String name) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * Severs all parent-child relationships between two nodes.
//     * <p>
//     * The child node will be cascade deleted if one of the associations was the
//     * primary association, i.e. the one with which the child node was created.
//     * 
//     * @param parentRef the parent end of the association
//     * @param childRef the child end of the association
//     * @throws InvalidNodeRefException if the parent or child nodes could not be found
//     */
//    public void removeChild(NodeRef parentRef, String temp, NodeRef childRef) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//
//    /**
//     * Removes named child associations and deletes the children where the association
//     * was the primary association, i.e. the one with which the child node was created.
//     * 
//     * @param parentRef the parent of the associations to remove
//     * @param name the name of the associations to remove
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public void removeChildren(NodeRef parentRef, String name) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * @param nodeRef
//     * @return Returns the type of the node
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public String getType(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        //TODO
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * @param nodeRef
//     * @return Returns all properties
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public Map<String, String> getProperties(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        //TODO
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * @param nodeRef
//     * @param propertyName the fully qualified name of the property
//     * @return Returns the value of the property, or null if not yet set
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public String getProperty(NodeRef nodeRef, String propertyName) throws InvalidNodeRefException
//    {
//        //TODO
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * 
//     * @param nodeRef
//     * @param properties all the properties of the node
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public void setProperties(NodeRef nodeRef, Map<String, String> properties) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * @param nodeRef
//     * @param propertyName the fully qualified name of the property
//     * @param propertyValue the value of the property
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public void setProperty(NodeRef nodeRef, String propertyName, String propertyValue) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * @param nodeRef the child node
//     * @return Returns a collection of <code>NodeRef</code> instances
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public Collection<NodeRef> getParents(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * @param nodeRef the parent node - must be a <b>container</b>
//     * @return Returns a collection of <code>NodeRef</code> instances
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public Collection<NodeRef> getChildrenAssocs(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        // TODO what so we do here !!??  get the children I guess
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * @param nodeRef
//     * @return Returns Fetches the primary parent of the node unless it is a root node,
//     *      in which case null is returned.
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public NodeRef getPrimaryParent(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * 
//     * @param sourceRef a reference to a <b>real</b> node
//     * @param targetRef a reference to a node
//     * @param assocName the name of the associaton
//     * @throws InvalidNodeRefException if either of the nodes could not be found
//     * @throws AssociationExistsException
//     */
//    public void createAssociation(NodeRef sourceRef, NodeRef targetRef, String assocName)
//            throws InvalidNodeRefException, AssociationExistsException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * 
//     * @param sourceRef the associaton source node
//     * @param targetRef the association target node
//     * @param assocName name of the association to remove
//     * @throws InvalidNodeRefException if either of the nodes could not be found
//     */
//    public void removeAssociation(NodeRef sourceRef, NodeRef targetRef, String assocName)
//            throws InvalidNodeRefException
//    {
//        // This operation is not supported for a verion store
//        throw new UnsupportedOperationException(MSG_UNSUPPORTED);
//    }
//    
//    /**
//     * @param sourceRef the association source
//     * @param assocName the name of the association
//     * @return Returns a collection of <code>NodeRef</code> instances at the target end of the
//     *      named association for which the given node is a source
//     * @throws InvalidNodeRefException if the source node could not be found
//     */
//    public Collection<NodeRef> getAssociationTargets(NodeRef sourceRef, String assocName)
//            throws InvalidNodeRefException
//    {
//        // TODO I guess we do this too ??
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * @param targetRef the association target
//     * @param assocName the name of the association
//     * @return Returns a collection of <code>NodeRef</code> instances at the source of the
//     *      named association for which the given node is a target
//     * @throws InvalidNodeRefException
//     */
//    public Collection<NodeRef> getAssociationSources(NodeRef targetRef, String assocName)
//            throws InvalidNodeRefException
//    {
//        // TODO ??
//        throw new UnsupportedOperationException();
//    }
//    
//    /**
//     * @param nodeRef
//     * @return Returns the path to the node along the primary node path
//     * @throws InvalidNodeRefException if the node could not be found
//     * 
//     * @see #getPaths(NodeRef, boolean)
//     */
//    public Path getPath(NodeRef nodeRef) throws InvalidNodeRefException
//    {
//        // TODO ??
//        throw new UnsupportedOperationException();   
//    }
//    
//    /**
//     * @param nodeRef
//     * @param primaryOnly true if only the primary path must be retrieved.  If true, the
//     *      result will have exactly one entry.
//     * @return Returns a collection of all possible paths to the given node
//     * @throws InvalidNodeRefException if the node could not be found
//     */
//    public Collection<Path> getPaths(NodeRef nodeRef, boolean primaryOnly) throws InvalidNodeRefException
//    {
//        // TODO ??
//        throw new UnsupportedOperationException();
//    }
}
