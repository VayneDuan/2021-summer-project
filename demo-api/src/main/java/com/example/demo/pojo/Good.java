package com.example.demo.pojo;

/**
 * 健身产品表
 */
public class Good {
    private Integer id;
    private String detail;
    private String videoUrl;
    private String gym_goods_name;
    private Float price;
    private Integer category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getGym_goods_name() {
        return gym_goods_name;
    }

    public void setGym_goods_name(String gym_goods_name) {
        this.gym_goods_name = gym_goods_name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", gym_goods_name='" + gym_goods_name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
