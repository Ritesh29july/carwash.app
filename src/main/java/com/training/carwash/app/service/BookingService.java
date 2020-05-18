package com.training.carwash.app.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.carwash.app.model.BookingDetails;
import com.training.carwash.app.repository.BookingRepository;

@Service
@Transactional
public class BookingService {


  private Logger log = LoggerFactory.getLogger(this.getClass().getName());

  private BookingRepository bookingRepository;
  @Autowired
  EntityManager em;

  @Autowired
  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public void saveBookingDetails(BookingDetails bookingDetails) {
    log.info("Before save");
    em.persist(bookingDetails);
    // em.save(bookingDetails);
    log.info("After save");
  }

  public BookingDetails getDetails() {
    em.find(BookingDetails.class, 1l);
    return null;

  }
}
