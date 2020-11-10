package resourceserver.model.embedable;

public enum Lecture_type {
    ZORUNLU("Normal Ders (Zorunlu)"),
    SECMELİ("Seçmeli Ders");

    private String type;
    private Lecture_type(String type) {
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}
