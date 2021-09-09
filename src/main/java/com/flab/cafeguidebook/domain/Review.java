package com.flab.cafeguidebook.domain;

import java.util.Date;

public class Review {

  private Long id;
  private Long cafeId;
  private Long userId;
  private Date createAt;
  private float score;
  private String content;

  public Review() {
  }

  public Review(Long id, Long cafeId, Long userId, Date createAt, float score,
      String content) {
    this.id = id;
    this.cafeId = cafeId;
    this.userId = userId;
    this.createAt = createAt;
    this.score = score;
    this.content = content;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCafeId() {
    return cafeId;
  }

  public void setCafeId(Long cafeId) {
    this.cafeId = cafeId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public float getScore() {
    return score;
  }

  public void setScore(float score) {
    this.score = score;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public static class Builder {

    private Long id;
    private Long cafeId;
    private Long userId;
    private Date createAt;
    private float score;
    private String content;

    public Review.Builder Builder() {
      return this;
    }

    public Review.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Review.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public Review.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public Review.Builder createAt(Date createAt) {
      this.createAt = createAt;
      return this;
    }

    public Review.Builder score(float score) {
      this.score = score;
      return this;
    }

    public Review.Builder content(String content) {
      this.content = content;
      return this;
    }

  }
}
