//package ont.athleteapp.training.speed;
//
//import ont.athleteapp.training.Training;
//
//import javax.persistence.*;
//
//@Entity
//public class SpeedTraining  extends Training {
//
//
//    private String blocks;
//    private String subMax;
//    private String maxSpeed;
//    private String assistedSpeed;
//
//    public SpeedTraining() {
//
//    }
//    public SpeedTraining(String blocks, String subMax, String maxSpeed, String assistedSpeed){
//        this.assistedSpeed = assistedSpeed;
//        this.maxSpeed = maxSpeed;
//        this.subMax = subMax;
//        this.blocks = blocks;
//    }
//
//    public String getBlocks() {
//        return blocks;
//    }
//
//    public void setBlocks(String blocks) {
//        this.blocks = blocks;
//    }
//
//    public String getSubMax() {
//        return subMax;
//    }
//
//    public void setSubMax(String subMax) {
//        this.subMax = subMax;
//    }
//
//    public String getMaxSpeed() {
//        return maxSpeed;
//    }
//
//    public void setMaxSpeed(String maxSpeed) {
//        this.maxSpeed = maxSpeed;
//    }
//
//    public String getAssistedSpeed() {
//        return assistedSpeed;
//    }
//
//    public void setAssistedSpeed(String assistedSpeed) {
//        this.assistedSpeed = assistedSpeed;
//    }
//
//    @Override
//    public String toString() {
//        return "SpeedTraining{" +
//                "blocks='" + blocks + '\'' +
//                ", subMax='" + subMax + '\'' +
//                ", maxSpeed='" + maxSpeed + '\'' +
//                ", assistedSpeed='" + assistedSpeed + '\'' +
//                '}';
//    }
//}
