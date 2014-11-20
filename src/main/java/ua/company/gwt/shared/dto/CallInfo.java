package ua.company.gwt.shared.dto;

import java.io.Serializable;

/**
 * @author Eugene on 20.07.2014.
 */

public class CallInfo implements Serializable {

    private String destNumber;
    private long callDuration;
    private double cost;
    private CallType callType;
    private long startDate;
    private long endDate;

    public CallInfo() {
    }

    public CallInfo(String destNumber, long callDuration, double cost, CallType callType, long startDate, long endDate) {
        this.destNumber = destNumber;
        this.callDuration = callDuration;
        this.cost = cost;
        this.callType = callType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDestNumber() {
        return destNumber;
    }

    public void setDestNumber(String destNumber) {
        this.destNumber = destNumber;
    }

    public long getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(long callDuration) {
        this.callDuration = callDuration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public CallType getCallType() {
        return callType;
    }

    public void setCallType(CallType callType) {
        this.callType = callType;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CallInfo{" +
                "destNumber='" + destNumber + '\'' +
                ", callDuration=" + callDuration +
                ", cost=" + cost +
                ", callType=" + callType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
