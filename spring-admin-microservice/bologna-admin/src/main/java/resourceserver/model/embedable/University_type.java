package resourceserver.model.embedable;

public enum University_type {
    yuksekokul("Ön Lisans"),
    fakulte("Lisans"),
    enstitu_yl("Yüksek Lisans"),
    enstitu_d("Doktora");

    private String University_type;
    private University_type(String type){
        this.University_type = type;
    }
    public String getUniversity_type(){
        return this.University_type;
    }
}
