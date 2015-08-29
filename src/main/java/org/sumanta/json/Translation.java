
package org.sumanta.json;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Translation {

    @Expose
    private String translatedText;

    /**
     * 
     * @return
     *     The translatedText
     */
    public String getTranslatedText() {
        return translatedText;
    }

    /**
     * 
     * @param translatedText
     *     The translatedText
     */
    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

}
