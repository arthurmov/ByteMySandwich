package com.pluralsight.interfaces;

import java.util.List;

public interface Flavored {
    String getFlavor();
    void setFlavor(String flavor);
    List<String> getAvailableFlavbors();
}
