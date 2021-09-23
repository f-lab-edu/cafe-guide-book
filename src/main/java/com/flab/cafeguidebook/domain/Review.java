package com.flab.cafeguidebook.domain;

import java.util.Date;

public class Review {

  private Long id;
  private Long cafeId;
  private Long userId;
  private Date createAt;
  private int score;
  private String content;

  public Review() {
  }

  public Review(Review.Builder builder) {
    this.id = builder.id;
    this.cafeId = builder.cafeId;
    this.userId = builder.userId;
    this.createAt = builder.createAt;
    this.score = builder.score;
    this.content = builder.content;
  }

  public Review(Long id, Long cafeId, Long userId, Date createAt, int score,
      String content) {
    this.id = id;
    this.cafeId = cafeId;
    this.userId = userId;
    this.createAt = createAt;
    this.score = score;
    this.content = content;
  }


  public static Review.Builder builder() {
    return new Review.Builder();
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

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
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
    private int score;
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

    public Review.Builder score(int score) {
      this.score = score;
      return this;
    }

    public Review.Builder content(String content) {
      this.content = content;
      return this;
    }

    public Review build() {
      return new Review(this);
    }
  }
}
