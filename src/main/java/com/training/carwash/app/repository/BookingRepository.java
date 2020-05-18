package com.training.carwash.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.training.carwash.app.model.BookingDetails;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Long> {

}
