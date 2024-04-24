public class Soba {
    private Integer brojSprata, brojSobe, brojKreveta;
    private Boolean imaKlimu, imaTV, imaTelefon, imaInternet, zauzetaSoba;
    private String dodatniOpis;

    /**
     * Konstruktor sa podrazumijevanim vrijednostima objekta klase Soba.
     * Kreira dvokrevetnu sobu na prvom spratu sa TV-om, kao podrazumijevanu
     * vrijednost.
     */
    public Soba() {
        this.brojSprata = 1;
        this.brojSobe = 1;
        this.brojKreveta = 2;

        this.imaKlimu = false;
        this.imaTelefon = false;
        this.imaInternet = false;
        this.imaTV = true;

        this.dodatniOpis = "";
        this.zauzetaSoba = false;
    }

    /**
     * Inicijalizirajuci konstruktor objekta klase Soba.
     * 
     * @param
     */
    public Soba(
            Integer brojSprata, Integer brojSobe, Integer brojKreveta,
            Boolean imaKlimu, Boolean imaTV, Boolean imaTelefon, Boolean imaInternet,
            String dodatniOpis) {
        this.brojSprata = brojSprata;
        this.brojSobe = brojSobe;
        this.brojKreveta = brojKreveta;

        this.imaKlimu = imaKlimu;
        this.imaTelefon = imaTelefon;
        this.imaInternet = imaInternet;
        this.imaTV = imaTV;

        this.dodatniOpis = dodatniOpis;
        this.zauzetaSoba = false;
    }

    public void setBrojSobe(Integer brojSobe) {
        this.brojSobe = brojSobe;
    }

    public void setBrojSprata(Integer brojSprata) {
        this.brojSprata = brojSprata;
    }

    public void setBrojKreveta(Integer brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public void setImaKlimu(Boolean imaKlimu) {
        this.imaKlimu = imaKlimu;
    }

    public void setImaTV(Boolean imaTV) {
        this.imaTV = imaTV;
    }

    public void setImaTelefon(Boolean imaTelefon) {
        this.imaTelefon = imaTelefon;
    }

    public void setImaInternet(Boolean imaInternet) {
        this.imaInternet = imaInternet;
    }

    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }

    public void setZauzetaSoba(Boolean zauzetaSoba) {
        this.zauzetaSoba = zauzetaSoba;
    }

    public Integer getBrojSobe() {
        return this.brojSobe;
    }

    public Integer getBrojSprata() {
        return this.brojSprata;
    }

    public Integer getBrojKreveta() {
        return this.brojKreveta;
    }

    public Boolean getImaKlimu() {
        return this.imaKlimu;
    }

    public Boolean getImaTV() {
        return this.imaTV;
    }

    public Boolean getImaTelefon() {
        return this.imaTelefon;
    }

    public Boolean getImaInternet() {
        return this.imaInternet;
    }

    public String getDodatniOpis() {
        return this.dodatniOpis;
    }

    public Boolean getZauzetaSoba() {
        return this.zauzetaSoba;
    }
}
