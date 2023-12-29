package motelManagementSystem.classes;

public class Room {
    private String number;
    private String name;
    private int money;
    private int energy;
    private int water;
    private int wifi;
    private int extra;
    private int total;
    private String status;

    public Room() {
    }

    public Room(String number, String name, int money, int energy, int water, int wifi, int extra, int total, String status) {
        this.number = number;
        this.name = name;
        this.money = money;
        this.energy = energy;
        this.water = water;
        this.wifi = wifi;
        this.extra = extra;
        this.total = total;
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
}
