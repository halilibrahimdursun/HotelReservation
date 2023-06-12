package com.application.repositories;

    import com.application.model.Reservation;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    import java.time.LocalDate;
    import java.util.Date;

    @Repository
    public interface ReservationRepository extends CrudRepository<Reservation, Long> {
        Iterable<Reservation> findReservationByCheckOutDateBeforeAndCheckInDateAfter(Date checkInDate, Date checkOutDate);
    }
