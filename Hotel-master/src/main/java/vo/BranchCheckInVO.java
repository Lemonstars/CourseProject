package vo;

/**
 * Created by starrylemon on 2017/3/16.
 */
public class BranchCheckInVO {

    int id;
    String city;
    String address;
    int numOfRoom;
    int numOfReserve;
    int numOfUse;
    String rateOfUse;

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public void setNumOfReserve(int numOfReserve) {
        this.numOfReserve = numOfReserve;
    }

    public void setNumOfUse(int numOfUse) {
        this.numOfUse = numOfUse;
    }

    public void setRateOfUse(String rateOfUse) {
        this.rateOfUse = rateOfUse;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }

    public int getNumOfReserve() {
        return numOfReserve;
    }

    public int getNumOfUse() {
        return numOfUse;
    }

    public String getRateOfUse() {
        return rateOfUse;
    }
}
