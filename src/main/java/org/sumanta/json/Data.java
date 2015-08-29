
package org.sumanta.json;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Data {

    @Expose
    private List<Translation> translations = new ArrayList<Translation>();

    /**
     * 
     * @return
     *     The translations
     */
    public List<Translation> getTranslations() {
        return translations;
    }

    /**
     * 
     * @param translations
     *     The translations
     */
    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

}
