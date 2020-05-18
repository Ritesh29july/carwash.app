package com.training.carwash.app.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.training.carwash.app.model.BookingDetails;
import com.training.carwash.app.service.BookingService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarWashBookingController {


  private Logger log = LoggerFactory.getLogger(this.getClass().getName());

  private BookingService bookingService;

  @Autowired
  public CarWashBookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  List<BookingDetails> list = new ArrayList<>();

  @PostMapping
  @RequestMapping("/booking")
  public ResponseEntity<HttpStatus> receiveEvent(@RequestBody BookingDetails bookingDetails) {
    boolean processed = true;
    log.info("inside method " + bookingDetails);
    list.add(bookingDetails);
    bookingService.saveBookingDetails(bookingDetails);
    return new ResponseEntity<>(processed ? HttpStatus.OK : HttpStatus.NO_CONTENT);
  }

  @GetMapping
  @RequestMapping("/getDetails")
  public ResponseEntity<List<BookingDetails>> getDetails() {

    bookingService.getDetails();
    log.info("inside method " + list);

    return new ResponseEntity<>(list, HttpStatus.OK);
  }
}
