package com.training.carwash.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class BookingDetails {

  @Id
  @Column(name = "bookingId")
  @GeneratedValue
  private Long bookingId;
  private String name;
  private String address;
  private String carPlateNumber;
  private String contactNumber;
  private String scheduleDate;
  private String description;
  /*
   * public String vehicleName; public String vehicleNumber; public String appointmentDate; public
   * Integer price; public String washPackage; public String assignToWasher; public String status;
   */



}
