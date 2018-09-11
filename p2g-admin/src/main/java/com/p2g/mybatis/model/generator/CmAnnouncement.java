package com.p2g.mybatis.model.generator;

import java.io.Serializable;
import java.util.Date;

public class CmAnnouncement implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_announcement.announcement_id
     *
     * @mbggenerated
     */
    private Long announcementId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_announcement.announce_title
     *
     * @mbggenerated
     */
    private String announceTitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_announcement.announce_uri
     *
     * @mbggenerated
     */
    private String announceUri;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_announcement.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cm_announcement.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cm_announcement
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_announcement.announcement_id
     *
     * @return the value of cm_announcement.announcement_id
     *
     * @mbggenerated
     */
    public Long getAnnouncementId() {
        return announcementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_announcement.announcement_id
     *
     * @param announcementId the value for cm_announcement.announcement_id
     *
     * @mbggenerated
     */
    public void setAnnouncementId(Long announcementId) {
        this.announcementId = announcementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_announcement.announce_title
     *
     * @return the value of cm_announcement.announce_title
     *
     * @mbggenerated
     */
    public String getAnnounceTitle() {
        return announceTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_announcement.announce_title
     *
     * @param announceTitle the value for cm_announcement.announce_title
     *
     * @mbggenerated
     */
    public void setAnnounceTitle(String announceTitle) {
        this.announceTitle = announceTitle == null ? null : announceTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_announcement.announce_uri
     *
     * @return the value of cm_announcement.announce_uri
     *
     * @mbggenerated
     */
    public String getAnnounceUri() {
        return announceUri;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_announcement.announce_uri
     *
     * @param announceUri the value for cm_announcement.announce_uri
     *
     * @mbggenerated
     */
    public void setAnnounceUri(String announceUri) {
        this.announceUri = announceUri == null ? null : announceUri.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_announcement.create_time
     *
     * @return the value of cm_announcement.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_announcement.create_time
     *
     * @param createTime the value for cm_announcement.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cm_announcement.update_time
     *
     * @return the value of cm_announcement.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cm_announcement.update_time
     *
     * @param updateTime the value for cm_announcement.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_announcement
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", announcementId=").append(announcementId);
        sb.append(", announceTitle=").append(announceTitle);
        sb.append(", announceUri=").append(announceUri);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_announcement
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmAnnouncement other = (CmAnnouncement) that;
        return (this.getAnnouncementId() == null ? other.getAnnouncementId() == null : this.getAnnouncementId().equals(other.getAnnouncementId()))
            && (this.getAnnounceTitle() == null ? other.getAnnounceTitle() == null : this.getAnnounceTitle().equals(other.getAnnounceTitle()))
            && (this.getAnnounceUri() == null ? other.getAnnounceUri() == null : this.getAnnounceUri().equals(other.getAnnounceUri()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cm_announcement
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAnnouncementId() == null) ? 0 : getAnnouncementId().hashCode());
        result = prime * result + ((getAnnounceTitle() == null) ? 0 : getAnnounceTitle().hashCode());
        result = prime * result + ((getAnnounceUri() == null) ? 0 : getAnnounceUri().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}