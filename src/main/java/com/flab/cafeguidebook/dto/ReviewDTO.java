package com.flab.cafeguidebook.dto;

import java.util.Date;
import org.springframework.lang.NonNull;

public class ReviewDTO {

  private Long id;
  @NonNull
  private Long cafeId;
  @NonNull
  private Long userId;
  private Date createAt;
  @NonNull
  private int score;
  @NonNull
  private String content;

  public ReviewDTO() {
  }

  public ReviewDTO(ReviewDTO.Builder builder) {
    this.id = builder.id;
    this.cafeId = builder.cafeId;
    this.userId = builder.userId;
    this.createAt = builder.createAt;
    this.score = builder.score;
    this.content = builder.content;
  }

  public ReviewDTO(Long id, Long cafeId, Long userId, Date createAt, int score,
      String content) {
    this.id = id;
    this.cafeId = cafeId;
    this.userId = userId;
    this.createAt = createAt;
    this.score = score;
    this.content = content;
  }

  public static ReviewDTO.Builder builder() {
    return new ReviewDTO.Builder();
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

    public ReviewDTO.Builder Builder() {
      return this;
    }

    public ReviewDTO.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public ReviewDTO.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public ReviewDTO.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public ReviewDTO.Builder createAt(Date createAt) {
      this.createAt = createAt;
      return this;
    }

    public ReviewDTO.Builder score(int score) {
      this.score = score;
      return this;
    }

    public ReviewDTO.Builder content(String content) {
      this.content = content;
      return this;
    }

    public ReviewDTO build() {
      return new ReviewDTO(this);
    }

  }
}
