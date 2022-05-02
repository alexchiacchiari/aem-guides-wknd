package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.Dorothea;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.*;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        adapters = {Dorothea.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class DorotheaImpl implements Dorothea {
    @ValueMapValue(
            name = "children"
    )
    private List<String> paths;

    @ValueMapValue(
            name = "websites"
    )
    private List<String> websites;

    @SlingObject
    private ResourceResolver resourceResolver;

    @Override
    public List<String> getPaths() {
        if (!paths.isEmpty()){
            return new ArrayList<>(paths);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> getWebsites() {
        if (!websites.isEmpty()) {
            return new ArrayList<>(websites);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean isChildrenEmpty() {
        return getPaths().isEmpty();
    }

    @Override
    public boolean isWebsitesEmpty() {
        return getWebsites().isEmpty();
    }
}