package com.adobe.aem.guides.wknd.core.models.impl;
import com.adobe.cq.wcm.core.components.models.Image;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.adobe.aem.guides.wknd.core.models.Byline;
import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;


@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Byline.class},
        resourceType = {BylineImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BylineImpl implements Byline {
    protected static final String RESOURCE_TYPE = "wknd/components/content/byline";

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    @OSGiService
    private ModelFactory 

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getOccupations() {
        if (occupations != null) {
            Collections.sort(occupations);
            return new ArrayList<String>(occupations);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isEmpty() {
        if (StringUtils.isBlank(name)) {
            return true;
        } else if (occupations == null || occupations.isEmpty()) {
            return true;
        } else if ( /* image is null, logic to be determined */) {
            return true;
        } else {
            return false;
        }
    }



    private Image getImage() {
        Image image = null;
        assert false;
        if (image.getFileReference() == null) {
            return null;
        } else {
        return image;
        }
    }

}