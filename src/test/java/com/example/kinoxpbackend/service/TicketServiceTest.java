//package com.example.kinoxpbackend.service;
//
//import com.example.kinoxpbackend.dto.dtoTicket.TicketConverter;
//import com.example.kinoxpbackend.dto.dtoTicket.TicketDTO;
//import com.example.kinoxpbackend.model.Customer;
//import com.example.kinoxpbackend.model.Seat;
//import com.example.kinoxpbackend.model.Showing;
//import com.example.kinoxpbackend.model.Ticket;
//import com.example.kinoxpbackend.repository.CustomerRepository;
//import com.example.kinoxpbackend.repository.SeatRepository;
//import com.example.kinoxpbackend.repository.ShowingRepository;
//import com.example.kinoxpbackend.repository.TicketRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//class TicketServiceTest {
//
//    @Mock
//    private TicketRepository ticketRepository;
//    @Mock
//    private ShowingRepository showingRepository;
//    @Mock
//    private TicketConverter ticketConverter;
//
//    @InjectMocks
//    TicketService ticketService;
//
//    @BeforeEach
//    void init(){
//        //Arrange
//        Customer customer = new Customer();
//        customer.setCustomerPhone("12345678");
//        Showing showing = new Showing();
//        showing.setShowingId(1L);
//        Seat seat = new Seat();
//        seat.setSeatId(1L);
//
//
//        Ticket t1 = new Ticket(1L,customer,showing,seat);
//        List<Ticket> tickets = new ArrayList<>();
//        tickets.add(t1);
//
//
//
//        TicketDTO t1DTO = new TicketDTO("12345678",1L,1L,1L);
//
//
//        Mockito.when(ticketRepository.findAll()).thenReturn(tickets);
//        Mockito.when(ticketConverter.toDTO(t1)).thenReturn(t1DTO);
//        Mockito.when(ticketRepository.findByShowing(showing)).thenReturn(tickets);
//        Mockito.when(showingRepository.findById(1L)).thenReturn(Optional.of(showing));
//
//    }
//
//
//
//    @Test
//    void getAllTickets() {
//        //Act
//        List<TicketDTO> result = ticketService.getAllTickets();
//        List<TicketDTO> testList = new ArrayList<>();
//
//        TicketDTO t1 = new TicketDTO("12345678",1L,1L,1L);
//
//        testList.add(t1);
//
////        Assert
//        assertEquals(testList,result);
//
//    }
//
//    @Test
//    void getTicketFromShowingId() {
////        Act
//        List<TicketDTO> result = ticketService.getTicketFromShowingId(1L);
//        List<TicketDTO> testList = new ArrayList<>();
//        TicketDTO t1 = new TicketDTO("12345678",1L,1L,1L);
//        testList.add(t1);
//
////        Assert
//        assertEquals(testList,result);
//
//    }
//
//
//}