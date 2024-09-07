package bo.com.bancobisa.msas.blog.entities;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author leandro.escalera
 */
@Entity
@Table(name = "author")
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "names_", length = 150)
  private String names;
  @Basic
  @Column(name = "first_surname", length = 150)
  private String firstSurname;
  @Basic
  @Column(name = "second_surname", length = 150)
  private String secondSurname;
  @Basic
  @Column(name = "birth_date")
  private Date birthDate;
  @Basic
  @Column(name = "country_residence", length = 100)
  private String countryResidence;
  @Basic
  @Column(name = "mail", length = 250)
  private String mail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getFirstSurname() {
    return firstSurname;
  }

  public void setFirstSurname(String firstSurname) {
    this.firstSurname = firstSurname;
  }

  public String getSecondSurname() {
    return secondSurname;
  }

  public void setSecondSurname(String secondSurname) {
    this.secondSurname = secondSurname;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getCountryResidence() {
    return countryResidence;
  }

  public void setCountryResidence(String countryResidence) {
    this.countryResidence = countryResidence;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}