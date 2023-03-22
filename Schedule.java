package edu.ucalgary.oop;

public class Schedule {
    private double timeStart;
    private double timeEnd;
    private double breakStart;
    private double breakEnd;
    Schedule(double timeStart, double timeEnd) throws IllegalScheduleChangeException {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        /*this.breakStart = (timeEnd - timeStart)/2 + timeStart;
        this.breakEnd = breakStart + 1;*/
        if(getShiftLength()> 8){
            throw new IllegalScheduleChangeException("The length is greater than 8 hours");
        }
        else if(timeStart>24 || timeEnd > 24){
            throw new IllegalScheduleChangeException("Please double check your input for time start and end");
        }

    }
    public double getShiftStart(){
        return this.timeStart;
    }
    public double getShiftEnd(){
        return this.timeEnd;
    }
    public double getShiftLength(){
        return (this.getShiftEnd() - this.getShiftStart());
    }
    public double getBreak(){
        return this.breakStart;
    }
    public double getBreakEnd(){
        return this.breakEnd;
    }
    public void setTimeStart(double start){
        this.timeStart = start;
    }
    public void setTimeEnd(double end){
        this.timeEnd = end;
    }
}
