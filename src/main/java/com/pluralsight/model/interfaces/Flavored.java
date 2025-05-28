package com.pluralsight.model.interfaces;

import java.util.List;

public interface Flavored {
    String getFlavor();
    void setFlavor(String flavor);
    List<String> getAvailableFlavbors();
}
