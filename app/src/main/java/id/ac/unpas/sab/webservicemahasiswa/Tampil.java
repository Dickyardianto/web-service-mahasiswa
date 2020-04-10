package id.ac.unpas.sab.webservicemahasiswa;

public class Tampil {

    String Nrp, Nama, Jurusan;

    public Tampil() {}

    public Tampil(String nrp, String nama, String jurusan) {
        this.Nrp = nrp;
        this.Nama = nama;
        this.Jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "NRP : " + Nrp + "" + "\n" + "Nama : " + Nama + "" + "\n" + "Jurusan : " + Jurusan  + "";
    }
}
