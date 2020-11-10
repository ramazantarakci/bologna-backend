package resourceserver.model.embedable;

public enum Evaluation_type {
    ARASINAV_SAYI("ARA SINAV->SAYI"),
    ARASINAV_KATKIPAYI("ARA SINAV->KATKI PAYI"),
    FINAL_SAYI("FINAL->SAYI"),
    FINAL_KATKIPAYI("FINAL->KATKI PAYI");

    private final String type;
    private Evaluation_type(String type) {
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}
