public class IdCard {
    String id;
    String fname;
    String lname;
    int count = 5;
    // Con1
    public IdCard(String id, String fname, String lname){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }
    // Con2
    public IdCard(){
        this.id = "1101801253002";
        this.fname = "patiparn";
        this.lname = "lakorn";
        // this.count = count;
    }

    @Override
    public String toString() {
        return "IdCard [id=" + id + ", fname=" + fname + ", lname=" + lname + ", count="+ count + "]";
    }
}
