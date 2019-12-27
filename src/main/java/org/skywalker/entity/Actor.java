package org.skywalker.entity;

import java.io.Serializable;

public class Actor implements Serializable {

    public Actor() {}

    public Actor(Integer actorId, String name, String sex, String homeplace, String birthday, String occupation, String alias, String imdbId) {
        this.actorId = actorId;
        this.name = name;
        this.sex = sex;
        this.homeplace = homeplace;
        this.birthday = birthday;
        this.occupation = occupation;
        this.alias = alias;
        this.imdbId = imdbId;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", homeplace='" + homeplace + '\'' +
                ", birthday='" + birthday + '\'' +
                ", occupation='" + occupation + '\'' +
                ", alias='" + alias + '\'' +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }

    private Integer actorId;
    private String name;
    private String sex;
    private String homeplace;
    private String birthday;
    private String occupation;
    private String alias;
    private String imdbId;

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId == null ? null : actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getHomeplace() {
        return homeplace;
    }

    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace == null ? null : homeplace.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId == null ? null : imdbId.trim();
    }
}
