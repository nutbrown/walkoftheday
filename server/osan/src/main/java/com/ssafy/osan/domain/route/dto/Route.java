package com.ssafy.osan.domain.route.dto;

import com.ssafy.osan.domain.spot.dto.Spot;

import java.util.Date;
import java.util.List;

public class Route {
    private int routeId;
    private String title;
    private String content;
    private String writer;
    private String points;
    private int views;
    private int rating;
    private int time;
    private int image;
    private Date cretedAt;
    private Date updatedAt;
    private List<Spot> spots;

    public Route() {
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Date getCretedAt() {
        return cretedAt;
    }

    public void setCretedAt(Date cretedAt) {
        this.cretedAt = cretedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", points='" + points + '\'' +
                ", views=" + views +
                ", rating=" + rating +
                ", time=" + time +
                ", image=" + image +
                ", cretedAt=" + cretedAt +
                ", updatedAt=" + updatedAt +
                ", spots=" + spots +
                '}';
    }
}
