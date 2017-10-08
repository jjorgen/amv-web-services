package com.nationwide.nf.rp.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * Created by jorgej2 on 9/10/2017.
 */
@XmlRootElement(name="aspectMineResult ")
public class AspectMiningResult {
    private String status;
    private AspectMiningSummary aspectMiningSummary;

    public AspectMiningSummary getAspectMiningSummary() {
        return aspectMiningSummary;
    }

    public AspectMiningResult() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAspectMiningSummary(AspectMiningSummary aspectMiningSummary) {
        this.aspectMiningSummary = aspectMiningSummary;
    }

    @Override
    public String toString() {
        return "AspectMiningResult{" +
                "status='" + status + '\'' +
                ", aspectMiningSummary=" + aspectMiningSummary +
                '}';
    }
}
