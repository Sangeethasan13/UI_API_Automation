package org.payLoad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ResPayload {
    private String status;
    private String place_id;
    private String scope;
    private String reference;
    private String id;
}
