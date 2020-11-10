package resourceserver.model.embedable;

public enum ContributionDegree {
    IYI("İyi"),
    COK_IYI("Çok İyi"),
    ORTA("Orta");

    private final String type;
    private ContributionDegree(String type) {
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
}