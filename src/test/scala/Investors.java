import java.util.Date;

/**
 * @author conandk on 4/10/18
 * @project esi
 * @className ${CLASS_NAME}
 */
 class Investor {

  private Date updatedAt;

  private String id;

  private String coachId;

  private String email;

  private Date createdAt;


  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCoachId() {
    return coachId;
  }

  public void setCoachId(String coachId) {
    this.coachId = coachId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Investor Class{" + "updatedAt=" + updatedAt + ", id='" + id + '\'' + ", coachId='" +
        coachId
        + '\'' + ", email='" + email + '\'' + ", createdAt=" + createdAt + '}';
  }
}

