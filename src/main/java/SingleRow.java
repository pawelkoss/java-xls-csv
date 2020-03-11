import java.util.Objects;

public class SingleRow{

    public int id;
    public String skrot;
    public String city;
    public int CLF2007;
    public int EMP2007;
    public int UEMP2007;

    public SingleRow() {
    }

    public SingleRow(int id, String skrot, String city, int CLF2007, int EMP2007, int UEMP2007) {
        this.id = id;
        this.skrot = skrot;
        this.city = city;
        this.CLF2007 = CLF2007;
        this.EMP2007 = EMP2007;
        this.UEMP2007 = UEMP2007;
    }

    public int getId() { return id; }

    public String getSkrot() {return skrot;}

    public String getCity() {
        return city;
    }

    public int getCLF2007() {
        return CLF2007;
    }

    public int getEMP2007() {
        return EMP2007;
    }

    public int getUEMP2007() {
        return UEMP2007;
    }

    @Override
    public String toString() {
        return "SingleRow{" +
                "id=" + id +
                ", skrot='" + skrot + '\'' +
                ", city='" + city + '\'' +
                ", CLF2007=" + CLF2007 +
                ", EMP2007=" + EMP2007 +
                ", UEMP2007=" + UEMP2007 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleRow singleRow = (SingleRow) o;
        return id == singleRow.id &&
                CLF2007 == singleRow.CLF2007 &&
                EMP2007 == singleRow.EMP2007 &&
                UEMP2007 == singleRow.UEMP2007 &&
                Objects.equals(skrot, singleRow.skrot) &&
                Objects.equals(city, singleRow.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skrot, city, CLF2007, EMP2007, UEMP2007);
    }


}


