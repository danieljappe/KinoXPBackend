package com.example.kinoxpbackend.config;

import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.repository.EmployeeRepository;
import com.example.kinoxpbackend.repository.SeatRepository;
import com.example.kinoxpbackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class InitData implements CommandLineRunner {

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  TheaterRepository theaterRepository;
  @Autowired
  SeatRepository seatRepository;


  @Override
  public void run(String... args) throws Exception {

      Employee empl1 = new Employee(0L,"pass1",false);
      Employee empl2 = new Employee(0L,"pass2",true);
      employeeRepository.save(empl1);
      employeeRepository.save(empl2);

      theaterAndSeatInitData();

  }

  public void theaterAndSeatInitData(){
      Theater theater1 = new Theater();
      theater1.setTheaterId(0L);
      theater1.setTheaterNumber(1);
      theater1.setTotalSeats(20 * 12);
      theaterRepository.save(theater1);

      for (int row = 1; row <= 20; row++) {
          for (int seatNum = 1; seatNum <= 12; seatNum++) {
              Seat seat = new Seat();
              seat.setSeatId(0L);
              seat.setSeatNumber(row + "-" + seatNum);
              seat.setTheater(theater1);
              seatRepository.save(seat);
          }
      }

      Theater theater2 = new Theater();
      theater2.setTheaterId(0L);
      theater2.setTheaterNumber(2);
      theater2.setTotalSeats(25 * 16);
      theaterRepository.save(theater2);

      for (int row = 1; row <= 25; row++) {
          for (int seatNum = 1; seatNum <= 16; seatNum++) {
              Seat seat = new Seat();
              seat.setSeatId(0L);
              seat.setSeatNumber(row + "-" + seatNum);
              seat.setTheater(theater2);
              seatRepository.save(seat);
          }
      }

  }

}
