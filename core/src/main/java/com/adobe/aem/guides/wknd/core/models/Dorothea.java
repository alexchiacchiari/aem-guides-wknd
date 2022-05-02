package com.adobe.aem.guides.wknd.core.models;
import java.util.List;

public interface Dorothea {

    List<String> getPaths();
    List<String> getWebsites();

    boolean isChildrenEmpty();

    boolean isWebsitesEmpty();
}