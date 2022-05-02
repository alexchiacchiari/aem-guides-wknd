package com.adobe.aem.guides.wknd.core.models.impl;
import com.adobe.cq.wcm.core.components.models.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.adobe.aem.guides.wknd.core.models.Byline;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;

import javax.annotation.PostConstruct;


@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Byline.class},
        resourceType = {BylineImpl.RESOURCE_TYPE},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class BylineImpl implements Byline {
    protected static final String RESOURCE_TYPE = "wknd/components/byline";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String name;

    @ValueMapValue
    private List<String> occupations;

    @OSGiService
    private ModelFactory modelFactory;

    private Image image;

    @PostConstruct
    private void init() {
        image = modelFactory.getModelFromWrappedRequest(request, request.getResource(), Image.class);
    }

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
        final Image componentImage = getImage();

        if (StringUtils.isBlank(name)) {
            return true;
        } else if (occupations == null || occupations.isEmpty()) {
            return true;
        } else if (componentImage == null || StringUtils.isBlank(componentImage.getSrc())) {
            return true;
        } else {
            return false;
        }
    }



    private Image getImage() {
        return image;
        }
}