import myPackage.Date;
import myPackage.Location;

public class Premium extends Member{

    /**
     * Member constructor
     * Creates an object that represents all members
     *
     * @param fname
     * @param lname
     * @param dob
     * @param location
     */
    public Premium(String fname, String lname, Date dob, Location location) {
        super(fname, lname, dob, location);
    }
    @Override
    public double membershipFee(){
        return 59.99;
    }
}