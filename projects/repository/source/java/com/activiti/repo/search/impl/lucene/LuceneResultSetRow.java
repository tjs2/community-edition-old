/*
 * Created on Mar 30, 2005
 * 
 * TODO Comment this class
 * 
 * 
 */
package com.activiti.repo.search.impl.lucene;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

import com.activiti.repo.ref.NodeRef;
import com.activiti.repo.ref.Path;
import com.activiti.repo.ref.QName;
import com.activiti.repo.search.ResultSet;
import com.activiti.repo.search.ResultSetRow;
import com.activiti.repo.search.StringValue;
import com.activiti.repo.search.Value;

/**
 * A row ina result set. Created on the fly.
 * 
 * @author andyh
 * 
 */
public class LuceneResultSetRow implements ResultSetRow
{
    /**
     * The containing result set
     */
    private LuceneResultSet resultSet;

    /**
     * The current position in the containing result set
     */
    private int position;

    /**
     * The current document - cached so we do not get it for each value
     */
    private Document document;

    /**
     * Wrap a position in a lucene Hits class with node support
     * 
     * @param resultSet
     * @param position
     */
    public LuceneResultSetRow(LuceneResultSet resultSet, int position)
    {
        super();
        this.resultSet = resultSet;
        this.position = position;
    }

    /**
     * Support to cache the document for this row
     * 
     * @return
     */
    private Document getDocument()
    {
        if (document == null)
        {
            document = resultSet.getDocument(position);
        }
        return document;
    }

    /*
     * ResultSetRow implementation
     */

    public Value[] getValues()
    {
        Document doc = getDocument();
        List<Value> values = new ArrayList<Value>();
        Enumeration e = doc.fields();
        while (e.hasMoreElements())
        {
            Field field = (Field) e.nextElement();
            // Only returns parameters
            // Id, parents etc has separate support
            if (field.name().charAt(0) == '@')
            {
                values.add(new StringValue(field.stringValue()));
            }
        }
        return values.toArray(new Value[0]);
    }

    public Value getValue(Path path)
    {
        // TODO: implement path base look up against the document or via the
        // node service
        throw new UnsupportedOperationException();
    }

    public NodeRef getNodeRef()
    {
        return resultSet.getNodeRef(position);
    }

    public float getScore()
    {
        return resultSet.getScore(position);
    }

    public ResultSet getResultSet()
    {
        return resultSet;
    }

    public Value getValue(QName qname)
    {
        Document doc = getDocument();
        Value value = new StringValue(doc.get("@" + qname));
        return value;
    }

}
