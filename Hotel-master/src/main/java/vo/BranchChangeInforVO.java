package vo;

/**
 * Created by starrylemon on 2017/3/18.
 */
public class BranchChangeInforVO {

    int    branchId;
    String city;
    String address;
    String icard;
    int numOfRoom;

    public BranchChangeInforVO(int branchId,String city, String address, String icard, int numOfRoom) {
        this.branchId=branchId;
        this.city = city;
        this.address = address;
        this.icard = icard;
        this.numOfRoom = numOfRoom;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIcard(String icard) {
        this.icard = icard;
    }

    public void setNumOfRoom(int numOfRoom) {
        this.numOfRoom = numOfRoom;
    }

    public int getBranchId() {
        return branchId;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getIcard() {
        return icard;
    }

    public int getNumOfRoom() {
        return numOfRoom;
    }
}
