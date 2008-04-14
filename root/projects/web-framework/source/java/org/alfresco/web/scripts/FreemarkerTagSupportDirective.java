/*
 * Copyright (C) 2005-2007 Alfresco Software Limited.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.

 * As a special exception to the terms and conditions of version 2.0 of 
 * the GPL, you may redistribute this Program in connection with Free/Libre 
 * and Open Source Software ("FLOSS") applications as described in Alfresco's 
 * FLOSS exception.  You should have recieved a copy of the text describing 
 * the FLOSS exception, and it is also available here: 
 * http://www.alfresco.com/legal/licensing
 */
package org.alfresco.web.scripts;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.alfresco.tools.FakeHttpServletResponse;
import org.alfresco.tools.WrappedHttpServletRequest;
import org.alfresco.web.site.FilterContext;
import org.alfresco.web.site.HttpRequestContext;
import org.alfresco.web.site.RequestContext;
import org.alfresco.web.site.model.Page;
import org.alfresco.web.site.parser.tags.JspPageContextImpl;
import org.alfresco.web.site.parser.tags.JspWriterImpl;
import org.alfresco.web.site.taglib.TagBase;

import freemarker.template.TemplateDirectiveModel;

/**
 * Custom @imports FreeMarker directive.
 * This places the imports into the page
 * 
 * @author Michael Uzquiano
 */
public abstract class FreemarkerTagSupportDirective implements TemplateDirectiveModel
{   
   private RequestContext context;
   
   public FreemarkerTagSupportDirective(RequestContext context)
   {
       this(context, context.getCurrentPage());
   }
   
   public FreemarkerTagSupportDirective(RequestContext context, Page page)
   {
       this.context = context;
   }
   
   public String executeTag(TagBase tag)
   {
       // render the component into dummy objects
       // currently, we can only do this for HttpRequestContext instances
       if(context instanceof HttpRequestContext)
       {
           HttpServletRequest r = (HttpServletRequest) ((HttpRequestContext)context).getRequest();
          
           // execute component with a wrapped request
           WrappedHttpServletRequest request = new WrappedHttpServletRequest(r);
          
           // execute component with a fake response
           FakeHttpServletResponse response = new FakeHttpServletResponse();
           try
           {
               // set up the tag to be processed in wrapped objects
               ServletContext servletContext = r.getSession().getServletContext();
               FilterContext filterContext = new FilterContext(request, response, servletContext);
               PrintWriter writer = new PrintWriter(response.getOutputStream());
               JspWriterImpl jspWriter = new JspWriterImpl(writer, 8*1024, true);
               JspPageContextImpl pageContextImpl = new JspPageContextImpl(filterContext, jspWriter);
               
               // process the tag
               tag.setPageContext(pageContextImpl);
               tag.doStartTag();
               tag.doEndTag();

               // render the output
               jspWriter.flush();
               String output = response.getContentAsString();
               return output;                 
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       return null;
   }
}
 