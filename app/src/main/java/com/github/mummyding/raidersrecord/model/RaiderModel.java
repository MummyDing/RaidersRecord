package com.github.mummyding.raidersrecord.model;

/**
 * Created by MummyDing on 16-3-16.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public class RaiderModel {

    private String imageUri;
    private String activityTitle;
    private String currentDateState;
    private String finishedTime;
    private int participantCount;
    private String winner;


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getCurrentDateState() {
        return currentDateState;
    }

    public void setCurrentDateState(String currentDateState) {
        this.currentDateState = currentDateState;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }


    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public boolean isFinished(){
        return winner!=null && !winner.isEmpty();
    }
}
