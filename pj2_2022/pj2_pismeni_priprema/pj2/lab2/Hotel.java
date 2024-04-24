public class Hotel {
    private Soba[] sobe = new Soba[20];
    private String naziv;
    private String adresa;

    public Hotel() {
        this.naziv = "__hotel__";
        this.adresa = "__adresa__";

        this.initSobe();
    }

    public Hotel(String naziv, String adresa) {
        this.naziv = naziv;
        this.adresa = adresa;

        this.initSobe();
    }

    public Integer brojSlobodnihSoba(Integer brojSprata) {
        Integer brojSlobodnih = 0;

        for (Soba s : this.sobe) {
            if (s.getBrojSprata() == brojSprata && !s.getZauzetaSoba())
                brojSlobodnih++;
        }

        return brojSlobodnih;
    }

    public Boolean rezervisi(Integer brojSprata, Integer brojSobe) {
        for (Soba s : this.sobe) {
            if (s.getBrojSprata() == brojSprata && s.getBrojSobe() == brojSobe && s.getZauzetaSoba()) {
                s.setZauzetaSoba(true);
                return true;
            }
        }

        return false;
    }

    private void initSobe() {
        for (Integer i = 0; i < 20; i++) {
            this.sobe[i] = new Soba();
            this.sobe[i].setBrojSprata((i % 4) + 1);
        }
    }
}
