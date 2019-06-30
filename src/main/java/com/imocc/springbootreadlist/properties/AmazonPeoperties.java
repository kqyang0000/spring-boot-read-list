package com.imocc.springbootreadlist.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by kayang on 2019/6/30
 */
@Component
@ConfigurationProperties(prefix = "amazon")
public class AmazonPeoperties {
    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}

