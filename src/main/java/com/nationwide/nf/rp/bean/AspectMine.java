package com.nationwide.nf.rp.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jorgej2 on 9/10/2017.
 */
@XmlRootElement(name="aspectMine")
public class AspectMine {

    private String clusteringAlgorithm;
    private String vectorSpaceModel;

    // Cross Cutting Concern Category
    private String orderedMethodCall;
    private String codeClone;
    private String uniqueClassFanIn;
    private String callsInClones;
    private String callsAtBeginningAndEndOfMethod;
    private String eventAsParameter;
    private String singleton;
    private String observer;
    private String chainOfResponsibility;
    private String crossCuttingConcernAsInterface;

    public String getClusteringAlgorithm() {
        return clusteringAlgorithm;
    }

    public void setClusteringAlgorithm(String clusteringAlgorithm) {
        this.clusteringAlgorithm = clusteringAlgorithm;
    }

    public String getVectorSpaceModel() {
        return vectorSpaceModel;
    }

    public void setVectorSpaceModel(String vectorSpaceModel) {
        this.vectorSpaceModel = vectorSpaceModel;
    }

    public String getOrderedMethodCall() {
        return orderedMethodCall;
    }

    public void setOrderedMethodCall(String orderedMethodCall) {
        this.orderedMethodCall = orderedMethodCall;
    }

    public String getCodeClone() {
        return codeClone;
    }

    public void setCodeClone(String codeClone) {
        this.codeClone = codeClone;
    }

    public String getUniqueClassFanIn() {
        return uniqueClassFanIn;
    }

    public void setUniqueClassFanIn(String uniqueClassFanIn) {
        this.uniqueClassFanIn = uniqueClassFanIn;
    }

    public String getCallsInClones() {
        return callsInClones;
    }

    public void setCallsInClones(String callsInClones) {
        this.callsInClones = callsInClones;
    }

    public String getCallsAtBeginningAndEndOfMethod() {
        return callsAtBeginningAndEndOfMethod;
    }

    public void setCallsAtBeginningAndEndOfMethod(String callsAtBeginningAndEndOfMethod) {
        this.callsAtBeginningAndEndOfMethod = callsAtBeginningAndEndOfMethod;
    }

    public String getEventAsParameter() {
        return eventAsParameter;
    }

    public void setEventAsParameter(String eventAsParameter) {
        this.eventAsParameter = eventAsParameter;
    }

    public String getSingleton() {
        return singleton;
    }

    public void setSingleton(String singleton) {
        this.singleton = singleton;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getChainOfResponsibility() {
        return chainOfResponsibility;
    }

    public void setChainOfResponsibility(String chainOfResponsibility) {
        this.chainOfResponsibility = chainOfResponsibility;
    }

    public String getCrossCuttingConcernAsInterface() {
        return crossCuttingConcernAsInterface;
    }

    public void setCrossCuttingConcernAsInterface(String crossCuttingConcernAsInterface) {
        this.crossCuttingConcernAsInterface = crossCuttingConcernAsInterface;
    }

    @Override
    public String toString() {
        return "AspectMine{" +
                "clusteringAlgorithm='" + clusteringAlgorithm + '\'' +
                ", vectorSpaceModel='" + vectorSpaceModel + '\'' +
                ", orderedMethodCall='" + orderedMethodCall + '\'' +
                ", codeClone='" + codeClone + '\'' +
                ", uniqueClassFanIn='" + uniqueClassFanIn + '\'' +
                ", callsInClones='" + callsInClones + '\'' +
                ", callsAtBeginningAndEndOfMethod='" + callsAtBeginningAndEndOfMethod + '\'' +
                ", eventAsParameter='" + eventAsParameter + '\'' +
                ", singleton='" + singleton + '\'' +
                ", observer='" + observer + '\'' +
                ", chainOfResponsibility='" + chainOfResponsibility + '\'' +
                ", crossCuttingConcernAsInterface='" + crossCuttingConcernAsInterface + '\'' +
                '}';
    }
}
