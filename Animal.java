package edu.ucalgary.oop;

public class Animal {

    private final String SPECIES;
    private final String ACTIVITY;
    private final String RESCTYPE;
    private final int FEED_TIME;
    private final int CLEANING_TIME;
    private final int PREP_TIME;
    private final int FEED_WINDOW;
    //private final static String[] ACTYPE = {"Nocturnal", "Diurnal", "Crepuscular"};

    private Vet vet;
    private Volunteer[] volunteer;

    Animal(String SPECIES, String ACTIVITY, String RESCTYPE, String ActivityType, Vet vet, Volunteer volunteer, int FEED_TIME, int CLEANING_TIME, int PREP_TIME, int FEED_WINDOW){
        this.SPECIES = SPECIES;
            switch (SPECIES.toLowerCase()){
                case "porcupine":
                    this.CLEANING_TIME = 10;
                    this.FEED_TIME = 5;
                    this.FEED_WINDOW = 3;
                    this.PREP_TIME = 0;
                    break;
                case "coyote":
                   this.CLEANING_TIME = 10;
                    this.FEED_TIME = 5;
                    this.FEED_WINDOW = 3;
                    this.PREP_TIME = 10;
                    break;
                case "fox" :
                    this.CLEANING_TIME = 5;
                    this.FEED_TIME = 5;
                    this.FEED_WINDOW = 3;
                    this.PREP_TIME = 5;
                    break;
                case "beaver":
                    this.CLEANING_TIME = 5;
                    this.FEED_TIME = 5;
                    this.FEED_WINDOW = 5;
                   this.PREP_TIME = 0;
                    break;
                case "raccoon":
                    this.CLEANING_TIME = 5;
                    this.FEED_TIME = 5;
                    this.FEED_WINDOW = 3;
                    this.PREP_TIME = 0;
                    break;
                default:
                    this.PREP_TIME = PREP_TIME;
                    this.FEED_WINDOW = FEED_WINDOW;
                    this.FEED_TIME = FEED_TIME;
                    this.CLEANING_TIME = CLEANING_TIME;
            }
        this.ACTIVITY = ACTIVITY;
        this.RESCTYPE = RESCTYPE;
        boolean valid_resc_type = false;
        for(var act_type: ActType.values()){
            if(ActivityType.equalsIgnoreCase(act_type.toString())){
                RESCTYPE = act_type.toString();
                break;
            }
        }
        if(valid_resc_type == false){
            throw new IllegalArgumentException("Rescue Type is not valid");
        }
    }
    public String getSPECIES(){
        return this.SPECIES;
    }
    public String getACTIVITY(){
        return this.ACTIVITY;
    }
    public String getRESCTYPE(){
        return this.RESCTYPE;
    }
    public Volunteer[] getVolunteer(int index_of_Volunteer){
        return this.volunteer;
    }
    public void setVolunteer(Volunteer[] volunteer){
        this.volunteer = volunteer;
    }
    public void setVet(Vet vet){
        this.vet = vet;
    }
}
