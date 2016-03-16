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
    private String participantCount;
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

    public String getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(String participantCount) {
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
