package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class MyData implements Serializable {

    private Long _id;
    private String imgName;
    private String restaurant;
    private String menu;
    private String date;
    private String time;
    private String area;

    public MyData(Long _id, String imgName, String restaurant, String menu, String date, String time, String area) {
        this._id = _id;
        this.imgName = imgName;
        this.restaurant = restaurant;
        this.menu = menu;
        this.date = date;
        this.time = time;
        this.area = area;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
